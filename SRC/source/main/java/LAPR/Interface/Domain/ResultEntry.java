package LAPR.Interface.Domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ResultEntry {
    private Date date;
    private String designation;
    private int duration;
    private String startTime;
    private String endTime;
    private String mixDesignation;
    private int recurrenceFormule;

    public ResultEntry(Date date, String designation, int duration, String startTime, String endTime) {
        this.date = date;
        this.designation = designation;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public ResultEntry(Date date, String designation, int duration, String startTime, String endTime, String mixDesignation, int recurrenceFormule) {
        this.date = date;
        this.designation = designation;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.mixDesignation = mixDesignation;
        this.recurrenceFormule = recurrenceFormule;
    }

    /**
     * Gets
     */

    public Date getDate() {
        return date;
    }

    public String getDesignation() {
        return designation;
    }

    public int getDuration() {
        return duration;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getRecurrenceFormule() {
        return recurrenceFormule;
    }

    public String getMixDesignation() {
        return mixDesignation;
    }

    public String toString(){
        return String.format("%10s %10s %10d %10s %10s %10s %10d", new SimpleDateFormat("dd/MM/yyyy").format(date), designation, duration,startTime, endTime, mixDesignation, recurrenceFormule);
    }
}

