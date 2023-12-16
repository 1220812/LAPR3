package ESINF.Domain;

import java.time.LocalTime;
/**
 * Enumeration representing different schedules with opening and closing times.
 */
public enum Schedules {
    /**
     * Schedule 1 with opening time at 9:00 AM and closing time at 2:00 PM.
     */
    SCHEDULE1(LocalTime.of(9, 0), LocalTime.of(14,0)),
    /**
     * Schedule 2 with opening time at 11:00 AM and closing time at 4:00 PM.
     */
    SCHEDULE2(LocalTime.of(11,0), LocalTime.of(16,0)),
    /**
     * Schedule 3 with opening time at 12:00 PM and closing time at 5:00 PM.
     */
    SCHEDULE3(LocalTime.of(12,0), LocalTime.of(17,0));
    private final LocalTime opening;
    private final LocalTime closing;

    /**
     * Constructs a Schedule with specified opening and closing times.
     *
     * @param opening The opening time.
     * @param closing The closing time.
     */
    Schedules(LocalTime opening, LocalTime closing){
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
