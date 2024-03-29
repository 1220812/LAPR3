package ESINF.US01;

import ESINF.Domain.Locality;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * The {@code NetworkBuilderTest} class contains JUnit tests for the {@link NetworkBuilder} class.
 */
class NetworkBuilderTest {
    private NetworkBuilder networkBuilder;

    /**
     * Sets up the test environment before each test method.
     */
    @BeforeEach
    public void setUp(){
        networkBuilder = NetworkBuilder.getInstance();
    }
    /**
     * Tests the {@link NetworkBuilder# addHub(String, double, double)} method.
     */
    /*
    @Test
    void addHub() {
        NetworkBuilder networkBuilder1 = NetworkBuilder.getInstance();

        assertNotNull(networkBuilder1);

        boolean flag1 = networkBuilder1.addLocality("1", 37.7749, -122.4194);
        boolean flag2 = networkBuilder1.addLocality("2",  -34.6118, -58.4173);
        boolean flag3 = networkBuilder1.addLocality("3", 51.5074, -0.1278);

        assertTrue(flag1);
        assertTrue(flag2);
        assertTrue(flag3);

        assertTrue(networkBuilder1.getDistribution().vertices().contains(new Locality("1", 37.7749, -122.4194)));
        assertTrue(networkBuilder1.getDistribution().vertices().contains(new Locality("2",  -34.6118, -58.4173)));
        assertTrue(networkBuilder1.getDistribution().vertices().contains(new Locality("3",  51.5074, -0.1278)));
    }
    */

    /**
     * Tests the {@link NetworkBuilder# addRoute(Hub, Hub, double)} method.
     */
    /*
    @Test
    void addRoute() {
        NetworkBuilder networkBuilder1 = NetworkBuilder.getInstance();

        networkBuilder1.addLocality("1", 37.7749, -122.4194);
        networkBuilder1.addLocality("2",  -34.6118, -58.4173);

        boolean added = networkBuilder1.addRoute(new Locality("1", 37.7749, -122.4194), new Locality("2", -34.6118, -58.4173), 83);

        assertTrue(added);

        assertNotNull(networkBuilder1.getDistribution().edge(new Locality("1", 37.7749, -122.4194), new Locality("2", -34.6118, -58.4173)));
    }
    */

    /**
     * Tests the {@link NetworkBuilder# addRoute(Hub, Hub, double)} method for duplicate routes.
     */
    /*
    @Test
    void addDuplicatedRoute(){
        NetworkBuilder networkBuilder1 = NetworkBuilder.getInstance();

        networkBuilder1.addLocality("1", 37.7749, -122.4194);
        networkBuilder1.addLocality("2",  -34.6118, -58.4173);

        assertTrue(networkBuilder1.addRoute(new Locality("1", 37.7749, -122.4194), new Locality("2",  -34.6118, -58.4173), 83));
        assertFalse(networkBuilder1.addRoute(new Locality("1", 37.7749, -122.4194), new Locality("2",  -34.6118, -58.4173), 29));
    }
    */

    /**
     * Clears the test environment after each test method.
     */
    /*
    @AfterEach
    public void clear(){
        for (Locality locality : networkBuilder.getDistribution().vertices()) {
            networkBuilder.getDistribution().removeVertex(locality);
        }
    }
    */
}