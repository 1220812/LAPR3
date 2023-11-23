package Structure;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphAlgorithmsTest {

    @Test
    void minimumSpanningTree() {
        // Create a sample graph for testing
        MapGraph<String, Integer> graph = new MapGraph<>(false);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 4);
        graph.addEdge("C", "D", 5);

        // Call the minimumSpanningTree method
        MapGraph<String, Integer> minimumSpanningTree = GraphAlgorithms.minimumSpanningTree(graph, Integer::compare, Integer::sum, 0);

        // Check if the result is not null
        assertNotNull(minimumSpanningTree);

        // Check the number of vertices in the minimum spanning tree
        assertEquals(graph.numVertices(), minimumSpanningTree.numVertices());

        // Check the number of edges in the minimum spanning tree
        assertEquals(graph.numVertices() - 1, minimumSpanningTree.numEdges());

        // You can add more specific checks based on your input graph and the expected minimum spanning tree
        // For example, check specific vertices and edges
        assertTrue(minimumSpanningTree.validVertex("A"));
        assertTrue(minimumSpanningTree.validVertex("B"));
        assertTrue(minimumSpanningTree.validVertex("C"));
        assertTrue(minimumSpanningTree.validVertex("D"));

        List<Edge<String, Integer>> edges = (List<Edge<String, Integer>>) minimumSpanningTree.edges();
        // Check specific edges in the minimum spanning tree
        assertTrue(edges.contains(new Edge<>("A", "B", 1)));
        assertTrue(edges.contains(new Edge<>("B", "C", 2)));
        assertTrue(minimumSpanningTree.validVertex("A"));
    }
    /*
    @Test
    void minimumSpanningTree_DisconnectedGraph() {
        MapGraph<String, Integer> disconnectedGraph = new MapGraph<>(false);
        disconnectedGraph.addVertex("A");
        disconnectedGraph.addVertex("B");
        disconnectedGraph.addVertex("C");

        MapGraph<String, Integer> minimumSpanningTree = GraphAlgorithms.minimumSpanningTree(disconnectedGraph, Integer::compare, Integer::sum, 0);

        assertNull(minimumSpanningTree);
    }
     */

    @Test
    void minimumSpanningTree_NegativeWeights() {
        MapGraph<String, Integer> graphWithNegativeWeights = new MapGraph<>(false);
        graphWithNegativeWeights.addVertex("A");
        graphWithNegativeWeights.addVertex("B");
        graphWithNegativeWeights.addVertex("C");
        graphWithNegativeWeights.addEdge("A", "B", -2);
        graphWithNegativeWeights.addEdge("A", "C", 3);
        graphWithNegativeWeights.addEdge("B", "C", 2);

        MapGraph<String, Integer> minimumSpanningTree = GraphAlgorithms.minimumSpanningTree(graphWithNegativeWeights, Integer::compare, Integer::sum, 0);

        assertNotNull(minimumSpanningTree);
        assertEquals(graphWithNegativeWeights.numVertices(), minimumSpanningTree.numVertices());
        assertEquals(graphWithNegativeWeights.numVertices() - 1, minimumSpanningTree.numEdges());
    }
    @Test
    void minimumSpanningTree_EqualWeights() {
        MapGraph<String, Integer> graphWithEqualWeights = new MapGraph<>(false);
        graphWithEqualWeights.addVertex("A");
        graphWithEqualWeights.addVertex("B");
        graphWithEqualWeights.addVertex("C");
        graphWithEqualWeights.addEdge("A", "B", 2);
        graphWithEqualWeights.addEdge("A", "C", 2);
        graphWithEqualWeights.addEdge("B", "C", 2);

        MapGraph<String, Integer> minimumSpanningTree = GraphAlgorithms.minimumSpanningTree(graphWithEqualWeights, Integer::compare, Integer::sum, 0);

        assertNotNull(minimumSpanningTree);
        assertEquals(graphWithEqualWeights.numVertices(), minimumSpanningTree.numVertices());
        assertEquals(graphWithEqualWeights.numVertices() - 1, minimumSpanningTree.numEdges());
    }
    @Test
    void minimumSpanningTree_ConnectedGraph() {
        MapGraph<String, Integer> connectedGraph = new MapGraph<>(false);
        connectedGraph.addVertex("A");
        connectedGraph.addVertex("B");
        connectedGraph.addVertex("C");
        connectedGraph.addVertex("D");
        connectedGraph.addEdge("A", "B", 1);
        connectedGraph.addEdge("A", "C", 3);
        connectedGraph.addEdge("B", "C", 2);
        connectedGraph.addEdge("B", "D", 4);
        connectedGraph.addEdge("C", "D", 5);

        MapGraph<String, Integer> minimumSpanningTree = GraphAlgorithms.minimumSpanningTree(connectedGraph, Integer::compare, Integer::sum, 0);

        assertNotNull(minimumSpanningTree);
        assertEquals(connectedGraph.numVertices(), minimumSpanningTree.numVertices());
        assertEquals(connectedGraph.numVertices() - 1, minimumSpanningTree.numEdges());
    }

}