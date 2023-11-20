package Domain;

import java.util.Objects;

public class Coordinates {
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
}
