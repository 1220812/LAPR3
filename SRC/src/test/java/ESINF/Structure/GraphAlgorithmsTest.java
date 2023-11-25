package ESINF.Structure;

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

    @Test
    void minimumSpanningTree_LargeGraph() {
        // Create a large connected graph with random weights
        MapGraph<Integer, Double> largeGraph = new MapGraph<>(false);
        for (int i = 1; i <= 1000; i++) {
            largeGraph.addVertex(i);
        }
        for (int i = 1; i <= 1000; i++) {
            for (int j = i + 1; j <= 1000; j++) {
                double weight = Math.random() * 100;
                largeGraph.addEdge(i, j, weight);
            }
        }

        MapGraph<Integer, Double> minimumSpanningTree = GraphAlgorithms.minimumSpanningTree(largeGraph, Double::compare, Double::sum, 0.0);

        assertNotNull(minimumSpanningTree);
        assertEquals(largeGraph.numVertices(), minimumSpanningTree.numVertices());
        assertEquals(largeGraph.numVertices() - 1, minimumSpanningTree.numEdges());
    }
    @Test
    void minimumSpanningTree_DuplicateEdges() {
        // Create a graph with duplicate edges
        MapGraph<String, Integer> graphWithDuplicates = new MapGraph<>(false);
        graphWithDuplicates.addVertex("A");
        graphWithDuplicates.addVertex("B");
        graphWithDuplicates.addVertex("C");
        graphWithDuplicates.addEdge("A", "B", 2);
        graphWithDuplicates.addEdge("A", "B", 3);
        graphWithDuplicates.addEdge("A", "C", 4);

        MapGraph<String, Integer> minimumSpanningTree = GraphAlgorithms.minimumSpanningTree(graphWithDuplicates, Integer::compare, Integer::sum, 0);

        assertNotNull(minimumSpanningTree);
        assertEquals(graphWithDuplicates.numVertices(), minimumSpanningTree.numVertices());
        assertEquals(graphWithDuplicates.numVertices() - 1, minimumSpanningTree.numEdges());
    }

    @Test
    void minimumSpanningTree_UndirectedGraph() {
        // Create an undirected graph
        MapGraph<String, Integer> undirectedGraph = new MapGraph<>(true);
        undirectedGraph.addVertex("A");
        undirectedGraph.addVertex("B");
        undirectedGraph.addVertex("C");
        undirectedGraph.addEdge("A", "B", 2);
        undirectedGraph.addEdge("A", "C", 3);
        undirectedGraph.addEdge("B", "C", 1);

        MapGraph<String, Integer> minimumSpanningTree = GraphAlgorithms.minimumSpanningTree(undirectedGraph, Integer::compare, Integer::sum, 0);

        assertNotNull(minimumSpanningTree);
        assertEquals(undirectedGraph.numVertices(), minimumSpanningTree.numVertices());
        assertEquals(undirectedGraph.numVertices() - 1, minimumSpanningTree.numEdges());
    }

    @Test
    void minimumSpanningTree_NonNumericWeights() {
        // Create a graph with non-numeric weights
        MapGraph<String, String> graphWithNonNumericWeights = new MapGraph<>(false);
        graphWithNonNumericWeights.addVertex("A");
        graphWithNonNumericWeights.addVertex("B");
        graphWithNonNumericWeights.addEdge("A", "B", "low");

        // Attempt to find the minimum spanning tree with a comparator for String weights
        MapGraph<String, String> minimumSpanningTree = GraphAlgorithms.minimumSpanningTree(graphWithNonNumericWeights, String::compareTo, String::concat, "");

        assertNotNull(minimumSpanningTree);
        assertEquals(graphWithNonNumericWeights.numVertices(), minimumSpanningTree.numVertices());
        assertEquals(graphWithNonNumericWeights.numVertices() - 1, minimumSpanningTree.numEdges());
    }

}