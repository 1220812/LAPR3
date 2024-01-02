package ESINF.US07;

import ESINF.Domain.Locality;
import ESINF.Domain.PathInfo;
import ESINF.Domain.Vehicle;
import ESINF.Structure.Edge;
import ESINF.Structure.GraphAlgorithms;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;
import ESINF.US02.HubDefiner;

import java.time.LocalTime;
import java.util.*;
/**
 * This class is responsible for finding the maximum hubs in a given graph based on specified parameters.
 * It uses a recursive depth-first search approach to explore the graph and identify paths with the maximum number of hubs.
 */

public class MaximumHubsFinder {

    private PathInfo depthFirstSearcher (Locality origin, LocalTime inicialHour, double autonomy, LocalTime chargeTime, double averageSpeed, LocalTime unloadingTime, MapGraph<Locality, Integer> graph){
        //, , , , double autonomy, double vehicleAutonomy,,, String localInfo,
        Set<Locality> visited = new HashSet<>();
        List<Locality> currentPath = new ArrayList<>();
        List<Locality> longestPath = new ArrayList<>();
        int chargerCounter = 0;
        int counter = 0;
        Map<List<Locality>, String> info = new HashMap<>();
        double totalDistance;
        double vehicleCurrentAutonomy = autonomy;

        visited.add(origin);
        currentPath.add(origin);
        LocalTime finalHour, pass;
        counter++;
        boolean exists = false, flag = false;

        for (Edge<Locality, Integer> hub : graph.edges()) {
            if(hub.getWeight() < vehicleCurrentAutonomy && !visited.contains(hub.getVDest())){
                exists = true;
                break;
            }
        }

        if(!exists){
            vehicleCurrentAutonomy = autonomy;
            chargerCounter++;
        }

        for (Locality neighbour : graph.adjVertices(origin)) {
            if(counter == 1){
                finalHour = inicialHour.plusHours(chargeTime.getHour()).plusMinutes(chargeTime.getMinute());
                chargerCounter++;
            }else{
                finalHour = inicialHour;
                double distance = graph.edge(origin, neighbour).getWeight();
                double takenTime = (distance/1000) / averageSpeed;
                int hour = (int) takenTime, minute = (int) ((takenTime % 1) * 60);

                pass = finalHour.plusHours(hour).plusMinutes(minute);

                if(!visited.contains(neighbour) && pass.isAfter(neighbour.schedule.getOpening()) && pass.isBefore(neighbour.getSchedules().getClosing())){
                    if(vehicleCurrentAutonomy >= distance){
                        flag = true;
                        finalHour = finalHour.plusHours(hour).plusMinutes(minute);
                        localInfo += ("Inicial hour/final in/at locality " + neighbour.getName() + " " + finalHour + "\n");
                        totalDistance += distance;
                        vehicleCurrentAutonomy -= distance;

                        depthFirstSearcher(neighbour, finalHour, autonomy, chargeTime, averageSpeed, unloadingTime, graph);

                        if(currentPath.size() > longestPath.size()){
                            longestPath.clear();
                            longestPath.addAll(currentPath);

                            LocalTime endChargeTime = chargeTime, totalTime = finalHour.minusHours(inicialHourHub.getHour()).minusMinutes(inicialHourHub.getMinute()),
                                    totalUnloadingTime = unloadingTime;
                            for (int i = 1 ; i < chargerCounter ; i++) {
                                endChargeTime = endChargeTime.plusHours(chargeTime.getHour()).plusMinutes(chargeTime.getMinute());
                            }
                            for (int i = 2; i < currentPath.size() ; i++) {
                                totalUnloadingTime = totalUnloadingTime.plusHours(unloadingTime.getHour()).plusMinutes(unloadingTime.getMinute());
                            }

                            localInfo += ("Total Distance = " + totalTime + "\nNumber of chargements = " + chargerCounter +
                                    "\n Total Time = " + totalTime +
                                    "\n Chargement total time = " + endChargeTime +
                                    "\n Unloading total time = " + totalUnloadingTime +
                                    "\n Total path time = " + totalTime.minusHours(chargeTime.getHour()).minusHours(totalUnloadingTime.getHour()).minusMinutes(chargeTime.getHour()).minusMinutes(totalUnloadingTime.getMinute()));
                        }

                        info.remove(longestPath);
                        info.put(new ArrayList<>(currentPath), localInfo);
                        localInfo = "";

                        totalDistance = 0;
                    }
                }

            }
        }
        if(!flag){
            currentPath.remove(origin);
        }
        visited.remove(origin);
        return info;
    }
}
