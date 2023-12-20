package ESINF.US04;

import ESINF.Domain.Locality;
import ESINF.Structure.MapGraph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinSpanningTreeResultTest {

    @Test
    void printMinimumSpanningTree() {
        MapGraph<Locality, Integer> minimumSpanning = new MapGraph<>(true);
        Locality localityA = new Locality("A");
        Locality localityB = new Locality("B");
        Locality localityC = new Locality("C");
        minimumSpanning.addVertex(localityA);
        minimumSpanning.addVertex(localityB);
        minimumSpanning.addVertex(localityC);
        minimumSpanning.addEdge(localityA, localityB, 10);
        minimumSpanning.addEdge(localityB, localityC, 15);

        System.out.println("Print Minimum Spanning Tree:");
        MinSpanningTreeResult.printMinimumSpanningTree(minimumSpanning);
    }

    @Test
    void calculateTotalDistance() {
        MapGraph<Locality, Integer> minimumSpanning = new MapGraph<>(true);
        Locality localityA = new Locality("A");
        Locality localityB = new Locality("B");
        Locality localityC = new Locality("C");
        minimumSpanning.addVertex(localityA);
        minimumSpanning.addVertex(localityB);
        minimumSpanning.addVertex(localityC);
        minimumSpanning.addEdge(localityA, localityB, 10);
        minimumSpanning.addEdge(localityB, localityC, 15);

        int totalDistance = MinSpanningTreeResult.calculateTotalDistance(minimumSpanning);

        assertEquals(25, totalDistance);
    }
}