package ESINF.US02;

import ESINF.Domain.Locality;
import ESINF.Structure.GraphAlgorithms;
import ESINF.Structure.MapGraph;

import java.util.*;

/**
 * The {@code HubDefiner} class provides methods to analyze a graph of localities
 * and calculate various metrics such as influence, proximity, and centrality.
 * It also includes methods to identify and retrieve the top N hubs based on different criteria.
 */
public class HubDefiner {

    /**
     * Calculates and returns the influence of each locality in the given graph (vertex with more out degree, meaning, more edges to other vertexs)
     *
     * @param graph The graph representing localities and connections.
     * @return A map with localities as keys and their influence values as values.
     */
    public Map<Locality, Integer> calculateInfluence(MapGraph<Locality, Integer> graph) {
        Map<Locality, Integer> networkByInfluence = new HashMap<>();
        for (Locality vertex : graph.vertices()) {
            networkByInfluence.put(vertex, graph.outDegree(vertex));
        }
        return networkByInfluence;
    }

    /**
     * Calculates and returns the proximity of each locality in the given graph.
     *
     * @param graph The graph representing localities and connections.
     * @return A map with localities as keys and their proximity values as values.
     */

    public Map<Locality, Integer> calculateProximity(MapGraph<Locality, Integer> graph) {
        Map<Locality, Integer> networkByProximity = new HashMap<>();
        for (Locality vertex : graph.vertices()) {
            Integer proximityValue = calculateVertexProximity(graph, vertex);
            networkByProximity.put(vertex, proximityValue);
        }
        return networkByProximity;
    }

    /**
     * Calculates the proximity of a specific locality in the given graph.
     *
     * @param graph  The graph representing localities and connections.
     * @param vertex The locality for which proximity is calculated.
     * @return The proximity value for the specified locality.
     */
    private Integer calculateVertexProximity(MapGraph<Locality, Integer> graph, Locality vertex) {
        ArrayList<Integer> distances = new ArrayList<>();
        GraphAlgorithms.shortestsPaths(graph, vertex, Comparator.naturalOrder(), Integer::sum, 0 , new ArrayList<>(),distances);

        int proximitySum = 0;
        for (Integer distance : distances) {
            if (distance != null) {
                proximitySum += distance;
            }
        }
        return proximitySum;
    }

    /**
     * Calculates and returns the centrality of each locality in the given graph.
     *
     * @param graph The graph representing localities and connections.
     * @return A map with localities as keys and their centrality values as values.
     */
    public Map<Locality, Integer> calculateCentrality(MapGraph<Locality, Integer> graph) {
        Map<Locality, Integer> centrality = GraphAlgorithms.betweennessCentrality(graph);
        return centrality;
    }

    /**
     * Retrieves the top N hubs based on a given map of localities and values.
     * The sorting order can be specified with the isProximity parameter.
     *
     * @param map         The map of localities and their values.
     * @param n           The number of top hubs to retrieve.
     * @param isProximity A boolean indicating whether to sort by proximity (true) or influence (false).
     * @return A map with the top N hubs based on the specified criteria.
     */
    public Map<Locality, Integer> getTopNHubsSeparate(Map<Locality, Integer> map, Integer n, boolean isProximity) {
        Map<Locality, Integer> topNHubs = new LinkedHashMap<>();
        List<Map.Entry<Locality, Integer>> sortedEntries = new ArrayList<>(map.entrySet());

        if (isProximity) {
            sortedEntries.sort(Map.Entry.comparingByValue());
        } else {
            sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        }

        int count = 0;
        for (Map.Entry<Locality, Integer> entry : sortedEntries) {
            if (count < n) {
                topNHubs.put(entry.getKey(), entry.getValue());
                count++;
            } else {
                break;
            }
        }
        return topNHubs;
    }

    /**
     * Retrieves the top N hubs based on a map of localities and lists of values.
     * The sorting order is based on centrality, influence, and a third criterion.
     *
     * @param map The map of localities and lists of values.
     * @param n   The number of top hubs to retrieve.
     * @return A map with the top N hubs based on multiple criteria.
     */
    public Map<Locality, List<Integer>> getTopNMap(Map<Locality, List<Integer>> map, Integer n) {
        List<Map.Entry<Locality, List<Integer>>> entries = new ArrayList<>(map.entrySet());
        entries.sort((entry1, entry2) -> {
            List<Integer> values1 = entry1.getValue();
            List<Integer> values2 = entry2.getValue();

            int compareCentrality = Integer.compare(values2.get(0), values1.get(0));
            if (compareCentrality != 0) {
                return compareCentrality;
            }

            int compareInfluence = Integer.compare(values2.get(1), values1.get(1));
            if (compareInfluence != 0) {
                return compareInfluence;
            }

            return Integer.compare(values1.get(2), values2.get(2));
        });

        Map<Locality, List<Integer>> sortedFinalMap = new LinkedHashMap<>();
        for (Map.Entry<Locality, List<Integer>> entry : entries) {
            sortedFinalMap.put(entry.getKey(), entry.getValue());
        }

        return getTopNHubs(sortedFinalMap, n);
    }

    /**
     * Retrieves the top N hubs based on a map of localities and lists of values.
     *
     * @param map The map of localities and lists of values.
     * @param n   The number of top hubs to retrieve.
     * @return A map with the top N hubs based on the specified criteria.
     */
    public static Map<Locality, List<Integer>> getTopNHubs(Map<Locality, List<Integer>> map, Integer n) {
        Map<Locality, List<Integer>> topNHubsMap = new LinkedHashMap<>();

        int count = 0;
        for (Map.Entry<Locality, List<Integer>> entry : map.entrySet()) {
            if (count < n) {
                topNHubsMap.put(entry.getKey(), entry.getValue());
                count++;
            } else {
                break;
            }
        }

        return topNHubsMap;
    }

    public MapGraph<Locality, Integer> defineHubs(MapGraph<Locality, Integer> graph, Integer n) {
        Map<Locality, List<Integer>> map = new HashMap<>();
        for (Locality vertex : graph.vertices()) {
            List<Integer> values = Arrays.asList(graph.outDegree(vertex), calculateVertexProximity(graph, vertex), 0);
            map.put(vertex, values);
        }

        Map<Locality, List<Integer>> maps = getTopNHubs(map, n);

        for (Locality locality : graph.vertices()) {
            if(maps.containsKey(locality)){
                graph.vertex(p->p.equals(locality)).setHub(true);
            }
        }
        return graph;
    }

    public static Locality findLocalityByID (Map<Locality, List<Integer>> map , String ID){
        for (Locality locality : map.keySet()) {
            if(locality.getName().equals(ID)){
                return locality;
            }
        }
        return null;
    }
}
