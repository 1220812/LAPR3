package Structure;

import java.util.Objects;

/**
 * @param <V> Vertex value type
 * @param <E> Edge value type
 */
public class Edge<V, E> {
    final private V vOrig;        // vertex origin
    final private V vDest;        // vertex destination
    private E weight;        // Edge weight

    /**
     * Constructs an edge between the specified origin and destination vertices with the given weight.
     *
     * @param vOrig  The origin vertex.
     * @param vDest  The destination vertex.
     * @param weight The weight of the edge.
     * @throws RuntimeException if either vertex is null.
     */
    public Edge(V vOrig, V vDest, E weight) {
        if ((vOrig == null) || (vDest == null)) throw new RuntimeException("Edge vertices cannot be null!");
        this.vOrig = vOrig;
        this.vDest = vDest;
        this.weight = weight;
    }
    /**
     * Gets the origin vertex of the edge.
     *
     * @return The origin vertex.
     */
    public V getVOrig() {
        return vOrig;
    }
    /**
     * Gets the destination vertex of the edge.
     *
     * @return The destination vertex.
     */
    public V getVDest() {
        return vDest;
    }
    /**
     * Gets the weight of the edge.
     *
     * @return The weight of the edge.
     */
    public E getWeight() {
        return weight;
    }
    /**
     * Sets the weight of the edge.
     *
     * @param weight The new weight for the edge.
     */
    public void setWeight(E weight) {
        this.weight = weight;
    }
    /**
     * Returns a string representation of the edge, including its origin, destination, and weight.
     *
     * @return A string representation of the edge.
     */
    @Override
    public String toString() {
        return String.format("%s -> %s\nWeight: %s", vOrig, vDest, weight);
    }
    /**
     * Checks if the current edge is equal to another object.
     *
     * @param o The object to compare with.
     * @return True if the edges are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        @SuppressWarnings("unchecked") Edge<V, E> edge = (Edge<V, E>) o;
        return  vOrig.equals(edge.vOrig) &&
                vDest.equals(edge.vDest);
    }
    /**
     * Generates a hash code for the edge based on its origin and destination vertices.
     *
     * @return The hash code for the edge.
     */
    @Override
    public int hashCode() {
        return Objects.hash(vOrig, vDest);
    }
}