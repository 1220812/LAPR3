package ESINF.US09;

import ESINF.Domain.Coordinates;
import ESINF.Domain.Locality;
import ESINF.Domain.Schedule;
import ESINF.Structure.MapGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class OrganizeClustersWithLocalitysTest {

    private MapGraph<Locality, Double> graph;


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
    public void testFormClustersAndMapHubs() {
        // Call the method from OrganizeClustersWithHubs to form clusters and map hubs
        Map<Locality, List<Locality>> hubsToClusters = OrganizeClustersWithHubs.formClustersAndMapHubs(graph, 2);
        List<Set<Locality>> clusters = OrganizeClustersWithHubs.getClusters(graph);

        // Assert that the result is not null
        assertNotNull(hubsToClusters);
    }

    @Test
    public void testGetClusters() {
        // Call the getClusters method from OrganizeClustersWithHubs
        Map<Locality, List<Locality>> hubsToClusters = OrganizeClustersWithHubs.formClustersAndMapHubs(graph, 2);
        List<Set<Locality>> clusters = OrganizeClustersWithHubs.getClusters(graph);

        // Assert that the clusters are not null
        assertNotNull(clusters);

        // Add more assertions as needed...
    }

    @Test
    public void testGetClustersAfterFormingClusters() {
        // Ensure that clusters are formed before retrieving them
        boolean clustersFormed = OrganizeClustersWithHubs.formClusters(graph, 2);
        assertTrue(clustersFormed);

        List<Set<Locality>> clusters = OrganizeClustersWithHubs.getClusters(graph);
        assertNotNull(clusters);

        // Add more assertions as needed...
    }

}