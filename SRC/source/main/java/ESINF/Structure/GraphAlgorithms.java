
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
        Set<V> visitedVertices = new HashSet<>();

        PriorityQueue<Edge<V, E>> edgeQueue = new PriorityQueue<>(Comparator.comparing(e -> e.getWeight(), ce));

        MapGraph<V, E> minimumSpanningTree = new MapGraph<>(true);

        V startVertex = g.vertices().iterator().next();
        visitedVertices.add(startVertex);

        for (Edge<V, E> edge : g.outgoingEdges(startVertex)) {
            edgeQueue.add(edge);
        }

        while (visitedVertices.size() < g.numVertices()) {
            Edge<V, E> minEdge = edgeQueue.poll();
            if (minEdge == null) {
                break;
            }

            V destVertex = minEdge.getVDest();

            if (!visitedVertices.contains(destVertex)) {
                visitedVertices.add(destVertex);

                minimumSpanningTree.addEdge(minEdge.getVOrig(), destVertex, minEdge.getWeight());

                for (Edge<V, E> edge : g.outgoingEdges(destVertex)) {
                    edgeQueue.add(edge);
                }
            }
        }
        return minimumSpanningTree;
    }

    public static <V,E> E shortestsPaths(Graph<V, E> g, V vOrig, V vDest, Comparator<E> ce, BinaryOperator<E> sum, E zero, LinkedList<V> shortPath) {
        if(!g.validVertex(vOrig) || !g.validVertex(vDest)){
            return null;
        }

        shortPath.clear();
        int numVerts = g.numVertices();
        boolean[] visited = new boolean[numVerts];
        V[] pathKeys = (V[]) new Object [numVerts];
        E[] dist = (E[]) new Object [numVerts];
        initializePathDist(numVerts, pathKeys, dist);

        shortestPathDijkstra(g, vOrig, ce, sum, zero, visited, pathKeys, dist);

        E lengthPath = dist[g.key(vDest)];

        if(lengthPath != null){
            getPath(g, vOrig, vDest, pathKeys, shortPath);
            return lengthPath;
        }

        return null;
    }
    public static <V, E> boolean shortestsPaths(Graph<V, E> g, V vOrig,
                                               Comparator<E> ce, BinaryOperator<E> sum, E zero,
                                               ArrayList<LinkedList<V>> paths, ArrayList<E> dists) {

        if (!g.validVertex(vOrig)) {
            return false;
        }
        paths.clear();
        dists.clear();
        int numVertices = g.numVertices();
        boolean[] visited = new boolean[numVertices];
        V[] pathKeys = (V[]) new Object[numVertices];
        E[] dist = (E[]) new Object[numVertices];
        initializePathDist(numVertices, pathKeys, dist);

        shortestPathDijkstra(g, vOrig, ce, sum, zero, visited, pathKeys, dist);

        dists.clear();
        paths.clear();
        for (int i = 0; i < numVertices; i++) {
            paths.add(null);
            dists.add(null);
        }
        for (V vDist:g.vertices()) {
            int i = g.key(vDist);
            if(dist[i] != null){
                LinkedList<V> shortPath = new LinkedList<>();
                getPath(g, vOrig, vDist, pathKeys, shortPath);
                paths.set(i, shortPath);
                dists.set(i, dist[i]);
            }
        }

        return true;
    }
    private static <V, E> void getPath(Graph<V, E> g, V vOrig, V vDest,
                                       V [] pathKeys, LinkedList<V> path) {

        if (vOrig.equals(vDest))
            path.push(vDest);
        else {
            path.push(vDest);
            int keyVDest = g.key(vDest);
            vDest = pathKeys[keyVDest];
            getPath(g, vOrig, vDest, pathKeys, path);
        }
    }

    public static <V, E> Map<V, Integer> betweennessCentrality(Graph<V, E> graph) {
        Map<V, Integer> centrality = new HashMap<>();

        for (V vertex : graph.vertices()) {
            centrality.put(vertex, 0);
        }

        for (V source : graph.vertices()) {
            LinkedList<V> queue = new LinkedList<>();
            queue.add(source);

            Map<V, Integer> numShortestPaths = new HashMap<>();
            numShortestPaths.put(source, 1);

            Map<V, Integer> dependency = new HashMap<>();
            for (V vertex : graph.vertices()) {
                dependency.put(vertex, 0);
            }

            Map<V, Integer> distance = new HashMap<>();
            distance.put(source, 0);

            while (!queue.isEmpty()) {
                V currentVertex = queue.poll();

                for (V neighbor : graph.adjVertices(currentVertex)) {
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, distance.get(currentVertex) + 1);
                        queue.add(neighbor);
                    }

                    if (distance.get(neighbor) == distance.get(currentVertex) + 1) {
                        numShortestPaths.put(neighbor, numShortestPaths.getOrDefault(neighbor, 0) + numShortestPaths.get(currentVertex));
                        dependency.put(neighbor, dependency.get(neighbor) + 1);
                    }
                }
            }

            for (V vertex : graph.vertices()) {
                if (!vertex.equals(source)) {
                    Integer currentCentrality = centrality.get(vertex);
                    Integer currentDependency = dependency.get(vertex);
                    Integer currentNumShortestPaths = numShortestPaths.get(vertex);

                    if (currentCentrality == null) {
                        currentCentrality = 0;
                    }
                    if (currentDependency == null) {
                        currentDependency = 0;
                    }
                    if (currentNumShortestPaths == null) {
                        currentNumShortestPaths = 1; // Avoid division by zero
                    }

                    centrality.put(vertex, currentCentrality + (currentDependency / currentNumShortestPaths));
                }
            }

        }

        return centrality;
    }

    public static <V, E> void initializePathDist(int numVerts, V[] pathKeys, E[] dist){
        for (int i = 0; i < numVerts; i++) {
            pathKeys[i]=null;
            dist[i] = null;
        }
    }
    public static <V, E> void shortestPathDijkstra(Graph<V, E> g, V vOrig,
                                                   Comparator<E> ce, BinaryOperator<E> sum, E zero,
                                                   boolean[] visited, V[] pathKeys, E[] dist) {

        int vKey = g.key(vOrig);
        dist[vKey] = zero;
        pathKeys[vKey] = vOrig;

        while (vOrig != null) {
            vKey = g.key(vOrig);
            visited[vKey] = true;
            for (Edge<V, E> edge : g.outgoingEdges(vOrig)) {
                int keyVAdj = g.key(edge.getVDest());
                if (!visited[keyVAdj]) {
                    E s = sum.apply(dist[vKey], edge.getWeight());
                    if (dist[keyVAdj] == null || ce.compare(dist[keyVAdj], s) > 0) {
                        dist[keyVAdj] = s;
                        pathKeys[keyVAdj] = vOrig;
                    }
                }
            }

            E minDist = null;
            vOrig = null;
            for (V vertex : g.vertices()) {
                int vertexKey = g.key(vertex);
                if (!visited[vertexKey] && (dist[vertexKey] != null) && ((minDist == null) || ce.compare(dist[vertexKey], minDist) < 0)) {
                    minDist = dist[vertexKey];
                    vOrig = vertex;
                }
            }
        }
    }
}