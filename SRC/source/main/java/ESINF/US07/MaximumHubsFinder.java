package ESINF.US07;

import ESINF.Domain.Locality;
import ESINF.Domain.PathInfo;
import ESINF.Domain.Vehicle;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class MaximumHubsFinder {
    NetworkBuilder networkBuilder = NetworkBuilder.getInstance();
    MapGraph<Locality, Integer> graph = networkBuilder.getDistribution();
    /*
    public TreeMap<LinkedHashMap<Locality, List<Locality>>, PathInfo> maximumHubsFinder (Locality origin, Vehicle vehicle){

    }

     */
    private double calculateTotalDistance (List<Locality> routes){
        double totalDistance = 0;
        for (int i = 0; i < routes.size() - 1; i++) {
            Locality origin = routes.get(i);
            Locality destiny = routes.get(i + 1);

            totalDistance += graph.edge(origin, destiny).getWeight();
        }
        return totalDistance;
    }
    public double totalTravelTime (Vehicle vehicle, double totalDistance){
        return totalDistance / vehicle.getAverageSpeed();
    }
}
