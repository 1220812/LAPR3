package ESINF.US03;

import ESINF.Algorithm.Algorithms;
import ESINF.Domain.Coordinates;
import ESINF.Domain.Hub;
import ESINF.Structure.Auxiliary.Path;
import ESINF.Structure.MapGraph;
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

}