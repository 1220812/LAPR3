package ESINF.Domain;

import java.awt.*;
import java.time.LocalTime;
import java.util.*;
import java.util.List;

/**
 * Represents information about a path, including total time, total distance,
 * and distances between localities.
 */
public class PathInfo {
    private double totalDistance;
    private LinkedList<Locality> path;
    private List<Integer> chargements;
    private Map<Locality, List<LocalTime>> arrivalTimes;
    private boolean flag;
    private Locality origin;
    private Map<List<Locality>, String> info = new HashMap<>();
    private TotalTime totalPathTime;
    private double totalTime;
    private int numberOfVehiclesCharges;
    private Map<LocalityPair, Integer> distancesBetweenLocalities;

    public PathInfo(double totalDistance, LinkedList<Locality> path, ArrayList<Integer> chargements, boolean flag){
        this.totalDistance = totalDistance;
        this.path = path;
        this.chargements = chargements;
        this.flag = flag;
    }
    public PathInfo(double totalDistance, LinkedList<Locality> path, ArrayList<Integer> chargements, Map<Locality, List<LocalTime>> arrivalTimes, boolean flag){
        this.totalDistance = totalDistance;
        this.path = path;
        this.chargements = chargements;
        this.arrivalTimes = arrivalTimes;
        this.flag = flag;
    }

    public PathInfo(double totalDistance, double totalTime) {
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
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

    public Locality getOrigin() {
        return origin;
    }

    public TotalTime getTotalPathTime() {
        return totalPathTime;
    }

    public Map<List<Locality>, String> getInfo() {
        return info;
    }

    public LinkedList<Locality> getPath() {
        return path;
    }

    public List<Integer> getChargements() {
        return chargements;
    }

    public Map<Locality, List<LocalTime>> getArrivalTimes() {
        return arrivalTimes;
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

    public void setOrigin(Locality origin) {
        this.origin = origin;
    }
    public void setTotalPathTime(TotalTime totalPathTime) {
        this.totalPathTime = totalPathTime;
    }

    public void setInfo(Map<List<Locality>, String> info) {
        this.info = info;
    }

    public void setArrivalTimes(Map<Locality, List<LocalTime>> arrivalTimes) {
        this.arrivalTimes = arrivalTimes;
    }

    public void setChargements(List<Integer> chargements) {
        this.chargements = chargements;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setPath(LinkedList<Locality> path) {
        this.path = path;
    }
    public boolean isFlag(boolean flag){
        return flag;
    }

    @Override
    public String toString() {
        return "PathInfo{" +
                ", info=" + info +
                '}';
    }
}
