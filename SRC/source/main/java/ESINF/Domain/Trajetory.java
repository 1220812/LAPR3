package ESINF.Domain;

public class Trajetory {

    Locality origin;
    Locality destination;
    double distance;

    public Trajetory(Locality origin, Locality destination, double distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    public Locality getOrigin() {
        return origin;
    }

    public void setOrigin(Locality origin) {
        this.origin = origin;
    }

    public Locality getDestination() {
        return destination;
    }

    public void setDestination(Locality destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return origin.getName() + " -> " + destination.getName() + " Distance: " + distance;
    }
}
