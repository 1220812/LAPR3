package FileReader;

import Domain.Hub;
import US01.NetworkBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFiles {
    /**
     * Imports route data from a CSV file and adds routes to the network.
     *
     * @param filePath The path to the CSV file containing route data.
     * @throws IOException If an error occurs while reading the file or parsing the data.
     */
    public static void importDistanceData (String filePath) throws IOException {
        NetworkBuilder network = NetworkBuilder.getInstance();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String currentLine;
        reader.readLine();
        String[] data;

        while ((currentLine = reader.readLine()) != null){
            data = currentLine.split(",");
            network.addRoute(new Hub(data[0]), new Hub(data[1]), Double.parseDouble(data[2]));
        }
    }
    /**
     * Imports hub data from a CSV file and adds hubs to the network.
     *
     * @param filePath The path to the CSV file containing hub data.
     * @throws IOException If an error occurs while reading the file or parsing the data.
     */
    public static void importLocalData (String filePath) throws IOException {
        NetworkBuilder network = NetworkBuilder.getInstance();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String currentLine;
        reader.readLine();
        String[] data;

        while ((currentLine = reader.readLine()) != null){
            data = currentLine.split(",");
            network.addHub(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]));
        }
    }
}

