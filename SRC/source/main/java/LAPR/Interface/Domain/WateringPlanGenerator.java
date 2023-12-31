package LAPR.Interface.Domain;

import java.util.*;

/**
 * Class responsible for generating a watering plan based on provided data.
 */
public class WateringPlanGenerator {
    /**
     * Generates a watering plan for a specified number of days.
     *
     * @param wateringDataList The list of watering data to be considered for the plan.
     * @param plannedDays      The number of days for which the watering plan needs to be generated.
     * @return A LinkedHashMap where keys are formatted dates, and values are lists of watering data for each day.
     */
    public LinkedHashMap<String, List<WateringData>> planGenerator(List<WateringData> wateringDataList, int plannedDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(WateringData.getStartDate());

        LinkedHashMap<String, List<WateringData>> wateringPlanMap = new LinkedHashMap<>();
        WateringData wateringData = new WateringData();
        List<String> wateringTimes = wateringData.getWateringTimes();

        for (int i = 1; i < plannedDays; i++) {
            String formattedDate = getCurrentFormattedDate(calendar);
            List<WateringData> dailyWateringDataList = generateDailyWateringDataList(wateringDataList, wateringTimes, calendar, i);
            wateringPlanMap.put(formattedDate, dailyWateringDataList);

            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return wateringPlanMap;
    }

    /**
     * Formats the current date from the provided Calendar instance.
     *
     * @param calendar The Calendar instance representing the current date.
     * @return A formatted date string.
     */
    private String getCurrentFormattedDate(Calendar calendar) {
        Date currentDate = calendar.getTime();
        return DateHour.getDateFormat().format(currentDate);
    }

    /**
     * Generates a list of watering data for a specific day based on the provided parameters.
     *
     * @param wateringDataList The list of watering data to be considered.
     * @param wateringTimes    The list of watering times to be considered.
     * @param calendar         The Calendar instance representing the current date.
     * @param planDay          The day for which the watering plan is being generated.
     * @return A list of watering data for the specified day.
     */
    private List<WateringData> generateDailyWateringDataList(List<WateringData> wateringDataList, List<String> wateringTimes, Calendar calendar, int planDay) {
        List<WateringData> dailyWateringDataList = new ArrayList<>();

        for (String waterTime : wateringTimes) {
            Calendar currentTime = initCurrentTime(waterTime);

            for (WateringData data : wateringDataList) {
                WateringData.RegularityType type = WateringData.RegularityType.fromString(data.getRegularity());
                assert type != null;

                if (includesParcel(type, calendar.get(Calendar.DAY_OF_MONTH))) {
                    WateringData newData;

                    if (data.getRecurrence() == 0 || (data.getRecurrence() > 0 && (planDay - 1) % data.getRecurrence() == 0)) {
                        newData = createNewWateringData(currentTime, data);
                    } else {
                        newData = createNewWateringDataWithoutMix(currentTime, data);
                    }
                    dailyWateringDataList.add(newData);
                }
            }
        }
        return dailyWateringDataList;
    }
    /**
     * Creates a new instance of WateringData without mixing.
     *
     * @param currentTime The Calendar instance representing the current time.
     * @param data         The original WateringData instance.
     * @return A new WateringData instance without mixing.
     */
    private WateringData createNewWateringDataWithoutMix(Calendar currentTime, WateringData data) {
        String begginingHour = DateHour.getTimeFormat().format(currentTime.getTime());
        currentTime.add(Calendar.MINUTE, data.getDuration());
        String endHour = DateHour.getTimeFormat().format(currentTime.getTime());
        return new WateringData(data.getParcel(), data.getDuration(), data.getRegularity(), begginingHour, endHour, null, data.getRecurrence());
    }
    /**
     * Initializes the current time based on the provided time string.
     *
     * @param time The time string in "HH:mm" format.
     * @return A Calendar instance representing the initialized current time.
     */
    private Calendar initCurrentTime(String time) {
        Calendar currentTime = Calendar.getInstance();

        currentTime.setTime(WateringData.getStartDate());

        currentTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time.split(":")[0]));
        currentTime.set(Calendar.MINUTE, Integer.parseInt(time.split(":")[1]));
        return currentTime;
    }
    /**
     * Creates a new instance of WateringData.
     *
     * @param currentTime The Calendar instance representing the current time.
     * @param data         The original WateringData instance.
     * @return A new WateringData instance.
     */
    private WateringData createNewWateringData(Calendar currentTime, WateringData data) {
        String begginingHour = DateHour.getTimeFormat().format(currentTime.getTime());
        currentTime.add(Calendar.MINUTE, data.getDuration());

        String endHour = DateHour.getTimeFormat().format(currentTime.getTime());

        return new WateringData(data.getParcel(), data.getDuration(), data.getRegularity(), begginingHour, endHour, data.getMix(), data.getRecurrence());
    }
    /**
     * Checks if a specific day is included based on the watering regularity type.
     *
     * @param type The watering regularity type.
     * @param day  The day to be checked.
     * @return True if the day is included, false otherwise.
     */
    private boolean includesParcel(WateringData.RegularityType type, int day) {
        return switch (type) {
            case EVERY_DAY -> true;
            case ODD_DAYS -> day % 2 != 0;
            case EVEN_DAYS -> day % 2 == 0;
            case EVERY_THREE_DAYS -> day % 3 == 0;
        };
    }

}

