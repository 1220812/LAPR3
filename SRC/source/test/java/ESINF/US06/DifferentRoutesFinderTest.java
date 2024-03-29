package java.ESINF.US06;

import ESINF.Domain.Locality;
import ESINF.Domain.LocalityPair;
import ESINF.Domain.PathInfo;
import ESINF.Domain.Vehicle;
import ESINF.FileReader.ReaderFiles;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;
import ESINF.US02.HubDefiner;
import ESINF.US06.DifferentRoutesFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class DifferentRoutesFinderTest {

    @BeforeEach
    void setUp() throws IOException {

        ReaderFiles.importLocalData("/Users/lourencomestre/Desktop/teste/src/main/resources/ESINF/locais_big.csv");
        ReaderFiles.importDistanceData("/Users/lourencomestre/Desktop/teste/src/main/resources/ESINF/distancias_big.csv", "/Users/lourencomestre/Desktop/teste/src/main/resources/ESINF/locais_big.csv");
    }

    @Test
    void testTotalTravelTime() {

        NetworkBuilder networkBuilder = NetworkBuilder.getInstance();

        MapGraph<Locality, Integer> graph = networkBuilder.getDistribution();
        int numberOfHubs = 5;

        HubDefiner hubDefiner = new HubDefiner();

        hubDefiner.defineHubs(graph, numberOfHubs);

        DifferentRoutesFinder routesFinder = new DifferentRoutesFinder();

        double travelTime = routesFinder.totalTravelTime(new Vehicle("50", 70, 300),270);
        double travelTime1 = routesFinder.totalTravelTime(new Vehicle("1", 50, 600),320);
        double travelTime2 = routesFinder.totalTravelTime(new Vehicle("95", 65, 450),0);

        double expected = (double) 270 /70;
        double expected1 = (double) 320 /50;
        double expected2 = (double) 0;

        assertEquals(expected, travelTime);
        assertEquals(expected1, travelTime1);
        assertEquals(expected2, travelTime2);

    }

    @Test
    void testCalculateTotalDistance() {

        DifferentRoutesFinder routesFinder = new DifferentRoutesFinder();

        // Test case 1: Empty list
        List<Locality> emptyList = new ArrayList<>();
        assertEquals(0.0, routesFinder.calculateTotalTravelDistance(emptyList));

        // Test case 2: Single locality
        List<Locality> singleLocality = new ArrayList<>();
        singleLocality.add(new Locality("A"));
        assertEquals(0.0, routesFinder.calculateTotalTravelDistance(singleLocality));

    }

    @Test
    void testRoutes() {

        DifferentRoutesFinder routesFinder = new DifferentRoutesFinder();
        NetworkBuilder networkBuilder = NetworkBuilder.getInstance();
        HubDefiner hubDefiner = new HubDefiner();
        MapGraph<Locality, Integer> graph = networkBuilder.getDistribution();
        int numberOfHubs = 5;
        graph = networkBuilder.getDistribution();
        hubDefiner.defineHubs(graph, numberOfHubs);


        Vehicle vehicle = new Vehicle("1", 50, 600);
        Locality origin = graph.vertex(10);
        Locality destination = graph.vertex(20);


        TreeMap<LocalityPair, PathInfo> result = routesFinder.routes(origin, destination, vehicle);

        assertNotNull(result);
    }
}
