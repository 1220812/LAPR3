package ESINF.FileReader;

import ESINF.Domain.Locality;
import ESINF.US01.NetworkBuilder;
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
    /*
    @Test
    void importDistanceSmallData() {
        try {
            ReaderFiles.importDistanceData("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\src\\main\\resources\\ESINF\\distancias_small.csv");

            networkBuilder = NetworkBuilder.getInstance();

            assertNotNull(networkBuilder);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
*/
    /**
     * Test method for importing distance data from a large CSV file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    /*
    @Test
    void importDistanceBigData() {
        try {
            ReaderFiles.importDistanceData("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\src\\main\\resources\\ESINF\\distancias_big.csv");

            networkBuilder = NetworkBuilder.getInstance();

            assertNotNull(networkBuilder);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
*/
    /**
     * Test method for importing local data from a small CSV file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    /*
    @Test
    void importLocalSmallData() {
        try {
            ReaderFiles.importLocalData("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\src\\main\\resources\\ESINF\\locais_small.csv");

            networkBuilder = NetworkBuilder.getInstance();

            assertNotNull(networkBuilder);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
*/
    /**
     * Test method for importing local data from a large CSV file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    /*
    @Test
    void importLocalBigData() {
        try {
            ReaderFiles.importLocalData("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\src\\main\\resources\\ESINF\\locais_big.csv");

            networkBuilder = NetworkBuilder.getInstance();

            assertNotNull(networkBuilder);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
*/
    /**
     * Cleanup method to remove all hubs from the network after each test.
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
