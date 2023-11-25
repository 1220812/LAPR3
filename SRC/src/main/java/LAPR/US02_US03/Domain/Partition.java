package LAPR.US02_US03.Domain;

public class Partition {
    private String designation;
    private int time;
    private String regularity;


    public Partition(String designation, int time, String regularity) {
        this.designation = designation;
        this.time = time;
        this.regularity = regularity;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getRegularity() {
        return regularity;
    }

    public void setRegularity(String regularity) {
        this.regularity = regularity;
    }

    @Override
    public String toString() {
        return "Partition{" +
                "designation='" + designation + '\'' +
                ", time=" + time +
                ", regularity='" + regularity + '\'' +
                '}';
    }

    public boolean isDay(int day) {
        if (regularity.equals("T")) return true;
        if (regularity.equals("P")) return day % 2 == 0;
        if (regularity.equals("I")) return day % 2 == 1;
        int div = Integer.parseInt(regularity);
        return day % div == 0;
    }
}