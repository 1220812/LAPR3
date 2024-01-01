package ESINF.Domain;

import java.time.LocalTime;

public class PassageLocal {
    private LocalTime arrivalTime;
    private LocalTime leftTime;
    private boolean isHub;
    public PassageLocal( boolean isHub, LocalTime arrivalTime, LocalTime leftTime){
        this.isHub = isHub;
        this.arrivalTime = arrivalTime;
        this.leftTime = leftTime;
    }
    public PassageLocal(LocalTime arrivalTime){
        this.arrivalTime = arrivalTime;
    }
    /**
     * Gets
     */
    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalTime getLeftTime() {
        return leftTime;
    }


    /**
     * Sets
     */
    public void setHub(boolean hub) {
        isHub = hub;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setLeftTime(LocalTime leftTime) {
        this.leftTime = leftTime;
    }

    @Override
    public String toString() {
        return "PassageLocal : " +
                ", arrivalTime = " + arrivalTime +
                ", leftTime =" + leftTime +
                ", is a Hub? " + isHub;
    }
}
