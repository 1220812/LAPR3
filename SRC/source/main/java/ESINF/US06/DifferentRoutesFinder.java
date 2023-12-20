package ESINF.US06;

import ESINF.Domain.Locality;
import ESINF.Domain.PathInfo;
import ESINF.Domain.Vehicle;
import ESINF.Structure.Auxiliary.Path;
import ESINF.Structure.GraphAlgorithms;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;

import javax.swing.*;
import java.util.*;

public class DifferentRoutesFinder {
    NetworkBuilder networkBuilder = NetworkBuilder.getInstance();
    MapGraph<Locality, Integer> graph = networkBuilder.getDistribution();
    /*
    public TreeMap<LinkedHashMap, PathInfo> findRoutes (Locality origin, Locality hub, Vehicle vehicle){

    }
    */
    public double totalTravelTime (Vehicle vehicle, double totalDistance){
        return totalDistance / vehicle.getAverageSpeed();
    }

    private double calculateTotalDistance (List<Locality> routes){
        double totalDistance = 0;
        for (int i = 0; i < routes.size() - 1; i++) {
            Locality origin = routes.get(i);
            Locality destiny = routes.get(i + 1);

            totalDistance += graph.edge(origin, destiny).getWeight();
        }
        return totalDistance;
    }
}