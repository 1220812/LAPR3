package ESINF.Domain;

import java.util.Objects;


/**
 * The type Hub.
 */
public class Hub {
    private static final int R = 6371;

    /**
     * The unique identifier of the hub.
     */
    private String hubId;
    /**
     * The geographical coordinates of the hub.
     */
    private Coordinates coordinates;
    /**
     * The geographical longitude of the hub.
     */
    private double longitude;
    /**
     * The geographical latitude of the hub.
     */
    private double latitude;

    /**
     * Constructs a new `Hub` instance with the specified hubId and coordinates.
     *
     * @param hubId       The unique identifier of the hub.
     * @param coordinates The geographical coordinates of the hub.
     */
    public Hub(String hubId, Coordinates coordinates){
        this.hubId = hubId;
        this.coordinates = coordinates;
    }

    /**
     * Constructs a new `Hub` instance with the specified hubId and coordinates.
     *
     * @param hubId     The unique identifier of the hub.
     * @param latitude  The geographical latitude of the hub.
     * @param longitude The geographical longitude of the hub.
     */
    public Hub(String hubId, double latitude, double longitude){
        this.hubId = hubId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Constructs a new `Hub` instance with the specified hubId.
     *
     * @param hubId The unique identifier of the hub.
     */
    public Hub(String hubId){
        this.hubId = hubId;
    }

    /**
     * Gets
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Gets hub id.
     *
     * @return the hub id
     */
    public String getHubId() {
        return hubId;
    }

    /**
     * Sets
     *
     * @param coordinates the coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Sets longitude.
     *
     * @param longitude the longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Sets latitude.
     *
     * @param latitude the latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Sets hub id.
     *
     * @param hubId the hub id
     */
    public void setHubId(String hubId) {
        this.hubId = hubId;
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
        Hub hub = (Hub) o;
        return Objects.equals(hubId, hub.hubId) && Objects.equals(coordinates, hub.coordinates);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @param otherHub the other hub
     * @return A hash code value for this object.
     */
    public double distanceTo(Hub otherHub) {
        Coordinates thisCoordinates = new Coordinates(this.getLongitude(), this.getLatitude());
        return thisCoordinates.distance(otherHub.getLongitude(), otherHub.getLatitude()) ;
    }
    @Override
    public int hashCode() {
        return Objects.hash(hubId, coordinates);
    }
    @Override
    public String toString() {
        return String.format("Hub in Location '%s', Coordenadas = %s", hubId, coordinates);
    }


}

