package Domain;

import java.util.*;

/**
 * Represents a vertex in a graph
 *
 * @param <V>
 * @param <E>
 */
public class MapVertex<V, E> {

    final private V element;                            // Vertex information
    final private Map<V, Edge<V, E>> outVerts;    // Adjacent vertices
    /**
     * Constructs a vertex with the specified element.
     *
     * @param vert The information associated with the vertex.
     * @throws RuntimeException if the vertex information is null.
     */
    public MapVertex(V vert) {
        if (vert == null) throw new RuntimeException("Vertice information cannot be null!");
        element = vert;
        outVerts = new LinkedHashMap<>();
    }
    /**
     * Gets the element associated with the vertex.
     *
     * @return The element associated with the vertex.
     */
    public V getElement() {
        return element;
    }
    /**
     * Adds an adjacent vertex along with the connecting edge.
     *
     * @param vAdj The adjacent vertex to be added.
     * @param edge The connecting edge to the adjacent vertex.
     */
    public void addAdjVert(V vAdj, Edge<V, E> edge) {
        outVerts.put(vAdj, edge);
    }
    /**
     * Removes an adjacent vertex.
     *
     * @param vAdj The adjacent vertex to be removed.
     */
    public void remAdjVert(V vAdj) {
        outVerts.remove(vAdj);
    }
    /**
     * Gets the edge connecting the vertex to the specified adjacent vertex.
     *
     * @param vAdj The adjacent vertex.
     * @return The connecting edge, or null if the vertices are not adjacent.
     */
    public Edge<V, E> getEdge(V vAdj) {
        return outVerts.get(vAdj);
    }
    /**
     * Gets the number of adjacent vertices.
     *
     * @return The number of adjacent vertices.
     */
    public int numAdjVerts() {
        return outVerts.size();
    }
    /**
     * Gets a collection of all adjacent vertices.
     *
     * @return A collection of all adjacent vertices.
     */
    public Collection<V> getAllAdjVerts() {
        return new ArrayList<>(outVerts.keySet());
    }

    /**
     * Gets a collection of all outgoing edges.
     *
     * @return A collection of all outgoing edges.
     */
    public Collection<Edge<V, E>> getAllOutEdges() {
        return new ArrayList<>(outVerts.values());
    }
    /**
     * Returns a string representation of the vertex, including its element
     * and the information about its outgoing edges.
     *
     * @return A string representation of the vertex.
     */
    @Override
    public String toString() {
        String st = element + ": \n";
        if (!outVerts.isEmpty())
            for (V vert : outVerts.keySet())
                st += outVerts.get(vert);

        return st;
    }
}