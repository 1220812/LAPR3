package ESINF.US09;

import ESINF.Domain.Locality;
import ESINF.Structure.Edge;
import ESINF.Structure.Graph;
import ESINF.Structure.GraphAlgorithms;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;
import ESINF.US02.HubDefiner;


import java.util.*;
import java.util.function.BinaryOperator;

public class OrganizeClustersWithHubs {

    NetworkBuilder networkBuilder = NetworkBuilder.getInstance();
    /*
    public Graph<Locality, Double> getGraph() {
        return networkBuilder.getDistribution();
    }

     */

    public static boolean formClusters(Graph<Locality, Double> g, int desiredNumClusters) {

        Map<Edge<Locality, Double>, Integer> edgeBetweenness = new HashMap<>();
        calculateEdgeBetweenness(g, edgeBetweenness);
        if(HubDefiner.numHubs((MapGraph<Locality, Double>) g)<desiredNumClusters){
            return false;
        }
        while (getClusters(g).size() < desiredNumClusters) {
            Edge<Locality, Double> edgeToRemove = getEdgeWithHighestBetweenness(edgeBetweenness);
            if (edgeToRemove != null) {
                edgeBetweenness.remove(edgeToRemove);
                if (canRemoveEdge(g, edgeToRemove)) {
                    g.removeEdge(edgeToRemove.getVOrig(), edgeToRemove.getVDest());
                }
            } else {
                break;
            }
        }
        return true;
    }


    public static List<Set<Locality>> getClusters(Graph<Locality, Double> g) {
        boolean[] visited = new boolean[g.numVertices()];
        List<Set<Locality>> clusters = new ArrayList<>();

        for (Locality vert : g.vertices()) {
            if (!visited[g.key(vert)]) {
                LinkedList<Locality> clusterVertices = new LinkedList<>();
                GraphAlgorithms.depthFirstSearch(g, vert, visited, clusterVertices);

                Set<Locality> cluster = new HashSet<>(clusterVertices);
                clusters.add(cluster);
            }
        }
        return clusters;
    }


    static boolean canRemoveEdge(Graph<Locality, Double> g, Edge<Locality, Double> edge) {
        Graph<Locality, Double> clone = g.clone();
        clone.removeEdge(edge.getVOrig(), edge.getVDest());
        List<Set<Locality>> clusters = getClusters(clone);
        for (Set<Locality> cluster : clusters) {
            if (!hasPromotedHub(cluster)) {
                return false;
            }
        }
        return true;
    }


    private static boolean hasPromotedHub(Set<Locality> cluster) {
        for (Locality locality : cluster) {
            if (locality.isPromoted()) {
                return true;
            }
        }
        return false;
    }


    public static void calculateEdgeBetweenness(Graph<Locality, Double> g, Map<Edge<Locality, Double>, Integer> edgeBetweenness) {
        Comparator<Double> ce = Comparator.naturalOrder();
        BinaryOperator<Double> sum = Double::sum;
        List<Locality> vertices = g.vertices();
        int numVertices = vertices.size();

        for (Edge<Locality, Double> edge : g.edges()) {
            Edge<Locality, Double> reverseEdge = g.edge(edge.getVDest(), edge.getVOrig());
            if (reverseEdge != null && !edgeBetweenness.containsKey(reverseEdge)) {
                edgeBetweenness.putIfAbsent(edge, 0);
            }


        }

        for (int i = 0; i < numVertices; i++) {
            Locality source = vertices.get(i);
            ArrayList<LinkedList<Locality>> allPaths = new ArrayList<>();
            ArrayList<Double> allDists = new ArrayList<>();
            GraphAlgorithms.shortestPathsUS09(g, source, ce, sum, 0.0, allPaths, allDists);

            for (int j = i + 1; j < numVertices; j++) {
                LinkedList<Locality> path = allPaths.get(j);
                if (path != null && path.size() > 1) {
                    Iterator<Locality> it = path.iterator();
                    Locality v1 = it.next();

                    while (it.hasNext()) {
                        Locality v2 = it.next();
                        Edge<Locality, Double> edge = g.edge(v1, v2);
                        Edge<Locality, Double> reverseEdge = g.edge(v2, v1);

                        if (edge != null) {
                            if (edgeBetweenness.containsKey(reverseEdge)) {
                                edgeBetweenness.put(reverseEdge, edgeBetweenness.get(reverseEdge) + 1);
                            } else {
                                edgeBetweenness.put(edge, edgeBetweenness.getOrDefault(edge, 0) + 1);
                            }
                        }
                        v1 = v2;
                    }
                }
            }
        }
    }


    private static Edge<Locality, Double> normalizeEdge(Graph<Locality, Double> g, Locality v1, Locality v2) {
        Edge<Locality, Double> directEdge = g.edge(v1, v2);
        Edge<Locality, Double> reverseEdge = g.edge(v2, v1);
        return (directEdge != null) ? directEdge : reverseEdge;
    }


    public static Edge<Locality, Double> getEdgeWithHighestBetweenness(Map<Edge<Locality, Double>, Integer> edgeBetweenness) {
        Edge<Locality, Double> maxEdge = null;
        int maxBetweenness = -1;
        String minEdgeName = null;

        for (Map.Entry<Edge<Locality, Double>, Integer> entry : edgeBetweenness.entrySet()) {
            Edge<Locality, Double> edge = entry.getKey();
            int betweenness = entry.getValue();

            String v1Name = edge.getVOrig().toString();
            String v2Name = edge.getVDest().toString();
            String edgeName = v1Name.compareTo(v2Name) < 0 ? v1Name + v2Name : v2Name + v1Name;

            if (betweenness > maxBetweenness || (betweenness == maxBetweenness && (minEdgeName == null || edgeName.compareTo(minEdgeName) < 0))) {
                maxEdge = edge;
                maxBetweenness = betweenness;
                minEdgeName = edgeName;
            }
        }
        return maxEdge;
    }


    public static Map<Locality, List<Locality>> mapPromotedHubsToClusters(List<Set<Locality>> clusters) {
        Map<Locality, List<Locality>> promotedHubsToClusters = new HashMap<>();
        for (Set<Locality> cluster : clusters) {
            for (Locality locality : cluster) {
                if (locality.isPromoted()) {
                    promotedHubsToClusters.put(locality, new ArrayList<>(cluster));
                    break;
                }
            }
        }
        return promotedHubsToClusters;
    }


    public static Map<Locality, List<Locality>> formClustersAndMapHubs(Graph<Locality, Double> g, int desiredNumClusters) {
        boolean clustersFormed = formClusters(g, desiredNumClusters);
        if (!clustersFormed) {
            return null;
        }
        List<Set<Locality>> clusters = getClusters(g);
        return mapPromotedHubsToClusters(clusters);
    }

}
