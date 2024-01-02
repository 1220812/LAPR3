package ESINF.US07;

import ESINF.Domain.Locality;
import ESINF.Domain.PathInfo;
import ESINF.Structure.Edge;
import ESINF.Structure.MapGraph;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    /*
    public PathInfo MaximumHubsFinder (MapGraph<Locality, Integer> graph, Locality origin, LocalTime inicialHour, double autonomy, LocalTime chargeTime, LocalTime unloadingTime, double averageSpeed){

        Set<Locality> visitedVertex = new HashSet<>();
        List<Locality> currentPath = new ArrayList<>();
        List<Locality> biggestPath = new ArrayList<>();
        double currentAutonomy = autonomy;
        int chargementsCounter = 0;
        double totalDistance = 0;
        int counter = 0;
        String info = null;
        visitedVertex.add(origin);
        currentPath.add(origin);
        LocalTime totalHour = inicialHour;
        LocalTime totalHour1 = inicialHour;
        LocalTime timeToHub;
        LocalTime totalUnloadingTime;
        LocalTime totalChargingTime;
        LocalTime totalTime;
        counter++;
        boolean flag = false;
        for (Edge<Locality, Integer> edge : graph.edges()) {
            if(edge.getWeight() < currentAutonomy && !visitedVertex.contains(edge.getVDest())){
                flag = true;
                break;
            }
        }
        if(!flag){
            currentAutonomy = autonomy;
            chargementsCounter++;
        }
        for (Locality neighbour : graph.adjVertices(origin)) {
            if(counter == 1){
                totalHour1 = totalHour.plusHours(chargeTime.getHour()).plusMinutes(chargeTime.getMinute());
                chargementsCounter++;
            }else{
                totalHour1 = totalHour;
            }
            double distance = graph.edge(origin, neighbour).getWeight();
            double time = distance/1000/averageSpeed;
            int hour = (int) time;
            int minute = (int) (time%1 *60);
            timeToHub = totalHour1.plusHours(hour).plusMinutes(minute);
            if(!visitedVertex.contains(neighbour) && timeToHub.isAfter(neighbour.getSchedules().getOpening()) && timeToHub.isBefore(neighbour.getSchedules().getClosing())){
                if(currentAutonomy >= distance){
                    totalHour1 = totalHour1.plusHours(hour).plusMinutes(minute);
                    info += "Arrival time to get to the hub" + neighbour.getName() + ":" + totalHour1;
                    totalHour1 = totalHour1.plusHours(unloadingTime.getHour()).plusMinutes(unloadingTime.getMinute());
                    totalDistance += distance;
                    currentAutonomy -= distance;
                    MaximumHubsFinder(graph, origin, inicialHour, autonomy, chargeTime, unloadingTime, averageSpeed);
                    if(currentPath.size() > biggestPath.size()){
                        biggestPath.clear();
                        biggestPath.addAll(currentPath);
                        totalUnloadingTime = unloadingTime;
                        totalChargingTime = chargeTime;
                        totalTime = totalHour1.minusHours(inicialHour.getHour()).minusMinutes(inicialHour.getMinute());
                        for (int i = 1; i < chargementsCounter; i++) {
                            totalChargingTime = totalChargingTime.plusHours(chargeTime.getHour()).plusMinutes(chargeTime.getMinute());
                        }
                        for (int i = 2; i < biggestPath.size(); i++) {
                            totalUnloadingTime = totalUnloadingTime.plusHours(unloadingTime.getHour()).plusMinutes(unloadingTime.getMinute());
                        }
                    }
                }
            }
        }
    }*/
}
