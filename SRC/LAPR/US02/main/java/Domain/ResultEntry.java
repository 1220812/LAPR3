package Domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ResultEntry {
    private Date date;
    private String designation;
    private int duration;
    private String startTime;
    private String entTime;

    public ResultEntry(Date date, String designation, int duration, String startTime, String entTime) {
        this.date = date;
        this.designation = designation;
        this.duration = duration;
        this.startTime = startTime;
        this.entTime = entTime;
    }

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

    public String getEntTime() {
        return entTime;
    }


    @Override
    public String toString() {
        return String.format("%10s %10s %10d %10s %10s",new SimpleDateFormat("dd/MM/yyyy").format(date),designation,duration,startTime,entTime);
    }
}

