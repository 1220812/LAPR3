package ESINF.Structure;

import java.util.*;


/**
 * Represents a graph using a map-based adjacency list.
 *
 * @param <V> Vertex value type
 * @param <E> Edge value type
 */
public class MapGraph<V, E> extends CommonGraph<V, E> {


    final private Map<V, MapVertex<V, E>> mapVertices;  // all the Vertices of the graph

    //TODO: REMOVER METODO DE TESTE

    //USEI04
    public void printGraph() {
        for (V vertex : mapVertices.keySet()) {
            System.out.print(vertex + " -> ");
            for (Edge<V, E> edge : mapVertices.get(vertex).getAllOutEdges()) {
                System.out.print("(" + edge.getVDest() + ", " + edge.getWeight() + ") ");
            }
            System.out.println();
        }
    }


    /**
     * Constructs an empty graph (either undirected or directed).
     *
     * @param directed Specifies whether the graph is directed or undirected.
     */
    public MapGraph(boolean directed) {
        super(directed);
        mapVertices = new LinkedHashMap<>();
    }
    /**
     * Constructs a graph from an existing graph.
     *
     * @param g The existing graph to be copied.
     */
    public MapGraph(Graph<V,E> g) {
        this(g.isDirected());
        copy(g, this);
    }
    /**
     * Checks if the given vertex is valid in the graph.
     *
     * @param vert The vertex to check for validity.
     * @return {@code true} if the vertex is valid, {@code false} otherwise.
     */

    @Override
    public boolean validVertex(V vert) { return (mapVertices.get(vert) != null);   }
    /**
     * Retrieves a collection of all adjacent vertices to the specified vertex.
     *
     * @param vert The vertex for which adjacent vertices are to be retrieved.
     * @return A collection of all adjacent vertices to the specified vertex.
     * Returns {@code null} if the vertex is not valid.
     */
    @Override
    public Collection<V> adjVertices(V vert) {
        if(!validVertex(vert)){
            return null;
        }

        MapVertex<V,E> map = mapVertices.get(vert);
        return map.getAllAdjVerts();
    }
    /**
     * Retrieves a collection of all edges in the graph.
     *
     * @return A collection of all edges in the graph.
     */
    @Override
    public Collection<Edge<V, E>> edges() {

        ArrayList<Edge<V, E>> le = new ArrayList<>(numEdges);

        for (MapVertex<V, E> mv : mapVertices.values())
            le.addAll(mv.getAllOutEdges());

        return le;
    }
    /**
     * Retrieves the edge between two vertices.
     *
     * @param vOrig The origin vertex.
     * @param vDest The destination vertex.
     * @return The edge between the specified vertices. Returns {@code null}
     * if either vertex is not valid.
     */
    @Override
    public Edge<V, E> edge(V vOrig, V vDest) {

        if (!validVertex(vOrig) || !validVertex(vDest))
            return null;

        MapVertex<V, E> mv = mapVertices.get(vOrig);

        return mv.getEdge(vDest);
    }
    /**
     * Retrieves the edge between two vertices using their keys.
     *
     * @param vOrigKey The key of the origin vertex.
     * @param vDestKey The key of the destination vertex.
     * @return The edge between the specified vertices. Returns {@code null}
     * if either vertex key is out of bounds.
     */
    @Override
    public Edge<V, E> edge(int vOrigKey, int vDestKey) {
        V vOrig = vertex(vOrigKey);
        V vDest = vertex(vDestKey);

        return edge(vOrig, vDest);
    }
    /**
     * Retrieves the out-degree of a vertex.
     *
     * @param vert The vertex for which the out-degree is to be retrieved.
     * @return The out-degree of the specified vertex. Returns -1 if the vertex
     * is not valid.
     */
    @Override
    public int outDegree(V vert) {

        if (!validVertex(vert))
            return -1;

        MapVertex<V, E> mv = mapVertices.get(vert);

        return mv.numAdjVerts();
    }
    /**
     * Retrieves the in-degree of a vertex.
     *
     * @param vert The vertex for which the in-degree is to be retrieved.
     * @return The in-degree of the specified vertex. Returns -1 if the vertex
     * is not valid.
     */
    @Override
    public int inDegree(V vert) {

        if (!validVertex(vert))
            return -1;

        int degree = 0;
        for (V otherVert : mapVertices.keySet())
            if (edge(otherVert, vert) != null)
                degree++;

        return degree;
    }
    /**
     * Retrieves a collection of all outgoing edges from the specified vertex.
     *
     * @param vert The vertex for which outgoing edges are to be retrieved.
     * @return A collection of all outgoing edges from the specified vertex.
     * Returns {@code null} if the vertex is not valid.
     */
    @Override
    public Collection<Edge<V, E>> outgoingEdges(V vert) {

        if (!validVertex(vert))
            return null;

        MapVertex<V, E> mv = mapVertices.get(vert);

        return mv.getAllOutEdges();
    }

    /**
     * Retrieves a collection of all incoming edges to the specified vertex.
     *
     * @param vert The vertex for which incoming edges are to be retrieved.
     * @return A collection of all incoming edges to the specified vertex.
     *         Returns {@code null} if the vertex is not valid.
     */
    @Override
    public Collection<Edge<V, E>> incomingEdges(V vert) {
        if(!validVertex(vert)){
            return null;
        }

        ArrayList<Edge<V,E>> incomingEdgeList = new ArrayList<>();

        for (MapVertex<V,E> map : mapVertices.values()) {
            Edge<V,E> edge = map.getEdge(vert);
            if(edge != null){
                incomingEdgeList.add(edge);
            }
        }
        return incomingEdgeList;
    }
    /**
     * Adds a vertex to the graph.
     *
     * @param vert The vertex to be added.
     * @return {@code true} if the vertex is added successfully,
     * {@code false} if the vertex already exists in the graph.
     */
    @Override
    public boolean addVertex(V vert) {

        if (vert == null) throw new RuntimeException("Vertices cannot be null!");
        if (validVertex(vert))
            return false;

        MapVertex<V, E> mv = new MapVertex<>(vert);
        vertices.add(vert);
        mapVertices.put(vert, mv);
        numVerts++;

        return true;
    }
    /**
     * Adds an edge to the graph between two vertices with a specified weight.
     *
     * @param vOrig   The origin vertex.
     * @param vDest   The destination vertex.
     * @param weight  The weight of the edge.
     * @return {@code true} if the edge is added successfully,
     * {@code false} if the edge already exists in the graph.
     */
    @Override
    public boolean addEdge(V vOrig, V vDest, E weight) {

        if (vOrig == null || vDest == null) throw new RuntimeException("Vertices cannot be null!");
        if (edge(vOrig, vDest) != null)
            return false;

        if (!validVertex(vOrig))
            addVertex(vOrig);

        if (!validVertex(vDest))
            addVertex(vDest);

        MapVertex<V, E> mvo = mapVertices.get(vOrig);
        MapVertex<V, E> mvd = mapVertices.get(vDest);

        Edge<V, E> newEdge = new Edge<>(mvo.getElement(), mvd.getElement(), weight);
        mvo.addAdjVert(mvd.getElement(), newEdge);
        numEdges++;

        //if graph is not direct insert other edge in the opposite direction
        if (!isDirected)
            // if vDest different vOrig
            if (edge(vDest, vOrig) == null) {
                Edge<V, E> otherEdge = new Edge<>( mvd.getElement(), mvo.getElement(), weight);
                mvd.addAdjVert(mvo.getElement(), otherEdge);
                numEdges++;
            }

        return true;
    }
    /**
     * Removes a vertex from the graph along with all its incident edges.
     *
     * @param vert The vertex to be removed.
     * @return {@code true} if the vertex is removed successfully,
     * {@code false} if the vertex does not exist in the graph.
     */
    @Override
    public boolean removeVertex(V vert) {

        if (vert == null) throw new RuntimeException("Vertices cannot be null!");
        if (!validVertex(vert))
            return false;

        //remove all edges that point to vert
        for (Edge<V, E> edge : incomingEdges(vert)) {
            removeEdge(edge.getVOrig(), vert);
        }

        MapVertex<V, E> mv = mapVertices.get(vert);

        //The edges that live from vert are removed with the vertex
        numEdges -= mv.numAdjVerts();
        mapVertices.remove(vert);
        vertices.remove(vert);

        numVerts--;

        return true;
    }
    /**
     * Removes an edge between two vertices from the graph.
     *
     * @param vOrig The origin vertex.
     * @param vDest The destination vertex.
     * @return {@code true} if the edge is removed successfully,
     * {@code false} if the edge does not exist in the graph.
     */
    @Override
    public boolean removeEdge(V vOrig, V vDest) {

        if (vOrig == null || vDest == null) throw new RuntimeException("Vertices cannot be null!");
        if (!validVertex(vOrig) || !validVertex(vDest))
            return false;

        Edge<V, E> edge = edge(vOrig, vDest);

        if (edge == null)
            return false;

        MapVertex<V, E> mvo = mapVertices.get(vOrig);

        mvo.remAdjVert(vDest);
        numEdges--;

        //if graph is not directed
        if (!isDirected) {
            edge = edge(vDest, vOrig);
            if (edge != null) {
                MapVertex<V, E> mvd = mapVertices.get(vDest);
                mvd.remAdjVert(vOrig);
                numEdges--;
            }
        }
        return true;
    }

    /**
     * Creates a clone of the graph.
     *
     * @return A clone of the graph.
     */
    @Override
    public MapGraph<V, E> clone() {

        MapGraph<V, E> g = new MapGraph<>(this.isDirected);

        copy(this,g);

        return g;
    }

    /**
     * Returns a string representation of the graph.
     *
     * @return A string representation of the graph, including the number
     * of vertices and edges, and a list of vertices with their incident edges.
     */
    @Override
    public String toString() {
        String s;
        if (numVerts == 0) {
            s = "\nGraph not defined!!";
        } else {
            s = "Graph: " + numVerts + " vertices, " + numEdges + " edges\n";
            for (MapVertex<V, E> mv : mapVertices.values())
                s += mv + "\n";
        }
        return s;
    }
}