package LAPR.Interface.Readers;

import LAPR.Interface.Domain.DateHour;
import LAPR.Interface.Domain.Partition;
import LAPR.Interface.Domain.WateringPlanGenerator;
import LAPR.Interface.Domain.WateringData;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadInstructionsFromFile {
    /**
     * Reads watering instructions from a file and returns a list of WateringData objects.
     *
     * @param fileName The name of the file containing watering instructions.
     * @return A list of WateringData objects representing the watering instructions.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static List<WateringData> readInformation(String fileName) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            List<WateringData> wateringDataList = new ArrayList<>();

            boolean wateringTimeSet = setWateringTimesFromHeader(bufferedReader);

            String line;
            boolean validLine = false;

            while ((line = bufferedReader.readLine()) != null) {
                boolean currentLineValid = addWateringDataFromLine(line, wateringDataList);
                if (currentLineValid) {
                    validLine = true;
                }
            }
            if (wateringTimeSet && validLine) {
                return wateringDataList;
            }
            return new ArrayList<>();
        }
    }
    /**
     * Sets the watering times from the header of the file.
     *
     * @param bufferedReader The BufferedReader used to read the file.
     * @return True if watering times were successfully set, false otherwise.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    private static boolean setWateringTimesFromHeader (BufferedReader bufferedReader) throws IOException{
        boolean wateringTimesSet = false;
        String fistLine = bufferedReader.readLine();
        String[] allWateringTimes = fistLine.split(",");
        List<String> validWateringTimes = new ArrayList<>();

        for (String time : allWateringTimes) {
            time = time.trim();
            try {
                DateHour.getTimeFormat().parse(time);
                validWateringTimes.add(time);
                wateringTimesSet = true;
            }catch (ParseException e){
                System.out.println("Invalid watering time: " + time);
            }
        }
        if(wateringTimesSet){
            WateringData.setWateringTimes(validWateringTimes);
        }
        return wateringTimesSet;
    }
    /**
     * Adds watering data from a line in the file to the list of WateringData objects.
     *
     * @param line              The line containing watering data.
     * @param wateringDataList The list of WateringData objects.
     * @return True if the watering data was successfully added, false otherwise.
     */
    private static boolean addWateringDataFromLine(String line, List<WateringData> wateringDataList){
        if(line == null || line.trim().isEmpty()){
            return false;
        }
        if(line.endsWith(",")){
            line = line.substring(0, line.length() - 1);
        }
        String[] lineData = line.split(",");

        if(lineData.length != 3 && lineData.length != 5){
            printErrorMessage(line, "number of values");
            return false;
        }
        String parcel = lineData[0].trim();
        if(parcel.isEmpty()){
            printErrorMessage(line, "parcel");
            return false;
        }
        int duration = parseIntegerValue(lineData[1], "duration", line);
        if(duration <= 0){
            return false;
        }

        String type = lineData[2].trim();
        if(!isRegularityValid(type)){
            printErrorMessage(line, "regularity");
            return false;
        }

        if(lineData.length == 3){
            WateringData wateringData = new WateringData(parcel, duration, type);
            wateringDataList.add(wateringData);
            return true;
        }

        String mix = lineData[3].trim();
        if(mix.isEmpty()){
            printErrorMessage(line, "mix");
            return false;
        }

        int recurrence = parseIntegerValue(lineData[4], "recurrence", line);
        if(recurrence <= 0){
            return false;
        }

        WateringData wateringData = new WateringData(parcel, duration, type, mix, recurrence);
        wateringDataList.add(wateringData);
        return true;
    }
    /**
     * Parses an integer value from a string and handles errors.
     *
     * @param value     The string containing the integer value.
     * @param fieldName The name of the field being parsed.
     * @param line      The line from which the value is being parsed.
     * @return The parsed integer value if successful, or -1 if an error occurs.
     */
    private static int parseIntegerValue(String value, String fieldName, String line){
        if(value == null || value.trim().isEmpty()){
            printErrorMessage(line, fieldName);
            return -1;
        }
        try {
            int valueParsed = Integer.parseInt(value.trim());
            if(valueParsed <= 0){
                printErrorMessage(line, fieldName);
                return -1;
            }
            return valueParsed;
        }catch (NumberFormatException e){
            printErrorMessage(line, fieldName);
            return -1;
        }
    }
    /**
     * Checks if a watering regularity type is valid.
     *
     * @param type The watering regularity type string.
     * @return True if the type is valid, false otherwise.
     */
    private static boolean isRegularityValid(String type){
        if(type == null){
            return false;
        }
        return WateringData.RegularityType.fromString(type) != null;
    }
    /**
     * Prints an error message for invalid values in the input line.
     *
     * @param line    The line containing invalid values.
     * @param message The error message indicating the type of invalid value.
     */
    private static void printErrorMessage (String line, String message){
        System.out.println("Invalid " + message + " at line: " + line);
    }
}