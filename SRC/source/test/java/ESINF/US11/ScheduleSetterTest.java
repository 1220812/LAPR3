package ESINF.US11;

import ESINF.Domain.Locality;
import ESINF.FileReader.ReaderFiles;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;
import ESINF.US02.HubDefiner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleSetterTest {

    /**
     * Test method to verify the correctness of the {@code ScheduleSetter} method in the {@code ScheduleSetter} class.
     * It tests the modification of schedules for existing localities in a pre-initialized graph.
     */
    @Test
    void scheduleSetter() throws IOException {
        // SetUp
        ReaderFiles.importLocalData("SRC/source/main/resources/ESINF/locais_big.csv");
        ReaderFiles.importDistanceData("SRC/source/main/resources/ESINF/distancias_big.csv","SRC/source/main/resources/ESINF/locais_big.csv");
        NetworkBuilder networkBuilder = NetworkBuilder.getInstance();
        MapGraph<Locality, Integer> graph = networkBuilder.getDistribution();
        HubDefiner hubDefiner = new HubDefiner();
        int numberOfHubs = 5;
        hubDefiner.defineHubs(graph, numberOfHubs);
        String[] schedules = ReaderFiles.importNewSchedules("SRC/source/main/resources/ESINF/schedulesHub.txt");

        // Act
        try {
            ScheduleSetter.ScheduleSetter(schedules, graph);
        }catch (IOException e){
            e.printStackTrace();
        }
        for (Locality locality : graph.vertices()) {
            if (locality.getName().equals("CT1")) {
                assertEquals(LocalTime.of(14, 0), locality.getSchedules().getOpening());
                assertEquals(LocalTime.of(17, 0), locality.getSchedules().getClosing());
            } else if (locality.getName().equals("CT214")) {
                assertEquals(LocalTime.of(11, 0), locality.getSchedules().getOpening());
                assertEquals(LocalTime.of(15, 30), locality.getSchedules().getClosing());
            }
        }
    }

    /**
     * Test method to verify the correctness of the {@code parseTime} method in the {@code ScheduleSetter} class.
     * It tests the conversion of time strings to LocalTime objects.
     */
    @Test
    void parseTime() {
        String time1 = "14:00";
        String time2 = "11:00";
        String time3 = "12:00";

        LocalTime result1 = ScheduleSetter.parseTime(time1);
        LocalTime result2 = ScheduleSetter.parseTime(time2);
        LocalTime result3 = ScheduleSetter.parseTime(time3);

        assertEquals(LocalTime.of(14, 0), result1);
        assertEquals(LocalTime.of(11, 0), result2);
        assertEquals(LocalTime.of(12, 0), result3);
    }
}