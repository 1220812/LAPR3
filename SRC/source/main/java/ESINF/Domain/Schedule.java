package ESINF.Domain;

import java.time.LocalTime;
/**
 * Enumeration representing different schedules with opening and closing times.
 */
public class Schedule {
    /**
     * The opening time in "HH:MM" format
     */
    private final LocalTime opening;
    /**
     * The closing time in "HH:MM" format
     */
    private final LocalTime closing;

    /**
     * Constructs a Schedule with specified opening and closing times.
     *
     * @param opening The opening time.
     * @param closing The closing time.
     */
    public Schedule(LocalTime opening, LocalTime closing){
        this.opening = opening;
        this.closing = closing;
    }

    /**
     * Gets
     */
    public LocalTime getClosing() {
        return closing;
    }

    public LocalTime getOpening() {
        return opening;
    }

    @Override
    public String toString() {
        return  opening +
                " - " + closing;
    }
}
