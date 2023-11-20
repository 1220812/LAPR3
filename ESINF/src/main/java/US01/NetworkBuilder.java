package US01;

import Domain.Coordinates;
import Domain.Hub;
import Structure.MapGraph;
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
    final private MapGraph<Hub, Double> distribution;
    /**
     * Constructs a new `NetworkBuilder` instance with an initially empty distribution graph.
     * The graph is directed and weighted.
     */
    private NetworkBuilder(){
        this.distribution = new MapGraph<>(false);
    }

    /**
     * Gets
     */
    public MapGraph<Hub, Double> getDistribution() {
        return distribution;
    }

    public static NetworkBuilder getInstance() {
        return instance;
    }
    /**
     * Adds a hub to the distribution network with the specified hubId, latitude, and longitude.
     *
     * @param hubId The unique identifier of the hub.
     * @param latitude The latitude of the hub's geographical coordinates.
     * @param longitude The longitude of the hub's geographical coordinates.
     * @return `true` if the hub is successfully added; `false` otherwise.
     */
    public boolean addHub(String hubId, Double latitude, Double longitude){
        Hub vert = new Hub(hubId, new Coordinates(latitude, longitude));
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
    public boolean addRoute(Hub orig, Hub dest, Double distance){
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
