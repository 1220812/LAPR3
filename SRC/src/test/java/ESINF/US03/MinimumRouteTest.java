package ESINF.US03;

import ESINF.Algorithm.Algorithms;
import ESINF.Domain.Coordinates;
import ESINF.Domain.Hub;
import ESINF.Structure.Auxiliary.Path;
import ESINF.Structure.Graph;
import ESINF.Structure.MapGraph;
import ESINF.Structure.MoreGraphAlgorithms;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Minimum route test.
 */
public class MinimumRouteTest {

    /**
     * Test find trip manifesto for most distant vertex with valid path.
     */
    @Test
    public void testFindTripManifestoForMostDistantVertexWithValidPath() {
        Algorithms algorithms = new Algorithms();

        // Create a sample graph
        MapGraph<Hub, Integer> graph = new MapGraph<>(false);
        Hub origin = new Hub("CT1");
        Hub intermediate1 = new Hub("CT2");
        Hub destination = new Hub("CT3");
        graph.addVertex(origin);
        graph.addVertex(intermediate1);
        graph.addVertex(destination);
        graph.addEdge(origin, intermediate1, 20);
        graph.addEdge(intermediate1, destination, 20);

        // Set up a valid path in the graph
        List<ESINF.Structure.Auxiliary.Segment<Hub>> pathSegments = new LinkedList<>();
        pathSegments.add(new ESINF.Structure.Auxiliary.Segment<>(origin, intermediate1, 20));
        pathSegments.add(new ESINF.Structure.Auxiliary.Segment<>(intermediate1, destination, 20));

        Path<Hub> path = new Path<>(origin, destination, pathSegments);

        // Set vehicle autonomy
        double vehicleAutonomy = 100.0;

        // Call the method under test
        MinimumRoute result = algorithms.findTripManifestoForMostDistantVertex(graph, vehicleAutonomy);

        // Assertions
        assertNotNull(result);
        assertEquals(destination, result.getDestination());
        assertEquals(vehicleAutonomy, result.getVehicleAutonomy(), 0.001); // Adjust delta as needed
        assertEquals(Arrays.asList(origin, intermediate1, destination), result.getRoute());

        // Compare elements in the set, not the sets themselves
        Set<Hub> expectedStops = new HashSet<>(Arrays.asList(intermediate1));


    }

    /**
     * Test find trip manifesto for most distant vertex with no valid path.
     */
    @Test
    public void testFindTripManifestoForMostDistantVertexWithNoValidPath() {
        Algorithms algorithms = new Algorithms();

        // Create a sample graph with no edges
        MapGraph<Hub, Integer> graph = new MapGraph<>(false);

        // Set vehicle autonomy
        double vehicleAutonomy = 100.0;

        // Call the method under test
        MinimumRoute result = algorithms.findTripManifestoForMostDistantVertex(graph, vehicleAutonomy);

        // Assertions
        assertNull(result);
    }

    /**
     * Test most distant vertex on graph.
     */
    @Test
    void testMostDistantVertexOnGraph() {
        // Crie um grafo de teste
        MapGraph<String, Integer> graph = new MapGraph<>(false);

        // Adicione vértices ao grafo
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        // Adicione arestas ponderadas ao grafo
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 8);
        graph.addEdge("B", "D", 10);
        graph.addEdge("C", "D", 6);

        // Chame o método mostDistantVertexOnGraph
        Path<String> result = MoreGraphAlgorithms.mostDistantVertexOnGraph(graph);

        // Faça asserções para verificar se o resultado é o esperado
        assertNotNull(result); // O resultado não deve ser nulo se o grafo não estiver vazio

        // Adicione mais asserções conforme necessário com base na lógica do método
        assertEquals("A", result.getOrigin()); // Verifique se o ponto de origem está correto
        assertEquals("D", result.getDestination()); // Verifique se o ponto de destino está correto
        // Adicione mais asserções com base na lógica específica do seu método

    }


    /**
     * Test distance equals.
     */
    @Test
    void testDistanceEquals() {
        // Caso de teste 1: Distância entre coordenadas iguais deve ser zero
        Coordinates route1 = new Coordinates(12, 12);
        assertEquals(0, route1.distance(12, 12), 0.001);

        // Caso de teste 2: Distância entre coordenadas diferentes
        Coordinates route2 = new Coordinates(0, 0);
        assertEquals(157249.38127194397, route2.distance(1, 1), 0.001);

        // Caso de teste 3: Distância entre coordenadas com latitudes e longitudes negativas
        Coordinates route3 = new Coordinates(-10, -10);
        assertEquals(156177.69200334867, route3.distance(-9, -9), 0.001);

    }

    /**
     * Test distance not equals.
     */
    @Test
    void testDistanceNotEquals() {
        // Caso de teste 1: Distância entre coordenadas iguais deve ser zero
        Coordinates route1 = new Coordinates(12, 12);
        assertNotEquals(157255.36937855952, route1.distance(12, 12), 0.001);

        // Caso de teste 2: Distância entre coordenadas diferentes
        Coordinates route2 = new Coordinates(0, 0);
        assertNotEquals(0, route2.distance(1, 1), 0.001);

        // Caso de teste 3: Distância entre coordenadas com latitudes e longitudes negativas
        Coordinates route3 = new Coordinates(-10, -10);
        assertNotEquals(-156065.3500008355, route3.distance(-9, -9), 0.001);


    }

    /**
     * Test distance to.
     */
    @Test
    public void testDistanceTo() {
        // Criar instâncias de dois hubs para teste
        Hub hub1 = new Hub( "Hub1", 40.7128, -74.0060);
        Hub hub2 = new Hub( "Hub2", 34.0522, -118.2437);
        Hub hub3 = new Hub( "Hub3", 41.8781, -87.6298);
        Hub hub4 = new Hub( "Hub4", 29.7604, -95.3698);
        Hub hub5 = new Hub( "Hub5", 32.7767, -96.7970);


        assertEquals(1.5423443758958094E7, hub1.distanceTo(hub2), 0.1);
        assertEquals(1.3077418011800507E7, hub2.distanceTo(hub1), 0.1);
        assertEquals(1.265031125371605E7, hub2.distanceTo(hub3), 0.1);
        assertEquals(1.350878825431042E7, hub3.distanceTo(hub4), 0.1);
        assertEquals(1.3285602970991598E7, hub4.distanceTo(hub5), 0.1);
        assertEquals(1.2835343466286177E7, hub5.distanceTo(hub4), 0.1);

    }

}