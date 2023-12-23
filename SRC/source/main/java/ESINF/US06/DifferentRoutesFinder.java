package ESINF.US06;

import ESINF.Domain.Locality;
import ESINF.Domain.LocalityPair;
import ESINF.Domain.PathInfo;
import ESINF.Domain.Vehicle;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;

import java.util.*;

import static ESINF.Structure.GraphAlgorithms.dfsAlgorithm;

public class DifferentRoutesFinder {
    NetworkBuilder networkBuilder = NetworkBuilder.getInstance();
    MapGraph<Locality, Integer> graph1 = networkBuilder.getDistribution();

    public double totalTravelTime(Vehicle vehicle, double totalDistance) {
        return totalDistance / vehicle.getAverageSpeed();
    }

    public double calculateTotalTravelDistance(List<Locality> routes) {
        double totalDistance = 0;
        for (int i = 0; i < routes.size() - 1; i++) {
            Locality origin = routes.get(i);
            Locality destiny = routes.get(i + 1);

            totalDistance += graph1.edge(origin, destiny).getWeight();
        }
        return totalDistance;
    }

    public TreeMap<LocalityPair, PathInfo> routes(Locality origin, Locality hub, Vehicle vehicle) {
        TreeMap<LocalityPair, PathInfo> result = new TreeMap<>();

        // Find all paths using the dfsAlgorithm method
        List<LinkedList<Locality>> allPaths = dfsAlgorithm(graph1, origin, hub, vehicle.getAutonomy());

        // Process each path found
        for (LinkedList<Locality> path : allPaths) {
            double totalDistance = calculateTotalTravelDistance(path);
            double totalTravelTime = totalTravelTime(vehicle, totalDistance);

            // Create a LocalityPair representing the current route
            LocalityPair localityPair = new LocalityPair(path.getFirst(), path.getLast());

            // Create a PathInfo object with total distance and travel time
            result.put(localityPair, new PathInfo(totalDistance, totalTravelTime));
        }

        return result;
    }
}