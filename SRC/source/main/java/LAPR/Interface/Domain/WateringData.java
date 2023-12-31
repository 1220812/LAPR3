package LAPR.Interface.Domain;

import java.time.LocalTime;
import java.util.*;

public class WateringData {
    private static List<WateringData> wateringInstructionsList;
    private String parcel;
    private int duration;
    private String regularity;
    private static List<String> wateringTimes;
    private static Date startDate;
    private String startHour;
    private String endHour;
    private static LinkedHashMap<String, List<WateringData>> wateringDataMap;
    private String mix;
    private int recurrence;
    /**
     * Constructs a WateringData instance with basic information such as parcel, duration, and regularity.
     *
     * @param parcel     The parcel identifier.
     * @param duration   The duration of watering in minutes.
     * @param regularity The regularity type (e.g., "T" for every day).
     */
    public WateringData(String parcel, int duration, String regularity){
        this.parcel = parcel;
        this.duration = duration;
        this.regularity = regularity;
    }
    /**
     * Constructs a WateringData instance with additional information such as mix and recurrence.
     *
     * @param parcel     The parcel identifier.
     * @param duration   The duration of watering in minutes.
     * @param regularity The regularity type (e.g., "T" for every day).
     * @param mix        The mix information.
     * @param recurrence The recurrence interval.
     */
    public WateringData(String parcel, int duration, String regularity, String mix, int recurrence){
        this.parcel = parcel;
        this.duration = duration;
        this.regularity = regularity;
        this.mix = mix;
        this.recurrence = recurrence;
    }
    /**
     * Constructs an empty WateringData instance.
     */
    public WateringData(){
    }
    /**
     * Constructs a WateringData instance with detailed information including start and end hours.
     *
     * @param parcel     The parcel identifier.
     * @param duration   The duration of watering in minutes.
     * @param regularity The regularity type (e.g., "T" for every day).
     * @param startHour  The start hour of watering.
     * @param endHour    The end hour of watering.
     * @param mix        The mix information.
     * @param recurrence The recurrence interval.
     */
    public WateringData(String parcel, int duration, String regularity, String startHour, String endHour, String mix, int recurrence){
        this.parcel = parcel;
        this.duration = duration;
        this.startHour = startHour;
        this.endHour = endHour;
        this.regularity = regularity;
        this.mix = mix;
        this.recurrence = recurrence;
    }

    /**
     * Sets
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public void setMix(String mix) {
        this.mix = mix;
    }

    public void setParcel(String parcel) {

    }

    public void setRecurrence(int recurrence) {
        this.recurrence = recurrence;
    }

    public void setRegularity(String regularity) {
        this.regularity = regularity;
    }

    public static void setStartDate(Date startDate) {
        WateringData.startDate = startDate;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public static void setWateringDataMap(LinkedHashMap<String, List<WateringData>> wateringDataMap) {
        WateringData.wateringDataMap = wateringDataMap;
    }

    public static void setWateringInstructionsList(List<WateringData> wateringInstructionsList) {
        WateringData.wateringInstructionsList = wateringInstructionsList;
    }

    public static void setWateringTimes(List<String> wateringTimes) {
        WateringData.wateringTimes = wateringTimes;
    }

    /**
     * Gets
     */
    public static Date getStartDate() {
        return startDate;
    }

    public int getDuration() {
        return duration;
    }

    public int getRecurrence() {
        return recurrence;
    }

    public static LinkedHashMap<String, List<WateringData>> getWateringDataMap() {
        return wateringDataMap;
    }

    public static List<String> getWateringTimes() {
        return wateringTimes;
    }

    public static List<WateringData> getWateringInstructionsList() {
        return wateringInstructionsList;
    }

    public String getEndHour() {
        return endHour;
    }

    public String getMix() {
        return mix;
    }

    public String getParcel() {
        return parcel;
    }

    public String getRegularity() {
        return regularity;
    }

    public String getStartHour() {
        return startHour;
    }
    /**
     * Enum representing different watering regularity types.
     */
    public enum RegularityType {
        EVERY_DAY("T"),
        ODD_DAYS("I"),
        EVEN_DAYS("P"),
        EVERY_THREE_DAYS("3");

        private final String regularity;

        RegularityType(String regularity){
            this.regularity = regularity;
        }
        /**
         * Converts a regularity type string to a RegularityType enum.
         *
         * @param regularity The regularity type string.
         * @return The corresponding RegularityType enum, or null if not found.
         */
        public static RegularityType fromString(String regularity){
            for (RegularityType type : RegularityType.values()) {
                if(type.regularity.equals(regularity)){
                    return type;
                }
            }
            return null;
        }
    }
}