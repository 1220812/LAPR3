package ESINF.Domain;

import java.util.Objects;
/**
 * Represents a pair of localities, typically used as a key in mappings.
 * Instances of this class are immutable.
 */

public class LocalityPair {
    /**
     * The first locality in the pair.
     */
    private Locality locality1;
    /**
     * The second locality in the pair.
     */
    private Locality locality2;
    /**
     * Constructs a new LocalityPair with the specified localities.
     *
     * @param locality1 The first locality.
     * @param locality2 The second locality.
     */
    public LocalityPair(Locality locality1, Locality locality2){
        this.locality1 = locality1;
        this.locality2 = locality2;
    }

    /**
     * Gets
     */
    public Locality getLocality1() {
        return locality1;
    }

    public Locality getLocality2() {
        return locality2;
    }

    /**
     * Sets
     */
    public void setLocality1(Locality locality1) {
        this.locality1 = locality1;
    }
    public void setLocality2(Locality locality2) {
        this.locality2 = locality2;
    }
    /**
     * Compares this LocalityPair with another object for equality.
     * Two LocalityPairs are considered equal if they have the same localities,
     * regardless of the order.
     *
     * @param o The object to compare with.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalityPair that = (LocalityPair) o;
        return Objects.equals(locality1, that.locality1) && Objects.equals(locality2, that.locality2);
    }
    /**
     * Generates a hash code for this LocalityPair.
     * The hash code is based on the hash codes of the localities,
     * and it is independent of the order of localities in the pair.
     *
     * @return The hash code for this LocalityPair.
     */
    @Override
    public int hashCode() {
        return Objects.hash(locality1, locality2);
    }
}
