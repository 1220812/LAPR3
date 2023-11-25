package LAPR.US02.main.java.Domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SprinklingSystem {
    private List<Partition> partitions;

    public SprinklingSystem(List<Partition> partitions) {
        this.partitions = partitions;
    }

    /**
     * Generate a simulation list for a sprinkling system.
     *
     * @param days      the number of days to simulate
     * @param startTime the starting time of the simulation
     * @param endTime   the ending time of the simulation
     * @return a list of ResultEntry objects representing the simulation
     */
    public List<ResultEntry> generateSimulation(int days, String startTime, String endTime) {
        int dayCounter = 0;
        String time = startTime;
        List<ResultEntry> result = new ArrayList<>();
        for (int i = 0; i < days; i++) {
            for (Partition partition : this.partitions) {
                if (!partition.isDay(dayCounter)) {
                    continue;
                }
                int startHour = getHour(time);
                int startMinute = getMinute(time);

                // Check if it's time to stop for the day
                if (time.compareTo(endTime)<0){
                    break;
                }

                int endHour = startHour;
                int endMinute = startMinute + partition.getTime();
                if (endMinute >= 60) {
                    endMinute = endMinute % 60;
                    endHour++;
                }
                Calendar c = Calendar.getInstance();
                c.add(Calendar.DAY_OF_MONTH, dayCounter);
                result.add(new ResultEntry(c.getTime(), partition.getDesignation(), partition.getTime(), formattHour(startHour, startMinute), formattHour(endHour, endMinute)));
                time = formattHour(endHour,endMinute);
            }
            dayCounter++;
            time=startTime;
        }
        return result;
    }
    /**
     * Format the hour and minute as a string in "HH:mm" format.
     */
    private String formattHour(int startHour, int startMinute) {
        if (startMinute < 10) return startHour + ":0" + startMinute;
        return startHour + ":" + startMinute;
    }

    /**
     * Get the hour from a time string in "HH:mm" format.
     */
    public int getHour(String time) {
        return Integer.parseInt(time.split(":")[0]);
    }

    /**
     * Get the minute from a time string in "HH:mm" format.
     */
    public int getMinute(String time) {
        return Integer.parseInt(time.split(":")[1]);
    }


}