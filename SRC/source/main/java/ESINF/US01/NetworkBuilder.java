package ESINF.US01;

import ESINF.Domain.Locality;
import ESINF.Domain.Schedule;
import ESINF.Structure.MapGraph;
/**
 * The `NetworkBuilder` class is a singleton builder for constructing and managing a network of hubs
 * represented by a directed weighted graph. It provides methods to add hubs and routes to the network.
 */
public class NetworkBuilder {
    /**
     * The singleton instance of the `NetworkBuilder` class.
     */
    private static final NetworkBuilder instance = new NetworkBuilder();
    /**
     * The underlying graph representing the distribution network.
     */
    final private MapGraph<Locality, Integer> distribution;
    /**
     * Constructs a new `NetworkBuilder` instance with an initially empty distribution graph.
     * The graph is directed and weighted.
     */
    public NetworkBuilder(){
        this.distribution = new MapGraph<>(false);
    }

    /**
     * Gets
     */
    public MapGraph<Locality, Integer> getDistribution() {
        return distribution;
    }

    public static NetworkBuilder getInstance() {
        return instance;
    }
    /**
     * Adds a hub to the distribution network.
     *
     * @param vert the vert to be added to the graph as a vertex
     * @return `true` if the hub is successfully added; `false` otherwise.
     */
    public boolean addLocality(Locality vert){
        return distribution.addVertex(vert);
    }
    /**
     * Adds a route to the distribution network between the specified origin and destination hubs
     * with the given distance.
     *
     * @param orig The origin hub.
     * @param dest The destination hub.
     * @param distance The distance between the origin and destination hubs.
     * @return `true` if the route is successfully added; `false` otherwise.
     */
    public boolean addRoute(Locality orig, Locality dest, int distance){
        return distribution.addEdge(orig, dest, distance);
    }
    /**
     * Returns a string representation of the `NetworkBuilder` object, including the distribution graph.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "NetworkBuilder :" +
                "distribution = " + distribution;
    }

}