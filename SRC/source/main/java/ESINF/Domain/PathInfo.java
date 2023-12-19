package ESINF.Domain;

import java.time.LocalTime;
import java.util.Map;
/**
 * Represents information about a path, including total time, total distance,
 * and distances between localities.
 */
public class PathInfo {
    private double totalDistance;
    private double totalTime;
    private int numberOfVehiclesCharges;
    private Map<LocalityPair, Integer> distancesBetweenLocalities;
    /**
     * Constructs a new PathInfo instance with the specified total time,
     * total distance, and distances between localities.
     *
     * @param totalTime                 The total time of the path.
     * @param totalDistance             The total distance of the path.
     * @param distancesBetweenLocalities Distances between pairs of localities.
     */
    public PathInfo(double totalTime, double totalDistance, Map<LocalityPair, Integer> distancesBetweenLocalities){
        this.totalTime = totalTime;
        this.totalDistance = totalDistance;
        this.distancesBetweenLocalities = distancesBetweenLocalities;
    }
    public PathInfo(double totalTime, double totalDistance, int numberOfVehiclesCharges){
        this.totalTime = totalTime;
        this.totalDistance = totalDistance;
        this.numberOfVehiclesCharges = numberOfVehiclesCharges;
    }

    /**
     * Gets
     */

    public double getTotalTime() {
        return totalTime;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public Map<LocalityPair, Integer> getDistancesBetweenLocalities() {
        return distancesBetweenLocalities;
    }

    public int getNumberOfVehiclesCharges() {
        return numberOfVehiclesCharges;
    }

    /**
     * Sets
     */
    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setDistancesBetweenLocalities(Map<LocalityPair, Integer> distancesBetweenLocalities) {
        this.distancesBetweenLocalities = distancesBetweenLocalities;
    }

    public void setNumberOfVehiclesCharges(int numberOfVehiclesCharges) {
        this.numberOfVehiclesCharges = numberOfVehiclesCharges;
    }
}
