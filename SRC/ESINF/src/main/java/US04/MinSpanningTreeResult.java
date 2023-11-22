package US04;

import Domain.Hub;
import Structure.MapGraph;
import US01.NetworkBuilder;

import static Structure.GraphAlgorithms.minimumSpanningTree;

public class MinSpanningTreeResult<T, E> {

    public static MapGraph<Hub,Double> getMinimumSpanningTree() {
        MapGraph<Hub,Double> mapGraph = NetworkBuilder.getInstance().getDistribution();
        return minimumSpanningTree(mapGraph, Double::compare, Double::sum, 0.0);
    }

}
