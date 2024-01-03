package ESINF.US07;

import ESINF.Domain.Coordinates;
import ESINF.Domain.Locality;
import ESINF.Domain.PathInfo;
import ESINF.Structure.Edge;
import ESINF.Structure.Graph;
import ESINF.Structure.GraphAlgorithms;
import ESINF.Structure.MapGraph;

import java.time.LocalTime;
import java.util.*;
import java.util.function.BinaryOperator;

/**
 * This class is responsible for finding the maximum hubs in a given graph based on specified parameters.
 * It uses a recursive depth-first search approach to explore the graph and identify paths with the maximum number of hubs.
 */

public class MaximumHubsFinder {
    public String getOrigin(Locality origin, MapGraph<Locality, Integer> graph){
        StringBuilder stringBuilder = new StringBuilder();
        for (Locality localidades : graph.vertices()) {
            if (localidades.getName().equals(origin.getName())) {
                stringBuilder.append("HubId: ").append(localidades.getName()).append(" ");
                stringBuilder.append("Coordintes: ").append(new Coordinates(localidades.getLatitude(), localidades.getLongitude()));
                origin.setLatitude(localidades.getLatitude());
                origin.setLongitude(localidades.getLongitude());
            }
        }
        return stringBuilder.toString();
    }
    public static PathInfo bestPathFinder(Locality origin, LocalTime startTime, double autonomy, double averageSpeed, double chargeTime, double unloadingTime, MapGraph<Locality, Integer> graph) {
        int numberOfOpenHubs = 0;
        Locality locality = origin;
        LocalTime hour = startTime, remainingTime = LocalTime.of(0, 0), inicialHour = startTime;
        List<Locality> visitedLocalities = new ArrayList<>();
        LinkedList<Locality> actualPath = new LinkedList<>(), bestPath = new LinkedList<>();

        while (remainingTime != null) {
            remainingTime = null;
            for (Locality hub : getHubs(graph)) {
                if (!visitedLocalities.contains(hub)) {
                    LinkedList<Locality> donePath = new LinkedList<>();
                    //GraphAlgorithms.shortestPathWithAutonomy(graph, origin, hub, Comparator.naturalOrder(), Integer::sum, 0, donePath, autonomy);
                    if (getFinalTime(donePath, inicialHour, autonomy, averageSpeed, chargeTime, unloadingTime,
                            getAllHubsOnPath(donePath, visitedLocalities).size(), graph).isBefore(hub.getSchedules().getClosing()) &&
                            getFinalTime(donePath, inicialHour, autonomy, averageSpeed, chargeTime, unloadingTime,
                                    getAllHubsOnPath(donePath, visitedLocalities).size(), graph).isAfter(hub.getSchedules().getOpening())) {
                        if (remainingTime == null ||
                                (getStillOpenHubs(getFinalTime(donePath, inicialHour, autonomy, averageSpeed, chargeTime, unloadingTime, getAllHubsOnPath(donePath, visitedLocalities).size(), graph), graph)
                                        .size() > numberOfOpenHubs
                                        && minusTime(
                                        hub.getSchedules().getClosing(), getFinalTime(donePath, startTime, autonomy, averageSpeed, chargeTime, unloadingTime,
                                                getAllHubsOnPath(donePath, visitedLocalities).size(), graph)).isBefore(remainingTime))) {
                            actualPath = donePath;
                            remainingTime = minusTime(hub.getSchedules().getClosing(), getFinalTime(donePath, startTime, autonomy, averageSpeed, chargeTime, unloadingTime,
                                    getAllHubsOnPath(donePath, visitedLocalities).size(), graph));
                            hour = getFinalTime(donePath, startTime, autonomy, averageSpeed, chargeTime, unloadingTime, getAllHubsOnPath(donePath, visitedLocalities).size(), graph);
                            numberOfOpenHubs = getStillOpenHubs(hour, graph).size();
                        }
                    }
                }
            }

            if (remainingTime != null) {
                if (bestPath.isEmpty()) {
                    bestPath.addAll(actualPath);
                } else if (!actualPath.isEmpty()) {
                    bestPath.removeLast();
                    bestPath.addAll(actualPath);
                }

                if (!bestPath.isEmpty()) {
                    locality = bestPath.getLast();
                    for (int i = 0; i < getAllHubsOnPath(actualPath, visitedLocalities).size(); i++) {
                        visitedLocalities.add(getAllHubsOnPath(actualPath, visitedLocalities).get(i));
                    }
                } else {
                    break;
                }

                for (int i = 0; i < getAllHubsOnPath(actualPath, visitedLocalities).size(); i++) {
                    visitedLocalities.add(getAllHubsOnPath(actualPath, visitedLocalities).get(i));
                }
                startTime = hour;
                remainingTime = null;
            }
        }
            PathInfo pathInfo = dataAnalyze(autonomy, bestPath, graph);
            pathInfo.setArrivalTimes(getTimeTable(pathInfo, startTime, averageSpeed, chargeTime, unloadingTime, graph));
            return pathInfo;
    }
    public static LocalTime getFinalTime(LinkedList<Locality> donePath, LocalTime startTime, double autonomy, double averageSpeed, double chargeTime, double unloadingTime, double numberOfUnloadoings, MapGraph<Locality, Integer> graph){
        LocalTime finalHour = LocalTime.of(0,0);
        PathInfo pathInfo = dataAnalyze(autonomy, donePath, graph);
        finalHour = addTime(finalHour, getFinalTimeOnRoute((int) pathInfo.getTotalDistance(), averageSpeed, startTime));
        for (int i = 0; i < pathInfo.getChargements().size(); i++) {
            finalHour = addTime(finalHour, intToLocalTime((int) chargeTime));
        }
        for (int i = 0; i < numberOfUnloadoings; i++) {
            finalHour = addTime(finalHour, intToLocalTime((int) unloadingTime));
        }
        return finalHour;
    }

    public static LocalTime intToLocalTime (int time){
        double timeInDouble = (double) time / 60;
        LocalTime pathTime = LocalTime.of((int) timeInDouble, (int) ((timeInDouble - (int) timeInDouble) * 60));
        return pathTime;
    }

    public static LocalTime getFinalTimeOnRoute(double totalDistance, double averageSpeed, LocalTime startHour){
        LocalTime finalHour;
        double timeInDouble = ((totalDistance) / 1000) / averageSpeed;
        LocalTime pathTime = LocalTime.of((int) timeInDouble, (int) ((timeInDouble - (int) timeInDouble) * 60));
        finalHour = addTime(startHour, pathTime);
        return finalHour;
    }
    public static LocalTime addTime (LocalTime time, LocalTime time2){
        return time.plusHours(time2.getHour()).plusMinutes(time2.getMinute());
    }

    public static LocalTime minusTime (LocalTime time, LocalTime time2){
        return time.minusHours(time2.getHour()).minusMinutes(time2.getMinute());
    }
    public static Map<Locality, List<LocalTime>> getTimeTable (PathInfo pathInfo, LocalTime startTime, double averageSpeed, double chargeTime, double unloadingTime, MapGraph<Locality, Integer> graph){
        Map<Locality, List<LocalTime>> timeTable = new LinkedHashMap<>();

        for (int i = 1 ; i < pathInfo.getPath().size() ; i++) {
            LocalTime end = getFinalTimeOnRoute(graph.edge(pathInfo.getPath().get(i - 1), pathInfo.getPath().get(i)).getWeight(), averageSpeed, startTime);
            List<LocalTime> hoursList = new ArrayList<>();
            if(pathInfo.getChargements().contains(i)){
                if(pathInfo.getPath().get(i).getHub()){
                    hoursList.add(end.plusMinutes((int) unloadingTime));
                    hoursList.add(end.plusMinutes((int) chargeTime));
                    timeTable.put(pathInfo.getPath().get(i), hoursList);
                    startTime = end.plusMinutes((int)chargeTime).plusMinutes((int) unloadingTime);
                } else{
                    hoursList.add(end);
                    hoursList.add(end.plusMinutes((int) chargeTime));
                    timeTable.put(pathInfo.getPath().get(i), hoursList);
                    startTime = end.plusMinutes( (int) unloadingTime);
                }
            }else{
                if(pathInfo.getPath().get(i).isPromoted()){
                    hoursList.add(end);
                    hoursList.add(end.plusMinutes((int) unloadingTime));
                    timeTable.put(pathInfo.getPath().get(i), hoursList);
                    startTime = end.plusMinutes((int)unloadingTime);
                }else{
                    hoursList.add(end);
                    hoursList.add(end);
                    timeTable.put(pathInfo.getPath().get(i), hoursList);
                    startTime = end;
                }
            }
        }
        return timeTable;
    }
    public static List<Locality> getAllHubsOnPath(LinkedList<Locality> path, List<Locality> visitedLocalities){
        List<Locality> list = new ArrayList<>();
        for (int i = 1; i < path.size(); i++) {
            if(path.get(i).isPromoted()){
                list.add(path.get(i));
            }
        }
        return list;
    }
    public static List<Locality> getStillOpenHubs (LocalTime hour, MapGraph<Locality, Integer> graph){
        List<Locality> result = new ArrayList<>();
        for (Locality locality : getHubs(graph)) {
            if(locality.isPromoted() && locality.getSchedules().getOpening().isBefore(hour) && locality.getSchedules().getClosing().isAfter(hour)){
                result.add(locality);
            }
        }
        return result;
    }
    public static List<Locality> getHubs(MapGraph<Locality, Integer> graph){
        List<Locality> result = new ArrayList<>();
        for (Locality locality : graph.vertices()) {
            if(locality.isPromoted()){
                result.add(locality);
            }
        }
        return result;
    }

    public static PathInfo dataAnalyze (double autonomy, LinkedList<Locality> path, MapGraph<Locality, Integer> graph){
        ArrayList<Integer> chargementsIndexes = new ArrayList<>();
        LinkedList<Locality> path1 = path;
        boolean flag = true;
        double distance = 0, battery = autonomy;
        if(path1 != null){
            for (int i = 0; i < path1.size(); i++) {
                double distanceBetweenHubs = graph.edge(path1.get(i), path1.get(i + 1)).getWeight();
                distance += distanceBetweenHubs;
                if(distanceBetweenHubs / 1000 > battery){
                    if(distanceBetweenHubs / 1000 <= autonomy){
                        chargementsIndexes.add(i);
                        battery = autonomy;
                    }else {
                        flag = false;
                    }
                }else{
                    battery -= distanceBetweenHubs / 1000;
                }
            }
        }else{
            flag = false;
            return new PathInfo(distance, path1, chargementsIndexes, flag);
        }
        return new PathInfo(distance, path1, chargementsIndexes, flag);
    }
}