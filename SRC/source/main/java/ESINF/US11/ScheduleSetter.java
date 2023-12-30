package ESINF.US11;

import ESINF.Domain.Locality;
import ESINF.Domain.Schedule;
import ESINF.Structure.MapGraph;

import java.io.IOException;
import java.time.LocalTime;

/**
 * The ScheduleSetter class is responsible for setting schedules for localities in a graph.
 * It reads schedule data from an array of strings and updates the corresponding localities
 * in a given MapGraph.
 **/
public class ScheduleSetter {
    /**
     * Sets schedules for localities in the provided MapGraph based on the input data.
     * @param data data from the file
     * @param graph the graph with all the localities
     * @throws IOException If there is an issue reading the input data.
     */
    public static void ScheduleSetter(String[] data, MapGraph<Locality, Integer> graph) throws IOException {
        for (String line : data) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String id = parts[0].trim();
                String openingHour = parts[1].trim();
                String closingHour = parts[2].trim();

                boolean localityFound = false;

                for (Locality locality : graph.vertices()) {
                    if (locality.getName().equals(id)) {
                        LocalTime openingTime = parseTime(openingHour);
                        LocalTime closingTime = parseTime(closingHour);

                        Schedule schedule = new Schedule(openingTime, closingTime);
                        locality.setSchedules(schedule);
                        localityFound = true;
                        System.out.println("The new schedule was successfully set for the locality: " + id);
                    }
                }
                if (!localityFound) {
                    System.out.println("The locality with ID: " + id + " isn't a hub");
                }
            }
        }
    }

    /**
     * Parses a time string in the format "HH:mm" into a LocalTime object.
     * @param time String in the "HH:mm" format
     * @return the transformed the string into a LocalTime object
     */
    public static LocalTime parseTime(String time) {
        String[] timeParts = time.split(":");
        int hour = Integer.parseInt(timeParts[0].trim());
        int minute = Integer.parseInt(timeParts[1].trim());
        return LocalTime.of(hour, minute);
    }
}