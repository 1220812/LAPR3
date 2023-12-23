package ESINF.FileReader;

import ESINF.Domain.Locality;
import ESINF.Domain.Schedule;
import ESINF.US01.NetworkBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReaderFilesTest {
    NetworkBuilder networkBuilder;

    /**
     * Test method for importing distance data from a small CSV file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    @Test
    void importDistanceSmallData() {
        try {
            ReaderFiles.importDistanceData("SRC/source/main/resources/ESINF/distancias_small.csv", "SRC/source/main/resources/ESINF/locais_big.csv");

            networkBuilder = NetworkBuilder.getInstance();

            assertNotNull(networkBuilder);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Test method for importing distance data from a large CSV file.
     * @throws IOException If an I/O error occurs while reading the file.
     */

    @Test
    void importDistanceBigData() {
        try {
            ReaderFiles.importDistanceData("SRC/source/main/resources/ESINF/distancias_big.csv", "SRC/source/main/resources/ESINF/locais_big.csv");

            networkBuilder = NetworkBuilder.getInstance();

            assertNotNull(networkBuilder);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Test method for importing local data from a small CSV file.
     * @throws IOException If an I/O error occurs while reading the file.
     */

    @Test
    void importLocalSmallData() {
        try {
            ReaderFiles.importLocalData("SRC/source/main/resources/ESINF/locais_small.csv");

            networkBuilder = NetworkBuilder.getInstance();

            assertNotNull(networkBuilder);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Test method for importing local data from a large CSV file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    @Test
    void importLocalBigData() {
        try {
            ReaderFiles.importLocalData("SRC/source/main/resources/ESINF/locais_big.csv");

            networkBuilder = NetworkBuilder.getInstance();

            assertNotNull(networkBuilder);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Test method for importing data from a TXT file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    @Test
    void importNewSchedulesTest() {
        try {
            Map<Locality, Schedule> result = ReaderFiles.importNewSchedules("SRC/source/main/resources/ESINF/schedulesHub.txt");

            assertNotNull(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
