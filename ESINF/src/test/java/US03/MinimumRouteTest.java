package US03;

import Algorithm.Algorithms;
import Domain.Hub;
import Structure.Auxiliary.Path;
import Structure.MapGraph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumRouteTest {

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
        List<Structure.Auxiliary.Segment<Hub>> pathSegments = new LinkedList<>();
        pathSegments.add(new Structure.Auxiliary.Segment<>(origin, intermediate1, 20));
        pathSegments.add(new Structure.Auxiliary.Segment<>(intermediate1, destination, 20));

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
}