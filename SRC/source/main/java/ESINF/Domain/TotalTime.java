package ESINF.Domain;

import java.util.Map;

public class TotalTime {
    private double vehicleTotalChargeTime;
    private double tripTime;
    private Map<String, Double> dischargeBasketsTime;
    public TotalTime (double vehicleTotalChargeTime, double tripTime, Map<String, Double> dischargeBasketsTime){
        this.vehicleTotalChargeTime = vehicleTotalChargeTime;
        this.tripTime = tripTime;
        this.dischargeBasketsTime = dischargeBasketsTime;
    }

    /**
     * Gets
     */

    public double getTripTime() {
        return tripTime;
    }

    public double getVehicleTotalChargeTime() {
        return vehicleTotalChargeTime;
    }

    public Map<String, Double> getDischargeBasketsTime() {
        return dischargeBasketsTime;
    }

    /**
     * Sets
     */
    public void setDischargeBasketsTime(Map<String, Double> dischargeBasketsTime) {
        this.dischargeBasketsTime = dischargeBasketsTime;
    }

    public void setVehicleTotalChargeTime(double vehicleTotalChargeTime) {
        this.vehicleTotalChargeTime = vehicleTotalChargeTime;
    }

    public void setTripTime(double tripTime) {
        this.tripTime = tripTime;
    }

    @Override
    public String toString() {
        return "TotalTime " +
                "vehicleTotalChargeTime = " + vehicleTotalChargeTime +
                ", tripTime = " + tripTime +
                ", dischargeBasketsTime = " + dischargeBasketsTime;
    }
}
