package Structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphAlgorithmsTest {
//USEI04
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