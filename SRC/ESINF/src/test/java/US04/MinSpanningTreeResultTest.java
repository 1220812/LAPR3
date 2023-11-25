package US04;

import Domain.Hub;
import Structure.Edge;
import Structure.MapGraph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinSpanningTreeResultTest {
    @Test
    void getMinimumSpanningTree() {
        // Assuming you have a NetworkBuilder that creates a MapGraph<Hub, Double>
        // with appropriate vertices and edges.

        // Call the method to get the minimum spanning tree
        MapGraph<Hub, Double> minimumSpanningTree = MinSpanningTreeResult.getMinimumSpanningTree();

        // Check if the result is not null
        assertNotNull(minimumSpanningTree);

        // You might want to add more specific checks based on your input graph
        // and the expected minimum spanning tree. For example, check specific vertices
        // and edges.

        // Example: Check that the number of edges is correct
        assertEquals(minimumSpanningTree.numVertices() - 1, minimumSpanningTree.numEdges());

        // Example: Check that all vertices are valid in the minimum spanning tree
        for (Hub hub : minimumSpanningTree.vertices()) {
            assertTrue(minimumSpanningTree.validVertex(hub));
        }

        // Example: Check that all edges have valid weights
        for (Edge<Hub, Double> edge : minimumSpanningTree.edges()) {
            assertTrue(edge.getWeight() >= 0.0); // Assuming weights are non-negative
        }
    }
}