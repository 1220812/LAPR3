package ESINF.FileReader;

import ESINF.Domain.Locality;
import ESINF.Domain.Schedule;
import ESINF.US01.NetworkBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

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
                Locality locality = new Locality(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]), false, new Schedule(LocalTime.of(9,0), LocalTime.of(14,0)));
                network.addLocality(locality);
                localities.add(locality);
            } else if (id <= 215) {
                Locality locality = new Locality(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]), false, new Schedule(LocalTime.of(11,0), LocalTime.of(16,0)));
                network.addLocality(locality);
                localities.add(locality);
            }else{
                Locality locality = new Locality(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]), false, new Schedule(LocalTime.of(12,0), LocalTime.of(17,0)));
                network.addLocality(locality);
                localities.add(locality);
            }
        }
        return localities;
    }
    /**
     * Finds a locality in a list by its name (ID).
     *
     * @param localities A list of localities to search through.
     * @param ID       The ID of the locality to find.
     * @return The locality with the specified name, or null if not found.
     */
    public static Locality findLocalityByID (List<Locality> localities, String ID){
        for (Locality locality : localities) {
            if(locality.getName().equals(ID)){
                return locality;
            }
        }
        return null;
    }
    /**
     * Imports new schedules from a file and associates them with respective localities in a map.
     *
     * @param fileName The name of the file containing schedule information.
     * @return A map where keys are localities and values are corresponding schedules.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static Map<Locality, Schedule> importNewSchedules (String fileName) throws IOException {
        Map<Locality, Schedule> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String currentLine;
        reader.readLine();
        String[] data;

        while ((currentLine = reader.readLine()) != null){
            data = currentLine.split(",");
            int[] open = extraction(data[1]);
            int[] close = extraction(data[2]);
            Schedule schedule = new Schedule(LocalTime.of(open[0],open[1]), LocalTime.of(close[0], close[1]));
            map.put(new Locality(data[0]), schedule);
        }
        return map;
    }
    /**
     * Extracts hour and minute values from a schedule string in "HH:MM" format.
     *
     * @param schedule The schedule string in "HH:MM" format.
     * @return An array containing hour and minute values.
     */
    private static int[] extraction(String schedule){
        String[] data = schedule.split(":");

        int hour = Integer.parseInt(data[0]);
        int min = Integer.parseInt(data[1]);

        return new int[]{hour, min};
    }
}

