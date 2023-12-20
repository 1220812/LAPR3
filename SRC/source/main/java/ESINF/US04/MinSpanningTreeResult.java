package ESINF.US04;

import ESINF.Domain.Locality;
import ESINF.Structure.Edge;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;


import static ESINF.Structure.GraphAlgorithms.minimumSpanningTree;

public class MinSpanningTreeResult<T, E> {
    NetworkBuilder networkBuilder = NetworkBuilder.getInstance();

    public MapGraph<Locality, Integer> getGraph() {
        return networkBuilder.getDistribution();
    }

    public static MapGraph<Locality, Integer> getMinimumSpanningTree(MapGraph<Locality, Integer> graph) {
        if (graph == null) {
            return null;
        } else {
            return minimumSpanningTree(graph, Integer::compare, Integer::sum, 0);
        }
    }
    public static void printMinimumSpanningTree(MapGraph<Locality, Integer> minimumSpanning) {
        if (minimumSpanning == null) {
            System.out.println("The minimum spanning tree is null. Make sure you initialize it correctly.");
        } else {
            System.out.println("Minimum Spanning Tree:");
            System.out.printf("%-10s%-20s%s%n", "Origin", "--(Distance(m))--", "Destination");

            for (Edge<Locality, Integer> edge : minimumSpanning.edges()) {
                Locality vOrig = edge.getVOrig();
                Locality vDest = edge.getVDest();
                String hubOrigin = vOrig.getName();
                String hubDestination = vDest.getName();
                Integer weight = edge.getWeight();

                System.out.printf("%-10s%-20s%s%n", hubOrigin, "--(" + weight + ")--", hubDestination);
            }

        }

    }

    public static int calculateTotalDistance(MapGraph<Locality, Integer> minimumSpanning) {
        int totalDistance = 0;

        if (minimumSpanning != null) {
            for (Edge<Locality, Integer> edge : minimumSpanning.edges()) {
                totalDistance += edge.getWeight();
            }
        }

        return totalDistance;
    }
    /*
    MapGraph<Hub, Integer> testGraph = networkBuilder.getInstance().getDistribution();

    MapGraph<Hub, Integer> minSpanning = MinSpanningTreeResult.getMinimumSpanningTree(testGraph);
    printMinimumSpanningTree(minSpanning);

     */
}


