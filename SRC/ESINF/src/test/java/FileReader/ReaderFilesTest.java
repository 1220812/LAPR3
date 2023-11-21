package FileReader;

import Domain.Hub;
import US01.NetworkBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
            ReaderFiles.importDistanceData("src/main/resources/distancias_small.csv");

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
            ReaderFiles.importDistanceData("src/main/resources/distancias_big.csv");

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
            ReaderFiles.importLocalData("src/main/resources/locais_small.csv");

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
            ReaderFiles.importLocalData("src/main/resources/locais_big.csv");

            networkBuilder = NetworkBuilder.getInstance();

            assertNotNull(networkBuilder);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Cleanup method to remove all hubs from the network after each test.
     */
    @AfterEach
    public void clear(){
        for (Hub hub: networkBuilder.getDistribution().vertices()) {
            networkBuilder.getDistribution().removeVertex(hub);
        }
    }
}
