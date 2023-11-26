package ESINF.US04;

import ESINF.Domain.Hub;
import ESINF.Structure.MapGraph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinSpanningTreeResultTest {

    @Test
    void printMinimumSpanningTree() {
        MapGraph<Hub, Integer> minimumSpanning = new MapGraph<>(true);
        Hub hubA = new Hub("A");
        Hub hubB = new Hub("B");
        Hub hubC = new Hub("C");
        minimumSpanning.addVertex(hubA);
        minimumSpanning.addVertex(hubB);
        minimumSpanning.addVertex(hubC);
        minimumSpanning.addEdge(hubA, hubB, 10);
        minimumSpanning.addEdge(hubB, hubC, 15);

        System.out.println("Print Minimum Spanning Tree:");
        MinSpanningTreeResult.printMinimumSpanningTree(minimumSpanning);
    }

    @Test
    void calculateTotalDistance() {
        MapGraph<Hub, Integer> minimumSpanning = new MapGraph<>(true);
        Hub hubA = new Hub("A");
        Hub hubB = new Hub("B");
        Hub hubC = new Hub("C");
        minimumSpanning.addVertex(hubA);
        minimumSpanning.addVertex(hubB);
        minimumSpanning.addVertex(hubC);
        minimumSpanning.addEdge(hubA, hubB, 10);
        minimumSpanning.addEdge(hubB, hubC, 15);

        int totalDistance = MinSpanningTreeResult.calculateTotalDistance(minimumSpanning);

        assertEquals(25, totalDistance);
    }
}