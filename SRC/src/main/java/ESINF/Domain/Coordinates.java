package ESINF.Domain;

import java.util.Objects;

public class Coordinates {

    private static final double R = 6371e3;
    /**
     * The latitude value of the coordinates.
     */
    private double latitude;
    /**
     * The longitude value of the coordinates.
     */
    private double longitude;
    /**
     * Constructs a new `Coordinates` instance with the specified latitude and longitude values.
     *
     * @param latitude The latitude value of the coordinates.
     * @param longitude The longitude value of the coordinates.
     */
    public Coordinates(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
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

    /**
     * Sets
     */

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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
        Coordinates that = (Coordinates) o;
        return Double.compare(latitude, that.latitude) == 0 && Double.compare(longitude, that.longitude) == 0;
    }
    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
    public double distance(double longitude1, double latitude1) {
        double phi1 = latitude * Math.PI / 180;
        double phi2 = latitude * Math.PI / 180;
        double deltaPhi = (latitude1 - latitude) * Math.PI / 180;
        double deltaLambda = (longitude1 - longitude) * Math.PI / 180;
        double a = Math.sin(deltaPhi / 2) * Math.sin(deltaPhi / 2) +
                Math.cos(phi1) * Math.cos(phi2) *
                        Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    @Override
    public String toString() {
        return String.format("(Latitude: %.2f; Longitude: %.2f)", latitude, longitude);
    }
}
