package US04;

import Structure.Edge;
import Structure.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinSpanningTreeResult<T, E> {
    private final List<Edge<T, E>> edges;
    private final double totalDistance;
    private final Map<T, Node<T>> nodeMap;

    public MinSpanningTreeResult(List<Edge<T, E>> edges, double totalDistance) {
        this.edges = edges;
        this.totalDistance = totalDistance;
        this.nodeMap = new HashMap<>();
        initializeDisjointSet();
    }

    private void initializeDisjointSet() {
        // Initialize the disjoint set with all vertices
        for (T vertex : getAllVertices()) {
            makeSet(vertex);
        }
    }

    private List<T> getAllVertices() {
        List<T> vertices = new ArrayList<>();
        for (Edge<T, E> edge : edges) {
            vertices.add(edge.getVOrig());
            vertices.add(edge.getVDest());
        }
        return vertices;
    }

    public void makeSet(T element) {
        if (!nodeMap.containsKey(element)) {
            Node<T> node = new Node<>(element);
            nodeMap.put(element, node);
        }
    }

    public Node<T> findSet(T element) {
        Node<T> node = nodeMap.get(element);
        if (node != null) {
            if (node.parent != node) {
                node.parent = findSet(node.parent.element); // Path compression
            }
            return node.parent;
        }
        return null;
    }

    public void union(T element1, T element2) {
        Node<T> root1 = findSet(element1);
        Node<T> root2 = findSet(element2);

        if (root1 != null && root2 != null && !root1.equals(root2)) {
            Node<T> node1 = nodeMap.get(root1.element);
            Node<T> node2 = nodeMap.get(root2.element);

            if (node1.rank > node2.rank) {
                node2.parent = node1;
            } else if (node1.rank < node2.rank) {
                node1.parent = node2;
            } else {
                node2.parent = node1;
                node1.rank++;
            }
        }
    }

    private static class Node<T> {
        private final T element;
        private Node<T> parent;
        private int rank;

        public Node(T element) {
            this.element = element;
            this.parent = this;
            this.rank = 0;
        }
    }

    public static <T, E> MinSpanningTreeResult<T, E> getMinSpanningTree(Graph<T, E> distribution) {
        List<Edge<T, E>> edges = getAllEdges(distribution);
        Comparator<Edge<T, E>> edgeComparator = Comparator.comparingDouble(edge -> (double) edge.getWeight());
        Collections.sort(edges, edgeComparator);

        List<Edge<T, E>> minSpanningTreeEdges = new ArrayList<>();
        double totalDistance = 0.0;
        MinSpanningTreeResult<T, E> minSpanningTreeResult = new MinSpanningTreeResult<>(minSpanningTreeEdges, totalDistance);

        for (Edge<T, E> edge : edges) {
            Node<T> root1Node = minSpanningTreeResult.findSet(edge.getVOrig());
            Node<T> root2Node = minSpanningTreeResult.findSet(edge.getVDest());

            if (!root1Node.equals(root2Node)) {
                minSpanningTreeEdges.add(edge);
                totalDistance += (double) edge.getWeight();
                minSpanningTreeResult.union(edge.getVOrig(), edge.getVDest());
            }
        }

        return minSpanningTreeResult;
    }

    private static <T, E> List<Edge<T, E>> getAllEdges(Graph<T, E> distribution) {
        List<Edge<T, E>> edges = new ArrayList<>();
        for (T source : distribution.vertices()) {
            for (T destination : distribution.adjVertices(source)) {
                E weight = distribution.edge(source, destination).getWeight();
                edges.add(new Edge<>(source, destination, weight));
            }
        }
        return edges;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Edges in Minimum Spanning Tree:\n");
        for (Edge<T, E> edge : edges) {
            result.append(edge).append("\n");
        }
        result.append("Total Distance: ").append(totalDistance);
        return result.toString();
    }
}
