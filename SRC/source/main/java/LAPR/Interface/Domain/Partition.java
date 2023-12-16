package LAPR.Interface.Domain;

public class Partition {
    /**
     * The designation of the sector
     */
    private String designation;
    /**
     * Time, in minutes, that the sector must receive watering
     */
    private int time;
    /**
     * Recorrence formule that define the days that the sector must receive watering
     */
    private String regularity;
    /**
     * Mix of production factors to be used in the fertigation operation
     */

    private String mixDesignation;
    /**
     * The recorrence formule of the fertigation application
     */

    private int recurrenceFormule;

    /**
     * Constructs a new instance of Partition
     * @param designation The designation of the sector
     * @param time Time, in minutes, that the sector must receive watering
     * @param regularity Recorrence formule that define the days that the sector must receive watering
     */

    public Partition(String designation, int time, String regularity) {
        this.designation = designation;
        this.time = time;
        this.regularity = regularity;
    }

    /**
     * Constructs a new instance of Partition
     * @param designation The designation of the sector
     * @param time Time, in minutes, that the sector must receive watering
     * @param regularity Recorrence formule that define the days that the sector must receive watering
     * @param mixDesignation Mix of production factors to be used in the fertigation operation
     * @param recurrenceFormule The recorrence formule of the fertigation application
     */
    public Partition(String designation, int time, String regularity, String mixDesignation, int recurrenceFormule){
        this.designation = designation;
        this.time = time;
        this.regularity = regularity;
        this.mixDesignation = mixDesignation;
        this.recurrenceFormule = recurrenceFormule;
    }

    /**
     * Gets
     */

    public String getDesignation() {
        return designation;
    }

    public int getTime() {
        return time;
    }


    public String getRegularity() {
        return regularity;
    }


    public int getRecurrenceFormule() {
        return recurrenceFormule;
    }

    public String getMixDesignation() {
        return mixDesignation;
    }

    /**
     * Sets
     */

    public void setMixDesignation(String mixDesignation) {
        this.mixDesignation = mixDesignation;
    }

    public void setRecurrenceFormule(int recurrenceFormule) {
        this.recurrenceFormule = recurrenceFormule;
    }
    public void setRegularity(String regularity) {
        this.regularity = regularity;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    /**
     * Returns a string representation of the basic properties of the partition.
     *
     * The string includes the designation, time, and regularity of the partition.
     *
     * @return A string representation of the partition.
     */
    @Override
    public String toString() {
        return "Partition : " + "\n" +
                "designation = " + designation +
                ", time = " + time +
                ", regularity = " + regularity;
    }
    /**
     * Returns a string representation of the extended properties of the partition.
     *
     * The string includes the designation, time, regularity, mix designation, and recurrence formula.
     *
     * @return A string representation of the partition with additional information.
     */
    public String toString2(){
        return "Partition : " + "\n" +
                designation + ", time = " + time + ", regularity = " + regularity + ", mix designation : " + mixDesignation + ", recurrence formule : " + recurrenceFormule ;
    }
    /**
     * Checks if the partition is active on the specified day based on its regularity.
     * @param day The day to check for partition activity.
     * @return {@code true} if the partition is active on the given day, otherwise {@code false}.
     */
    public boolean isDay(int day) {
        if (regularity.equals("T")) return true;
        if (regularity.equals("P")) return day % 2 == 0;
        if (regularity.equals("I")) return day % 2 == 1;
        int div = Integer.parseInt(regularity);
        return day % div == 0;
    }
}