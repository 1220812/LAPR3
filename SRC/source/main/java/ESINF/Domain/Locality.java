package ESINF.Domain;

import java.util.Objects;

/**
 * Represents a locality
 */
public class Locality {

    /**
     * The unique identifier of the hub.
     */
    private String name;
    /**
     * The geographical longitude of the hub.
     */
    private double longitude;
    /**
     * The geographical latitude of the hub.
     */
    private double latitude;
    /**
     * Flag that defines if a given locality is a Hub or not
     */
    private boolean isHub = false;
    public Schedule schedule;
    /**
     * Constructs a new `Hub` instance with the specified hubId and coordinates.
     *
     * @param name The unique identifier of the hub.
     * @param latitude The geographical latitude of the hub.
     * @param longitude The geographical longitude of the hub.
     */
    public Locality(String name, double latitude, double longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    /**
     * Constructs a new `Hub` instance with the specified hubId.
     *
     * @param name The unique identifier of the hub.
     */
    public Locality(String name){
        this.name = name;
    }

    /**
     * Constructs a new `Hub` instance with the specified hubId, coordinates and the flag that defines if the locality is a hub
     *
     * @param name The unique identifier of the hub.
     * @param latitude The geographical latitude of the hub.
     * @param longitude The geographical longitude of the hub.
     * @param isHub Flag that defines if a given locality is a Hub or not
     */
    public Locality(String name, double latitude, double longitude, boolean isHub, Schedule schedule){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isHub = isHub;
        this.schedule = schedule;
    }

    /**
     * Gets
     */
    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }
    public Boolean getHub(){
        return isHub;
    }

    public Schedule getSchedules() {
        return schedule;
    }

    /**
     * Sets
     */

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setHub(boolean hub) {
        isHub = hub;
    }

    public void setSchedules(Schedule schedules) {
        this.schedule = schedules;
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
        Locality locality = (Locality) o;
        return Objects.equals(name, locality.name)
                && Objects.equals(latitude, locality.latitude) &&
                Objects.equals(longitude, locality.longitude);
    }
    /**
     * Calculates the distance between this locality and another locality.
     *
     * @param otherLocality The other locality to calculate the distance to.
     * @return The distance between this locality and the other locality.
     */
    public double distanceTo(Locality otherLocality) {
        Coordinates thisCoordinates = new Coordinates(this.getLongitude(), this.getLatitude());
        return thisCoordinates.distance(otherLocality.getLongitude(), otherLocality.getLatitude()) ;
    }
    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, latitude, longitude);
    }

    @Override
    public String toString() {
        return "Locality : " +
                "name = " + name +
                ", longitude = " + longitude +
                ", latitude = " + latitude +
                ", is a Hub = " + isHub +
                ", schedules = " + schedule;
    }
}

