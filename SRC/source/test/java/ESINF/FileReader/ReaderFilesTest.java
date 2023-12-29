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
    void importNewSchedulesValidFile() {
        try {
            String[] result = ReaderFiles.importNewSchedules("SRC/source/main/resources/ESINF/schedulesHub.txt");

            assertNotNull(result);
            assertEquals(3,result.length);

            assertEquals("CT1,14:00,17:00", result[0]);
            assertEquals("CT214,11:00,15:30", result[1]);
            assertEquals("CT700,12:00,15:00", result[2]);

        } catch (IOException e) {
            fail("Unexpected error: " + e.getMessage());
        }
    }
    /**
     * Test method for importing schedules from a non-existent TXT file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    @Test
    void importNewSchedulesFromNonExistentFile(){
        assertThrows(IOException.class, () -> {
            ReaderFiles.importNewSchedules("nonexistentfile.txt");
        });
    }
    /**
     * Test method for importing schedules from a TXT file with invalid data.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    @Test
    void importNewSchedulesInvalidData() {
        assertThrows(IOException.class, () -> {
            ReaderFiles.importNewSchedules("SRC/source/main/resources/ESINF/schedulesHub_invalid.txt");
        });
    }
}
