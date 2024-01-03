package ESINF.US09;

import ESINF.Domain.Coordinates;
import ESINF.Domain.Locality;
import ESINF.Domain.Schedule;
import ESINF.Structure.Edge;
import ESINF.Structure.Graph;
import ESINF.Structure.MapGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


class OrganizeClustersWithLocalitysTest {

    private MapGraph<Locality, Double> graph;  // Change the type to Double


    @BeforeEach
    public void setUp() {
        graph = new MapGraph<>(false);

// Crie alguns Localitys para testar
        Locality locality1 = new Locality("CT1", 40.6389, -8.6553, false, new Schedule(LocalTime.of(9, 0), LocalTime.of(18, 0)));
        Locality locality2 = new Locality("CT2", 38.0333, -7.8833, false, new Schedule(LocalTime.of(9, 0), LocalTime.of(18, 0)));
        Locality locality13 = new Locality("CT3", 39.2369, -8.685, false, new Schedule(LocalTime.of(9, 0), LocalTime.of(18, 0)));
        Locality locality14 = new Locality("CT14", 38.5243, -8.8926, false, new Schedule(LocalTime.of(9, 0), LocalTime.of(18, 0)));
        Locality locality5 = new Locality("CT5", 39.823, -7.4931, false, new Schedule(LocalTime.of(9, 0), LocalTime.of(18, 0)));
        Locality locality7 = new Locality("CT7", 38.5667, -7.9, false, new Schedule(LocalTime.of(9, 0), LocalTime.of(18, 0)));
        Locality locality10 = new Locality("CT10", 39.7444, -8.8072, false, new Schedule(LocalTime.of(9, 0), LocalTime.of(18, 0)));
        Locality locality8 = new Locality("CT8", 37.0161, -7.935, false, new Schedule(LocalTime.of(9, 0), LocalTime.of(18, 0)));

        // Adicione os Localitys ao grafo
        graph.addVertex(locality1);
        graph.addVertex(locality2);
        graph.addVertex(locality13);
        graph.addVertex(locality14);
        graph.addVertex(locality5);
        graph.addVertex(locality7);
        graph.addVertex(locality10);
        graph.addVertex(locality8);



        // Adicione algumas arestas (exemplo: conexões entre Localitys)
        graph.addEdge(locality10, locality1, 110848.0);
        graph.addEdge(locality10, locality5, 125041.0);
        graph.addEdge(locality10, locality13, 63448.0);
        graph.addEdge(locality14, locality2, 114913.0);
        graph.addEdge(locality14, locality7, 95957.0);
        graph.addEdge(locality13, locality7, 111686.0);
        graph.addEdge(locality2, locality7, 65574.0);
        graph.addEdge(locality2, locality8, 125105.0);

        locality2.isPromoted();
        locality10.isPromoted();


    }
    @Test
    public void testFormClusters() {
        OrganizeClustersWithHubs organizer = new OrganizeClustersWithHubs();
        Graph<Locality, Double> distributionGraph = organizer.getGraph();

        // Assuming you want to form 2 clusters for testing
        int desiredNumClusters = 2;

        boolean clustersFormed = OrganizeClustersWithHubs.formClusters(distributionGraph, desiredNumClusters);

        assertTrue(clustersFormed);

        // Retrieve the clusters after forming
        List<Set<Locality>> clusters = OrganizeClustersWithHubs.getClusters(distributionGraph);

        // Check if each cluster has only one promoted hub
        for (Set<Locality> cluster : clusters) {
            long countPromotedHubs = cluster.stream().filter(Locality::isPromoted).count();
            assertEquals(1, countPromotedHubs);
        }

        // Optional: Print the clusters for debugging
        for (Set<Locality> cluster : clusters) {
            System.out.println("Cluster: " + cluster);
        }

        // Optional: You can also get the mapping of promoted hubs to clusters
        Map<Locality, List<Locality>> promotedHubsToClusters = OrganizeClustersWithHubs.mapPromotedHubsToClusters(clusters);

        // Optional: Print the mapping for debugging
        promotedHubsToClusters.forEach((hub, localityList) ->
                System.out.println("Hub: " + hub + ", Locality List: " + localityList)
        );
    }

    @Test
    public void testGetClusters2() {
        OrganizeClustersWithHubs organizer = new OrganizeClustersWithHubs();
        Graph<Locality, Double> distributionGraph = organizer.getGraph();

        // Assuming you want to form 2 clusters for testing
        int desiredNumClusters = 2;

        // Form clusters first
        boolean clustersFormed = OrganizeClustersWithHubs.formClusters(distributionGraph, desiredNumClusters);
        assertTrue(clustersFormed);

        // Retrieve the clusters after forming
        List<Set<Locality>> clusters = OrganizeClustersWithHubs.getClusters(distributionGraph);

        // Check if the number of clusters is as expected
        assertEquals(desiredNumClusters, clusters.size());

        // Optional: Print the clusters for debugging
        for (Set<Locality> cluster : clusters) {
            System.out.println("Cluster: " + cluster);
        }

        // Optional: Check if each cluster has at least one locality
        for (Set<Locality> cluster : clusters) {
            assertFalse(cluster.isEmpty());
        }
    }

 @Test
    public void testGetClusters() {
        OrganizeClustersWithHubs organizer = new OrganizeClustersWithHubs();
     Graph<Locality, Double> distributionGraph = organizer.getGraph();

        // Assuming you want to form 2 clusters for testing
        int desiredNumClusters = 2;

        // Form clusters first
        boolean clustersFormed = OrganizeClustersWithHubs.formClusters(distributionGraph, desiredNumClusters);
        assertTrue(clustersFormed);

        // Retrieve the clusters after forming
        List<Set<Locality>> clusters = OrganizeClustersWithHubs.getClusters(distributionGraph);

        // Check if the number of clusters is as expected
        assertEquals(desiredNumClusters, clusters.size());

        // Check if each cluster has at least one locality
        for (Set<Locality> cluster : clusters) {
            assertFalse(cluster.isEmpty());
        }

        // Check if all localities are covered in clusters
        Set<Locality> allLocalities = (Set<Locality>) distributionGraph.vertices();
        Set<Locality> allLocalitiesInClusters = clusters.stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());

        assertEquals(allLocalities, allLocalitiesInClusters);

        // Optional: Print the clusters for debugging
        for (Set<Locality> cluster : clusters) {
            System.out.println("Cluster: " + cluster);
        }
    }

    @Test
    public void testCanRemoveEdge() {
        OrganizeClustersWithHubs organizer = new OrganizeClustersWithHubs();
        Graph<Locality, Double> distributionGraph = organizer.getGraph();

        // Assuming you want to form 2 clusters for testing
        int desiredNumClusters = 2;

        // Form clusters first
        boolean clustersFormed = OrganizeClustersWithHubs.formClusters(graph, desiredNumClusters);
        assertTrue(clustersFormed);

        // Get the clusters after forming
        List<Set<Locality>> clusters = OrganizeClustersWithHubs.getClusters(graph);

        // Iterate through clusters to find a removable edge
        for (Set<Locality> cluster : clusters) {
            if (cluster.size() > 1) {
                // Get the first two localities in the cluster
                Locality locality1 = cluster.iterator().next();
                Locality locality2 = cluster.stream().skip(1).findFirst().orElse(null);

                // Get the edge between these two localities
                Edge<Locality, Double> edgeToRemove = graph.edge(locality1, locality2);

                if (edgeToRemove != null) {
                    // Check if removing the edge maintains the hub promotion criteria
                    boolean canRemove = OrganizeClustersWithHubs.canRemoveEdge(graph, edgeToRemove);
                    assertTrue(canRemove);

                    // Remove the edge and verify the resulting clusters
                    graph.removeEdge(edgeToRemove.getVOrig(), edgeToRemove.getVDest());
                    List<Set<Locality>> updatedClusters = OrganizeClustersWithHubs.getClusters(graph);

                    // Ensure that each cluster still has only one promoted hub
                    for (Set<Locality> updatedCluster : updatedClusters) {
                        long countPromotedHubs = updatedCluster.stream().filter(Locality::isPromoted).count();
                        assertEquals(1, countPromotedHubs);
                    }

                    // Optional: Print the updated clusters for debugging
                    for (Set<Locality> updatedCluster : updatedClusters) {
                        System.out.println("Updated Cluster: " + updatedCluster);
                    }

                    return; // Exit the test after finding and testing one removable edge
                }
            }
        }

        // If no removable edge is found, the test will fail
        fail("No removable edge found in the clusters.");
    }

}
