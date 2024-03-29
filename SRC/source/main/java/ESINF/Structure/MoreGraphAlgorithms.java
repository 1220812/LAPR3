package ESINF.Structure;


import ESINF.Structure.Auxiliary.Counters;
import ESINF.Structure.Auxiliary.MyGraph;
import ESINF.Structure.Auxiliary.Pair;
import ESINF.Structure.Auxiliary.Path;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.text.Segment;
import java.util.*;

/**
 * The type More graph algorithms.
 */
public class MoreGraphAlgorithms extends GraphAlgorithms {

    /**
     * The constant THREAD_LIMIT.
     */
    public static final int THREAD_LIMIT = 8;


    @AllArgsConstructor
    private static class NumberOfShortestPathThatPassBy<V, E> implements Runnable {

        private Graph<V, E> graph;
        private V v1;
        private V v2;
        private V vertex;

        private List<List<V>> result;


        @Override
        public void run() {
            LinkedList<V> path = new LinkedList<>();
            shortestPath(graph, v1, v2, path);
            if (path.contains(vertex)) {
                result.add(path);
            }
        }
    }


    /**
     * Calculate centrality of all vertex map.
     *
     * @param <V>   the type parameter
     * @param <E>   the type parameter
     * @param graph the graph
     * @return the map
     */
    public static <V, E> Map<V, Counters> calculateCentralityOfAllVertex(Graph<V, E> graph) {
        Map<V, Counters> result = new HashMap<>();
        Map<V, Set<V>> hitMap = new HashMap<>();
        for (V v1 : graph.vertices()) {
            if (!hitMap.containsKey(v1)) {
                hitMap.put(v1, new HashSet<>());
            }
            for (V v2 : graph.vertices()) {
                if (v1.equals(v2)) continue;
                if (hitMap.get(v1).contains(v2)) continue;
                LinkedList<V> path = new LinkedList<>();
                shortestPath(graph, v1, v2, path);
                path.forEach(v -> {
                    if (!result.containsKey(v)) {
                        result.put(v, new Counters());
                    }
                    result.get(v).increment();
                });
                if (!hitMap.containsKey(v2)) {
                    hitMap.put(v2, new HashSet<>());
                }
                hitMap.get(v2).add(v1);
                hitMap.get(v1).add(v2);
            }
        }
        return result;
    }


    /**
     * Most distant vertex on graph path.
     *
     * @param <V>   the type parameter
     * @param <E>   the type parameter
     * @param graph the graph
     * @return the path
     */
    public static <V, E> Path<V> mostDistantVertexOnGraph(Graph<V, E> graph) {
        double distance = Double.MIN_VALUE;
        Pair<V, V> pair = null;
        LinkedList<V> shortestPath = null;

        Map<V, Set<V>> hitMap = new HashMap<>();


        for (V v1 : graph.vertices()) {
            if (!hitMap.containsKey(v1)) {
                hitMap.put(v1, new HashSet<>());
            }
            for (V v2 : graph.vertices()) {
                if (v1.equals(v2)) continue;
                if (hitMap.get(v1).contains(v2)) continue;
                LinkedList<V> path = new LinkedList<>();
                double delta = shortestPath(graph, v1, v2, path);
                if (delta > distance) {
                    distance = delta;
                    pair = new Pair<>(v1, v2);
                    shortestPath = path;
                }
                if (!hitMap.containsKey(v2)) {
                    hitMap.put(v2, new HashSet<>());
                }
                hitMap.get(v2).add(v1);
                hitMap.get(v1).add(v2);
            }
        }

        V start = null;
        List<ESINF.Structure.Auxiliary.Segment<V>> segments = new LinkedList<>();

        if (shortestPath != null) {
            for (V v : shortestPath) {
                if (start == null) {
                    start = v;
                    continue;
                }
                segments.add(new ESINF.Structure.Auxiliary.Segment<>(start, v, (Integer) graph.edge(start, v).getWeight()));
                start = v;
            }
        }
        if (pair != null) {
            return new Path<>(pair.getFirst(), pair.getSecond(), segments);
        } else {
            return null;
        }
    }

    /**
     * Minimal spanning tree graph .
     *
     * @param <V>   the type parameter
     * @param <E>   the type parameter
     * @param graph the graph
     * @return the graph
     */
    public static <V, E > Graph < V, E > minimalSpanningTree(Graph < V, E > graph) {
        Graph<V, E> result = new MyGraph<>(graph.isDirected());
        Set<Edge<V, E>> edges = new TreeSet<>();
        for (Edge<V, E> edge : graph.edges()) {
            edges.add(edge);
        }

        int target = graph.numVertices();
        Bundle<V> bundle = new Bundle<>(target);


        for (Edge<V, E> edge : edges) {
            if (bundle.isComplete()) break;
            if (edge.getVOrig().equals(edge.getVDest())) {
                continue;
            }
            if (bundle.areOnSameBundle(edge.getVOrig(), edge.getVDest())) continue;

            result.addVertex(edge.getVOrig());
            result.addVertex(edge.getVDest());
            result.addEdge(edge.getVOrig(), edge.getVDest(), edge.getWeight());
            bundle.addToBundle(edge.getVOrig(), edge.getVDest());
        }
        return result;
    }

    /**
     * Hierarchical clustering set .
     *
     * @param <V>              the type parameter
     * @param <E>              the type parameter
     * @param graph            the graph
     * @param numberOfClusters the number of clusters
     * @return the set
     */
    public static <V, E > Set < Cluster < V >> hierarchicalClustering(Graph < V, E > graph, int numberOfClusters){
        Set<Cluster<V>> clusters = new HashSet<>();

        for (V vertex : graph.vertices()) {
            if (!isVertexInClusters(vertex, clusters)) {
                Cluster<V> cluster = new Cluster<>();
                isVertexInClusters(vertex, clusters);
                clusters.add(cluster);
            }
        }
        return clusters;
    }


    private static <V > boolean isVertexInClusters (V vertex, Set < Cluster < V >> clusters){
        for (Cluster<V> cluster : clusters) {
            if (cluster.contains(vertex)) return true;
        }
        return false;
    }


    @Getter
    private static class Bundle<V> {
        private Set<V> largestBundle;
        private Map<V, Set<V>> bundle = new HashMap<>();
        private int target;

        /**
         * Instantiates a new Bundle.
         *
         * @param target the target
         */
        public Bundle(int target) {
            this.target = target;
        }

        /**
         * Are on same bundle boolean.
         *
         * @param v1 the v 1
         * @param v2 the v 2
         * @return the boolean
         */
        public boolean areOnSameBundle(V v1, V v2) {
            if (!bundle.containsKey(v1) || !bundle.containsKey(v2)) return false;
            return bundle.get(v1).contains(v2);
        }

        /**
         * Is complete boolean.
         *
         * @return the boolean
         */
        public boolean isComplete() {
            return largestBundle != null && largestBundle.size() >= target;
        }

        /**
         * Add to bundle boolean.
         *
         * @param v1 the v 1
         * @param v2 the v 2
         * @return the boolean
         */
        public boolean addToBundle(V v1, V v2) {
            if (areOnSameBundle(v1, v2)) return false;
            if (!bundle.containsKey(v1)) {
                bundle.put(v1, new HashSet<>());
            }
            if (!bundle.containsKey(v2)) {
                bundle.put(v2, new HashSet<>());
            }
            Set<V> merge = merge(v1, v2);

            if (largestBundle == null) {
                largestBundle = merge;
                return true;
            }
            if (merge.size() > largestBundle.size()) {
                largestBundle = merge;
            }
            return true;
        }


        /**
         * Merge set.
         *
         * @param v1 the v 1
         * @param v2 the v 2
         * @return the set
         */
        public Set<V> merge(V v1, V v2) {
            Set<V> bundle1 = bundle.get(v1);
            Set<V> bundle2 = bundle.get(v2);
            bundle1.add(v1);
            bundle1.add(v2);
            bundle1.addAll(bundle2);
            for (V v : bundle1) {
                bundle.put(v, bundle1);
            }
            return bundle1;
        }

    }

    /**
     * The type Cluster.
     *
     * @param <V> the type parameter
     */
    @Getter
    public static class Cluster<V> {
        private Set<V> nodes = new HashSet<>();


        /**
         * Contains boolean.
         *
         * @param element the element
         * @return the boolean
         */
        public boolean contains(V element) {
            return nodes.contains(element);
        }
    }


}

