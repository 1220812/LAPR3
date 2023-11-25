
/*
 * A collection of graph algorithms.
 */
package ESINF.Structure;

import java.util.*;
import java.util.function.BinaryOperator;

/**
 * @author DEI-ESINF
 */

public class GraphAlgorithms {

    /**
     * Performs breadth-first search of a Graph starting in a Vertex
     *
     * @param g    Graph instance
     * @param vert information of the Vertex that will be the source of the search
     * @return qbfs a queue with the vertices of breadth-first search
     */
    public static <V, E> LinkedList<V> breadthFirstSearch(Graph<V, E> g, V vert) {
        if (!g.validVertex(vert)) {
            return null;
        }
        LinkedList<V> neighbors = new LinkedList();
        LinkedList<V> auxiliar = new LinkedList<>();
        auxiliar.add(vert);
        neighbors.add(vert);
        while (!auxiliar.isEmpty()) {
            vert = auxiliar.remove();
            for (V adj : g.adjVertices(vert)) {
                if (!neighbors.contains(adj)) {
                    neighbors.add(adj);
                    auxiliar.add(adj);
                }
            }
        }
        return neighbors;
    }

    /**
     * Performs depth-first search starting in a Vertex
     *
     * @param g     Graph instance
     * @param vOrig Vertex of graph g that will be the source of the search
     * @param vOrig set of discovered vertices
     * @param qdfs  queue with vertices of depth-first search
     */
    private static <V, E> void depthFirstSearch(Graph<V, E> g, V vOrig, LinkedList<V> qdfs) {
        qdfs.add(vOrig);
        for (V adj : g.adjVertices(vOrig)) {
            if (!qdfs.contains(adj)) {
                depthFirstSearch(g, adj, qdfs);
            }
        }
    }

    /**
     * @param g    Graph instance
     * @param vert information of the Vertex that will be the source of the search
     * @return qdfs a queue with the vertices of depth-first search
     */
    public static <V, E> LinkedList<V> depthFirstSearch(Graph<V, E> g, V vert) {
        if (!g.validVertex(vert)) {
            return null;
        }
        LinkedList<V> path = new LinkedList<>();
        depthFirstSearch(g, vert, path);
        return path;

    }

    /**
     * Returns all paths from vOrig to vDest
     *
     * @param g     Graph instance
     * @param vOrig Vertex that will be the source of the path
     * @param vDest Vertex that will be the end of the path
     * @param vDest set of discovered vertices
     * @param path  stack with vertices of the current path (the path is in reverse order)
     * @param paths ArrayList with all the paths (in correct order)
     */


    private static <V, E> boolean allPaths(Graph<V, E> g, V vOrig, V vDest, Map<V, Boolean> visited, LinkedList<V> path, ArrayList<LinkedList<V>> paths) {
        if (vDest.equals(vOrig)) {
            path.add(vDest);
            paths.add(path);
            return true;
        }
        visited.put(vDest, true);
        for (V adj : g.adjVertices(vDest)) {
            if (visited.get(adj) != null) {
                continue;
            }
            if (allPaths(g, vOrig, adj, new HashMap<>(visited), new LinkedList<>(path), paths)) {
                path.add(adj);
            }
        }
        return false;
    }


    /**
     * @param g     Graph instance
     * @param vOrig information of the Vertex origin
     * @param vDest information of the Vertex destination
     * @return paths ArrayList with all paths from voInf to vdInf
     */
    public static <V, E> ArrayList<LinkedList<V>> allPaths(Graph<V, E> g, V vOrig, V vDest) {
        if (!g.validVertex(vOrig) || !g.validVertex(vDest)) {
            return null;
        }
        ArrayList<LinkedList<V>> paths = new ArrayList<>();
        allPaths(g, vOrig, vDest);
        return paths;
    }

    /**
     * Computes shortest-path distance from a source vertex to all reachable
     * vertices of a graph g with nonnegative edge weights
     * This implementation uses Dijkstra's algorithm
     *
     * @param g        Graph instance
     * @param vOrig    Vertex that will be the source of the path
     * @param visited  set of discovered vertices
     * @param pathKeys minimum path vertices keys
     * @param dist     minimum distances
     */
    protected static <V, E> void shortestPathLength(Graph<V, E> g, V vOrig, V[] vertices,
                                                    boolean[] visited, int[] pathKeys, double[] dist) {
        int vkey = g.key(vOrig);
        dist[vkey] = 0;
        while (vkey != -1) {
            vOrig = vertices[vkey];
            visited[vkey] = true;
            for (V vAdj : g.adjVertices(vOrig)) {
                int vkeyAdj = g.key(vAdj);
                Edge<V, E> edge = g.edge(vOrig, vAdj);
                if (!visited[vkeyAdj] && dist[vkeyAdj] > dist[vkey] + ((Number) edge.getWeight()).doubleValue()) {
                    dist[vkeyAdj] = dist[vkey] + ((Number) edge.getWeight()).doubleValue();
                    pathKeys[vkeyAdj] = vkey;
                }
            }
            double minDist = Double.MAX_VALUE;
            vkey = -1;
            for (int i = 0; i < g.numVertices(); i++) {
                if (!visited[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    vkey = i;
                }
            }
        }

    }

    /**
     * Extracts from pathKeys the minimum path between voInf and vdInf
     * The path is constructed from the end to the beginning
     *
     * @param g        Graph instance
     * @param vOrig    information of the Vertex origin
     * @param vDest    information of the Vertex destination
     * @param pathKeys minimum path vertices keys
     * @param path     stack with the minimum path (correct order)
     */
    protected static <V, E> void getPath(Graph<V, E> g, V vOrig, V vDest, V[] verts, int[] pathKeys, LinkedList<V> path) {

        if (!vOrig.equals(vDest)) {
            path.push(vDest);
            int vKey = g.key(vDest);
            int prevVKey = pathKeys[vKey];
            vDest = verts[prevVKey];

            getPath(g, vOrig, vDest, verts, pathKeys, path);
        } else {
            path.push(vOrig);
        }
    }

    //shortest-path between vOrig and vDest
    public static <V, E> double shortestPath(Graph<V, E> g, V vOrig, V vDest, LinkedList<V> shortPath) {

        if (!g.validVertex(vOrig) || !g.validVertex(vDest))
            return 0;

        int nverts = g.numVertices();
        boolean[] visited = new boolean[nverts];
        int[] pathKeys = new int[nverts];
        double[] dist = new double[nverts];
        V[] vertices = g.allkeyVerts();

        for (int i = 0; i < nverts; i++) {
            dist[i] = Double.MAX_VALUE;
            pathKeys[i] = -1;
        }
        shortestPathLength(g, vOrig, vertices, visited, pathKeys, dist);
        double lengthPath = dist[g.key(vDest)];

        if (lengthPath != Double.MAX_VALUE) {


            getPath(g, vOrig, vDest, vertices, pathKeys, shortPath);
            return lengthPath;
        }

        return 0;
    }

    //shortest-path between voInf and all other
    public static <V, E> boolean shortestPaths(Graph<V, E> g, V vOrig, ArrayList<LinkedList<V>> paths, ArrayList<Double> dists) {

        if (!g.validVertex(vOrig)) return false;
        int nverts = g.numVertices();
        boolean[] visited = new boolean[nverts];
        int[] pathKeys = new int[nverts];
        double[] dist = new double[nverts];
        V[] vertices = g.allkeyVerts();

        for (int i = 0; i < nverts; i++) {
            dist[i] = Double.MAX_VALUE;
            pathKeys[i] = -1;
        }

        shortestPathLength(g, vOrig, vertices, visited, pathKeys, dist);

        dists.clear();
        paths.clear();
        for (int i = 0; i < nverts; i++) {
            paths.add(null);
            dists.add(null);
        }
        for (int i = 0; i < nverts; i++) {
            LinkedList<V> shortPath = new LinkedList<>();
            if (dist[i] != Double.MAX_VALUE)
                getPath(g, vOrig, vertices[i], vertices, pathKeys, shortPath);
            paths.set(i, shortPath);
            dists.set(i, dist[i]);
        }

        return true;
    }


    /**
     * Reverses the path
     *
     * @param path stack with path
     */
    private static <V, E> LinkedList<V> revPath(LinkedList<V> path) {

        LinkedList<V> pathcopy = new LinkedList<>(path);
        LinkedList<V> pathrev = new LinkedList<>();

        while (!pathcopy.isEmpty())
            pathrev.push(pathcopy.pop());

        return pathrev;
    }
    public static <V, E> MapGraph<V, E> minimumSpanningTree(MapGraph<V, E> g, Comparator<E> ce, BinaryOperator<E> sum, E zero) {
        // Create a set to keep track of visited vertices
        Set<V> visitedVertices = new HashSet<>();

        // Create a priority queue to store edges based on their weights
        PriorityQueue<Edge<V, E>> edgeQueue = new PriorityQueue<>(Comparator.comparing(e -> e.getWeight(), ce));

        // Create a graph to represent the minimum spanning tree
        MapGraph<V, E> minimumSpanningTree = new MapGraph<>(true);

        // Add an arbitrary vertex to start the process
        V startVertex = g.vertices().iterator().next();
        visitedVertices.add(startVertex);

        // Add all edges connected to the start vertex to the priority queue
        for (Edge<V, E> edge : g.outgoingEdges(startVertex)) {
            edgeQueue.add(edge);
        }

        // Continue adding edges until all vertices are visited
        while (visitedVertices.size() < g.numVertices()) {
            // Obtenha a aresta de peso mínimo da fila de prioridade
            Edge<V, E> minEdge = edgeQueue.poll();
            // Check if the priority queue is empty
            if (minEdge == null) {
                // The graph is not connected
                break;
            }

            // Obtenha o vértice de destino da aresta de peso mínimo
            V destVertex = minEdge.getVDest();

            // Verifique se adicionar esta aresta cria um ciclo
            if (!visitedVertices.contains(destVertex)) {
                // Adicione o vértice de destino ao conjunto de vértices visitados
                visitedVertices.add(destVertex);

                // Adicione a aresta à árvore de abrangência mínima
                minimumSpanningTree.addEdge(minEdge.getVOrig(), destVertex, minEdge.getWeight());

                // Adicione todas as arestas conectadas ao vértice de destino à fila de prioridade
                for (Edge<V, E> edge : g.outgoingEdges(destVertex)) {
                    edgeQueue.add(edge);
                }
            }
        }
        return minimumSpanningTree;
    }
}