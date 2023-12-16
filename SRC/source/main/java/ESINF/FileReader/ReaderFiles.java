package ESINF.FileReader;

import ESINF.Domain.Locality;
import ESINF.Domain.Schedules;
import ESINF.US01.NetworkBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderFiles {
    /**
     * Imports route data from a CSV file and adds routes to the network.
     *
     * @param filePath The path to the CSV file containing route data.
     * @throws IOException If an error occurs while reading the file or parsing the data.
     */
    public static void importDistanceData (String filePath, String filePath2) throws IOException {
        NetworkBuilder network = NetworkBuilder.getInstance();

        List<Locality> localities = importLocalData(filePath2);

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String currentLine;
        reader.readLine();
        String[] data;

        while ((currentLine = reader.readLine()) != null){
            data = currentLine.split(",");
            Locality locality1 = findLocalityByID(localities, data[0]);
            Locality locality2 = findLocalityByID(localities, data[1]);
            network.addRoute(locality1, locality2, Integer.parseInt(data[2]));
        }
    }
    /**
     * Imports hub data from a CSV file and adds hubs to the network.
     *
     * @param filePath The path to the CSV file containing hub data.
     * @throws IOException If an error occurs while reading the file or parsing the data.
     */
    public static List<Locality> importLocalData (String filePath) throws IOException {
        NetworkBuilder network = NetworkBuilder.getInstance();
        List<Locality> localities = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String currentLine;
        reader.readLine();
        String[] data;

        while ((currentLine = reader.readLine()) != null){
            data = currentLine.split(",");
            int id = Integer.parseInt(data[0].substring(2));
            if(id <= 105){
                Locality locality = new Locality(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]), false, Schedules.SCHEDULE1);
                network.addLocality(locality);
                localities.add(locality);
            } else if (id <= 215) {
                Locality locality = new Locality(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]), false, Schedules.SCHEDULE2);
                network.addLocality(locality);
                localities.add(locality);
            }else{
                Locality locality = new Locality(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]), false, Schedules.SCHEDULE3);
                network.addLocality(locality);
                localities.add(locality);
            }
        }
        return localities;
    }
    public static Locality findLocalityByID (List<Locality> localities, String ID){
        for (Locality locality : localities) {
            if(locality.getName().equals(ID)){
                return locality;
            }
        }
        return null;
    }
}

