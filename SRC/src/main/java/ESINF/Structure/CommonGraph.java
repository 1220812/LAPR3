package ESINF.Structure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class CommonGraph <V,E> implements Graph<V,E> {
    protected int numVerts;
    protected int numEdges;
    protected final boolean isDirected;
    protected ArrayList<V> vertices;       // Used to maintain a numeric key to each vertex
    /**
     * Constructs a CommonGraph with the specified directed flag.
     *
     * @param directed Indicates if the graph is directed.
     */
    public CommonGraph(boolean directed) {
        numVerts = 0;
        numEdges = 0;
        isDirected = directed;
        vertices = new ArrayList<>();
    }
    /**
     * Checks if the graph is directed.
     *
     * @return True if the graph is directed, false otherwise.
     */
    @Override
    public boolean isDirected() {
        return isDirected;
    }
    /**
     * Gets the number of vertices in the graph.
     *
     * @return The number of vertices.
     */
    @Override
    public int numVertices() {
        return numVerts;
    }
    /**
     * Gets a list of all vertices in the graph.
     *
     * @return A list of vertices.
     */
    @Override
    public ArrayList<V> vertices() {
        return new ArrayList<>(vertices);
    }
    /**
     * Checks if a vertex is valid (exists in the graph).
     *
     * @param vert The vertex to check.
     * @return True if the vertex is valid, false otherwise.
     */
    @Override
    public boolean validVertex(V vert) { return vertices.contains(vert);   }
    /**
     * Gets the numeric key of a vertex.
     *
     * @param vert The vertex.
     * @return The numeric key of the vertex.
     */
    @Override
    public int key(V vert) {
        return vertices.indexOf(vert);
    }
    /**
     * Gets the vertex with the specified numeric key.
     *
     * @param key The numeric key.
     * @return The vertex with the specified key.
     */
    @Override
    public V vertex(int key) {
        if ((key < 0) || (key>=numVerts)) return null;
        return vertices.get(key);
    }
    /**
     * Finds a vertex based on a predicate.
     *
     * @param p The predicate to test against vertices.
     * @return The first vertex satisfying the predicate, or null if none is found.
     */
    @Override
    public V vertex(Predicate<V> p) {
        for (V v : vertices) {
            if (p.test(v)) return v;
        }
        return null;
    }
    /**
     * Gets the number of edges in the graph.
     *
     * @return The number of edges.
     */
    @Override
    public int numEdges() {
        return numEdges;
    }

    /** Copy graph from to graph to
     *
     * @param from graph from which to copy
     * @param to graph for which to copy
     */
    protected void copy(Graph <V,E> from, Graph <V,E> to) {
        //insert all vertices
        for (V v : from.vertices()) {
            to.addVertex(v);
        }

        //insert all edges
        for (Edge<V, E> e : from.edges()) {
            to.addEdge(e.getVOrig(), e.getVDest(), e.getWeight());
        }
    }

    /**
     * Checks if the current graph is equal to another object.
     *
     * @param otherObj The object to compare with.
     * @return True if the graphs are equal, false otherwise.
     */
    @Override
    public boolean equals(Object otherObj) {

        if (this == otherObj)
            return true;

        if (!(otherObj instanceof Graph<?, ?>))
            return false;

        @SuppressWarnings("unchecked") Graph<V, E> otherGraph = (Graph<V, E>) otherObj;

        if (numVerts != otherGraph.numVertices() || numEdges != otherGraph.numEdges() || isDirected() != otherGraph.isDirected())
            return false;

        // graph must have same vertices
        Collection<V> tvc = this.vertices();
        tvc.removeAll(otherGraph.vertices());
        if (tvc.size() > 0 ) return false;

        // graph must have same edges
        Collection<Edge<V, E>> tec = this.edges();
        tec.removeAll(otherGraph.edges());
        return (tec.size() == 0);
    }
    /**
     * Creates a clone of the graph.
     *
     * @return A clone of the graph.
     */

    public abstract Graph<V, E> clone();
    /**
     * Generates a hash code for the graph.
     *
     * @return The hash code for the graph.
     */
    @Override
    public int hashCode() {
        return Objects.hash(numVerts, numEdges, isDirected, vertices);
    }
}
