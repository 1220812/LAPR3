package ESINF.Structure.Auxiliary;

import ESINF.Structure.Edge;
import ESINF.Structure.Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MyGraph<V, E> implements Graph<V, E> {
    private boolean directed;
    private Map<V, Map<V, Edge<V, E>>> adjacencyList;

    public MyGraph(boolean directed) {
        this.directed = directed;
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public boolean isDirected() {
        return false;
    }

    @Override
    public int numVertices() {
        return 0;
    }

    @Override
    public ArrayList<V> vertices() {
        return null;
    }

    @Override
    public boolean validVertex(V vert) {
        return false;
    }

    @Override
    public int key(V vert) {
        return 0;
    }

    @Override
    public V vertex(int key) {
        return null;
    }

    @Override
    public V vertex(Predicate<V> p) {
        return null;
    }

    @Override
    public Collection<V> adjVertices(V vert) {
        return null;
    }

    @Override
    public int numEdges() {
        return 0;
    }

    @Override
    public Collection<Edge<V, E>> edges() {
        return null;
    }

    @Override
    public Edge<V, E> edge(V vOrig, V vDest) {
        return null;
    }

    @Override
    public Edge<V, E> edge(int vOrigKey, int vDestKey) {
        return null;
    }

    @Override
    public int outDegree(V vert) {
        return 0;
    }

    @Override
    public int inDegree(V vert) {
        return 0;
    }

    @Override
    public Collection<Edge<V, E>> outgoingEdges(V vert) {
        return null;
    }

    @Override
    public Collection<Edge<V, E>> incomingEdges(V vert) {
        return null;
    }

    @Override
    public boolean addVertex(V vert) {
        return false;
    }

    @Override
    public boolean addEdge(V vOrig, V vDest, E weight) {
        return false;
    }

    @Override
    public boolean removeVertex(V vert) {
        return false;
    }

    @Override
    public boolean removeEdge(V vOrig, V vDest) {
        return false;
    }

    @Override
    public Graph<V, E> clone() {
        return null;
    }
}
