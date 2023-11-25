package ESINF.US04;

import ESINF.Domain.Hub;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;


import static ESINF.Structure.GraphAlgorithms.minimumSpanningTree;

public class MinSpanningTreeResult<T, E> {
    NetworkBuilder networkBuilder = NetworkBuilder.getInstance();

    public MapGraph<Hub, Integer> getGraph() {
        return networkBuilder.getDistribution();
    }

    public static MapGraph<Hub, Integer> getMinimumSpanningTree(MapGraph<Hub, Integer> graph) {
        if (graph == null) {
            return null;
        } else {
            return minimumSpanningTree(graph, Integer::compare, Integer::sum, 0);
        }
    }
    /*
    public static void printMinimumSpanningTree(MapGraph<Hub, Integer> minimumSpanning) {
        if (minimumSpanning == null) {
            System.out.println("The minimum spanning tree is null. Make sure you initialize it correctly.");
        } else {
            System.out.println("Minimum Spanning Tree:");
            System.out.printf("%-10s%-20s%s%n", "Origin", "--(Distance(m))--", "Destination");

            for (Edge<Hub, Integer> edge : minimumSpanning.edges()) {
                Hub vOrig = edge.getVOrig();
                Hub vDest = edge.getVDest();
                String hubOrigin = vOrig.getHubId();
                String hubDestination = vDest.getHubId();
                Integer weight = edge.getWeight();

                System.out.printf("%-10s%-20s%s%n", hubOrigin, "--(" + weight + ")--", hubDestination);
            }

        }
    }
    MapGraph<Hub, Integer> testGraph = networkBuilder.getInstance().getDistribution();

    MapGraph<Hub, Integer> minSpanning = MinSpanningTreeResult.getMinimumSpanningTree(testGraph);
    printMinimumSpanningTree(minSpanning);

     */
}


