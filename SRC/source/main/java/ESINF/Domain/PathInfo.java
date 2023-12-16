package ESINF.Domain;

import java.util.HashMap;
import java.util.Map;

public class PathInfo {
    private double totalDistance;
    private double totalTime;
    private Map<LocalityPair, Integer> distancesBetweenLocalities;
    public PathInfo(double totalTime, double totalDistance, Map<LocalityPair, Integer> distancesBetweenLocalities){
        this.totalTime = totalTime;
        this.totalDistance = totalDistance;
        this.distancesBetweenLocalities = distancesBetweenLocalities;
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
}
