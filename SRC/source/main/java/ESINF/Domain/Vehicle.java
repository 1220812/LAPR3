package ESINF.Domain;

import java.util.Objects;
/**
 * Represents a vehicle used for distribution of agricultural products.
 */
public class Vehicle {
    /**
     * The unique identifier of the vehicle.
     */
    String id;
    /**
     * The average speed of the vehicle in KM/H.
     */
    double averageSpeed;
    /**
     * The autonomy of the vehicle in KM.
     */

    double autonomy;
    /**
     * The time, in minutes, that takes to charge the vehicle
     */
    double chargeTime;
    /**
     * The time, in minutes, that takes to unload the products from the vehicles in the hubs
     */
    double unloadingTime;
    /**
     * Gets
     */
    public double getAutonomy() {
        return autonomy;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public String getId() {
        return id;
    }

    public double getChargeTime() {
        return chargeTime;
    }

    public double getUnloadingTime() {
        return unloadingTime;
    }

    /**
     * Sets
     */
    public void setAutonomy(double autonomy) {
        this.autonomy = autonomy;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setChargeTime(double chargeTime) {
        this.chargeTime = chargeTime;
    }

    public void setUnloadingTime(double unloadingTime) {
        this.unloadingTime = unloadingTime;
    }

    /**
     * Constructs a new vehicle instance with the specified identifier, average speed, and autonomy.
     *
     * @param id           The unique identifier of the vehicle.
     * @param averageSpeed The average speed of the vehicle in kilometers per hour.
     * @param autonomy     The autonomy of the vehicle in kilometers.
     */
    public Vehicle(String id, double averageSpeed, double autonomy){
        this.id = id;
        this.averageSpeed = averageSpeed;
        this.autonomy = autonomy;
    }
    /**
     * Constructs a new vehicle instance with the specified average speed and autonomy.
     *
     * @param averageSpeed The average speed of the vehicle in kilometers per hour.
     * @param autonomy     The autonomy of the vehicle in kilometers.
     */
    public Vehicle(double averageSpeed, double autonomy){
        this.autonomy = autonomy;
        this.averageSpeed = averageSpeed;
    }
    /**
     * Constructs a new vehicle instance with the specified average speed and autonomy.
     *
     * @param id The unique identifier of the vehicle.
     * @param averageSpeed The average speed of the vehicle in kilometers per hour.
     * @param autonomy     The autonomy of the vehicle in kilometers.
     * @param chargeTime   The time, in minutes, that takes to charge the vehicle
     * @param unloadingTime The time, in minutes, that takes to unload the products from the vehicles in the hubs
     */
    public Vehicle(String id, double averageSpeed, double autonomy, double chargeTime, double unloadingTime){
        this.id = id;
        this.averageSpeed = averageSpeed;
        this.autonomy = autonomy;
        this.chargeTime = chargeTime;
        this.unloadingTime = unloadingTime;
    }
    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare.
     * @return `true` if this object is the same as the obj argument; `false` otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(averageSpeed, vehicle.averageSpeed) == 0 && Double.compare(autonomy, vehicle.autonomy) == 0 && Double.compare(chargeTime, vehicle.chargeTime) == 0 && Double.compare(unloadingTime, vehicle.unloadingTime) == 0 && Objects.equals(id, vehicle.id);
    }
    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, averageSpeed, autonomy, chargeTime, unloadingTime);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", averageSpeed=" + averageSpeed +
                ", autonomy=" + autonomy +
                ", chargeTime=" + chargeTime +
                ", unloadingTime=" + unloadingTime +
                '}';
    }
}
