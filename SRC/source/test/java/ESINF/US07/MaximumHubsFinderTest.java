package ESINF.US07;

import ESINF.Domain.Locality;
import ESINF.Domain.PathInfo;
import ESINF.FileReader.ReaderFiles;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;
import ESINF.US02.HubDefiner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaximumHubsFinderTest {
    private MapGraph<Locality, Integer> graph;
    private MaximumHubsFinder finder;
    private int number = 10;
    private Locality origin;
    private LocalTime startTime;
    private int autonomy;
    private double averageSpeed;
    private double chargeTime;
    private double unloadingTime;
    private LinkedList<Locality> donePath;

    @BeforeEach
    void SetUp() throws IOException {
        ReaderFiles.importLocalData("SRC/source/main/resources/ESINF/locais_small.csv");
        ReaderFiles.importDistanceData("SRC/source/main/resources/ESINF/distancias_small.csv", "SRC/source/main/resources/ESINF/locais_small.csv");
        HubDefiner hubDefiner = new HubDefiner();
        NetworkBuilder networkBuilder = NetworkBuilder.getInstance();
        graph = networkBuilder.getDistribution();
        hubDefiner.defineHubs(graph, number);
        donePath = new LinkedList<>();

        origin = graph.vertex(10);
        startTime = LocalTime.of(9,0);
        autonomy = 1000;
        averageSpeed = 60;
        chargeTime = 40;
        unloadingTime = 10;
    }


    @Test
    void getFinalTime() {
        double autonomy = 200;
        double averageVelocity = 60.0;
        double chargeTime = 30;
        double unloadingTime = 20;
        int numberOfUnloading = 4;
        LocalTime result = finder.getFinalTime(donePath, startTime, autonomy, averageVelocity, chargeTime, unloadingTime, numberOfUnloading, graph);
        assertNotNull(result);
    }

    @Test
    void intToLocalTime() {
        int inputTime1 = 70;
        LocalTime result1 = MaximumHubsFinder.intToLocalTime(inputTime1);
        assertEquals(LocalTime.of(1, 10), result1);

        int inputTime2 = 100;
        LocalTime result2 = MaximumHubsFinder.intToLocalTime(inputTime2);
        assertEquals(LocalTime.of(1, 40), result2);

        int inputTime3 = 34;
        LocalTime result3 = MaximumHubsFinder.intToLocalTime(inputTime3);
        assertEquals(LocalTime.of(0, 34), result3);
    }

    @Test
    void addTime() {
        LocalTime time1 = LocalTime.of(10, 15);
        LocalTime time2 = LocalTime.of(2, 30);

        MaximumHubsFinder hubsFinder = new MaximumHubsFinder();
        LocalTime result = hubsFinder.addTime(time1, time2);

        LocalTime expected = LocalTime.of(12, 45);

        assertNotNull(result);

        assertEquals(expected, result);
    }

    @Test
    void minusTime() {
        LocalTime time1 = LocalTime.of(15, 30);
        LocalTime time2 = LocalTime.of(12, 45);

        MaximumHubsFinder finder = new MaximumHubsFinder();
        LocalTime result = finder.minusTime(time1, time2);

        LocalTime expected = LocalTime.of(2, 45);

        assertNotNull(result);

        assertEquals(expected, result);
    }

    @Test
    void getAllHubsOnPath() {
        LinkedList<Locality> path = new LinkedList<>();

        List<Locality> result = MaximumHubsFinder.getAllHubsOnPath(path, new ArrayList<>());

        assertNotNull(result);
    }



    @Test
    void dataAnalyze() {
        MaximumHubsFinder calculator = new MaximumHubsFinder();
        LinkedList<Locality> path = null;
        PathInfo result = calculator.dataAnalyze(autonomy, path, graph);
        assertNotNull(result);
    }
    @Test
    void testBestPath(){

    }
}