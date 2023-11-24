package US04;

import Domain.Hub;
import Structure.Edge;
import Structure.MapGraph;
import US01.NetworkBuilder;

import java.util.List;

import static Structure.GraphAlgorithms.minimumSpanningTree;

public class MinSpanningTreeResult<T, E> {

    public static MapGraph<Hub,Double> getMinimumSpanningTree() {
        MapGraph<Hub,Double> mapGraph = NetworkBuilder.getInstance().getDistribution();
        return minimumSpanningTree(mapGraph, Double::compare, Double::sum, 0.0);
    }

    @Override
    public String toString() {
        MapGraph<Hub, Double> minSpanningTree = getMinimumSpanningTree();

        StringBuilder sb = new StringBuilder();
        sb.append("Minimum Spanning Tree:\n");

        if (minSpanningTree != null) {
            for (Hub vertex : minSpanningTree.vertices()) {
                sb.append(vertex).append(" -> ");
                List<Edge<Hub, Double>> edges = (List<Edge<Hub, Double>>) minSpanningTree.outgoingEdges(vertex);
                for (Structure.Edge<Hub, Double> edge : edges) {
                    sb.append("(").append(edge.getVDest()).append(", ").append(edge.getWeight()).append(") ");
                }
                sb.append("\n");
            }
        } else {
            sb.append("Minimum Spanning Tree is null.\n");
        }
        return sb.toString();
    }

    //MapGraph<Hub, Double> minSpanning = MinSpanningTreeResult.getMinimumSpanningTree();
    //minSpanning.printGraph();
}
