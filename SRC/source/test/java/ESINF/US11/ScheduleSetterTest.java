package ESINF.US11;

import ESINF.Domain.Locality;
import ESINF.Domain.Schedule;
import ESINF.FileReader.ReaderFiles;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;
import ESINF.US02.HubDefiner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleSetterTest {
    MapGraph<Locality, Integer> graph;
    int numberOfHubs = 5;
    HubDefiner hubDefiner;
    /**
     * Initializes the test environment by setting up the graph.
     */
    @BeforeEach
    void setUp() {
        graph = NetworkBuilder.getInstance().getDistribution();
    }
    /**
     * Tests the behavior of setting schedules on hub localities using the {@link ScheduleSetter} method.
     *
     * @throws IOException If an I/O error occurs during file reading.
     */
    @Test
    void scheduleSetterOnAHub() throws IOException {
        MapGraph<Locality, Integer> graphWithHubs = hubDefiner.defineHubs(graph, numberOfHubs);
        String fileName = "SRC/source/main/resources/ESINF/schedulesHub.txt";
        Map<Locality, Schedule> scheduleMap = ReaderFiles.importNewSchedules(fileName);
        ScheduleSetter.ScheduleSetter(scheduleMap, graphWithHubs);

        for (Locality vertex : graphWithHubs.vertices()) {
            if(scheduleMap.containsKey(vertex) && vertex.getHub()){
                Schedule expected = scheduleMap.get(vertex);
                Schedule actual = vertex.getSchedules();

                assertNotNull(actual, "Schedule should not be null for hub: " + vertex.getName());
                assertEquals(expected.getOpening(), actual.getOpening(), "Unexpected opening time for hub: " + vertex.getName());
                assertEquals(expected.getClosing(), actual.getClosing(), "Unexpected closing time for hub: " + vertex.getName());
            }
        }
    }
    /**
     * Tests the behavior of setting schedules on non-hub localities using the {@link ScheduleSetter} method.
     *
     * @throws IOException If an I/O error occurs during file reading.
     */
    @Test
    public void testSetSchedulesWithNoHubs() throws IOException {
        MapGraph<Locality, Integer> graphWithHubs = hubDefiner.defineHubs(graph, numberOfHubs);
        String fileName = "SRC/source/main/resources/ESINF/schedulesWithNoHubs.txt";
        Map<Locality, Schedule> scheduleMap = ReaderFiles.importNewSchedules(fileName);
        ScheduleSetter.ScheduleSetter(scheduleMap, graphWithHubs);

        for (Locality vertex : graphWithHubs.vertices()) {
            if (scheduleMap.containsKey(vertex) && !vertex.getHub()) {
                assertNull(vertex.getSchedules(), "Schedule should be null for non-hub: " + vertex.getName());
            }
        }
    }
}