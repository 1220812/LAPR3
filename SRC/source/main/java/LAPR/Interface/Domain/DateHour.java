package LAPR.Interface.Domain;

import LAPR.Interface.UI.Console.Utils.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Utility class for handling date and time operations in the watering plan application.
 */
public class DateHour {
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Gets the date format used by the class.
     *
     * @return The date format.
     */
    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    private final static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    /**
     * Gets the date and time format used by the class.
     *
     * @return The date and time format.
     */
    public static SimpleDateFormat getDateTimeFormat() {
        return dateTimeFormat;
    }

    private final static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    private final static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    /**
     * Gets the time formatter used by the class.
     *
     * @return The time formatter.
     */
    public static DateTimeFormatter getTimeFormatter() {
        return timeFormatter;
    }
    /**
     * Gets the time format used by the class.
     *
     * @return The time format.
     */
    public static SimpleDateFormat getTimeFormat() {
        return timeFormat;
    }
    /**
     * Asks the user to input a date.
     *
     * @return A Date object representing the user-input date.
     */
    public Date askDate() {
        while (true) {
            String dateInput = Utils.readLineFromConsole("Insert date (format: dd/MM/yyyy):");
            Date date = parseDate(dateInput);
            if (date != null) {
                return date;
            }
            System.out.println("Invalid date");
        }
    }
    /**
     * Parses a date string into a Date object using the class's date format.
     *
     * @param dateInput The date string to be parsed (format: dd/MM/yyyy).
     * @return A Date object representing the parsed date, or null if parsing fails.
     */
    private Date parseDate(String dateInput) {
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(dateInput);
        } catch (ParseException e) {
            return null;
        }
    }
    /**
     * Asks the user to input a date and returns the formatted date string.
     *
     * @return A formatted date string based on the user-input date.
     */
    public String askDateToCheck() {
        Date dateToCheck = askDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateToCheck);
        return dateFormat.format(dateToCheck);
    }
    /**
     * Asks the user to input a time in HH:mm format.
     *
     * @return A string representing the user-input time.
     */
    public String askHourToCheck() {
        String hourToCheck;

        while (true) {
            hourToCheck = Utils.readLineFromConsole("Please enter the time (hh:mm):");
            if (isValidTimeFormat(hourToCheck)) {
                break;
            } else {
                System.out.println("Invalid time format. Please enter the time in hh:mm format!");
            }
        }
        return hourToCheck;
    }
    /**
     * Checks if a given string has a valid time format (HH:mm).
     *
     * @param time The string representing the time to be validated.
     * @return True if the time has a valid format, false otherwise.
     */
    public static boolean isValidTimeFormat(String time) {
        Pattern pattern = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }
    /**
     * Pads a time string to ensure two digits for hours.
     *
     * @param time The time string to be padded.
     * @return The padded time string.
     */
    public static String padTime(String time) {
        String[] parts = time.split(":");
        if (parts[0].length() == 1) {
            parts[0] = "0" + parts[0];
        }
        return parts[0] + ":" + parts[1];
    }
    /**
     * Prompts the user to choose whether to set a date and returns the user's response.
     *
     * @param message The message indicating what the user is setting (e.g., date or time).
     * @return The user's response ("yes" or "no").
     */
    public String promptForDateSettingChoice(String message) {
        String userResponse;
        do {
            userResponse = Utils.readLineFromConsole("Would you like to set the " + message + "? If not, the current date will be used.");
        } while (!isValidUserResponse(userResponse));
        return userResponse;
    }
    /**
     * Checks if the user response is valid (either "yes" or "no").
     *
     * @param userResponse The user's response to be validated.
     * @return True if the response is valid, false otherwise.
     */
    private boolean isValidUserResponse(String userResponse) {
        return "yes".equalsIgnoreCase(userResponse) || "no".equalsIgnoreCase(userResponse) ||
                "y".equalsIgnoreCase(userResponse) || "n".equalsIgnoreCase(userResponse);
    }
    /**
     * Converts a double value representing total time in minutes to a formatted time string.
     *
     * @param totalTime The total time in minutes.
     * @return A formatted time string.
     */
    public static String roundHours(double totalTime) {
        int totalMinutes = (int) Math.round(totalTime * 60);

        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        int seconds = (int) ((totalTime * 3600) % 60);

        if (hours < 1) {
            return String.format("%02dm %02ds", minutes, seconds);
        }
        return String.format("%02dh %02dm %02ds", hours, minutes, seconds);
    }
    /**
     * Converts a double value representing time in minutes to a formatted time string (HH:mm).
     *
     * @param timeInMinutes The time in minutes.
     * @return A formatted time string.
     */
    public static String convertDoubleToTime(double timeInMinutes) {
        int totalMinutes = (int) timeInMinutes % 1440;
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        LocalTime localTime = LocalTime.of(hours, minutes);
        return localTime.format(timeFormatter);
    }
    /**
     * Asks the user to input a time in HH:mm format.
     *
     * @return A LocalTime object representing the user-input time.
     */
    public LocalTime askTime() {
        while (true) {
            String timeInput = Utils.readLineFromConsole("Insert time (HH:mm): ");
            if (isValidTimeFormat(timeInput)) {
                try {
                    return LocalTime.parse(timeInput, timeFormatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid time format. Please ensure your input is HH:mm.");
                }
            } else {
                System.out.println("Invalid time format. Please enter in HH:mm format.");
            }
        }
    }
}
