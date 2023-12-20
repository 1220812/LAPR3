package ESINF.US03;

import ESINF.Domain.Coordinates;
import ESINF.Domain.Locality;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class MinimumRoute {
    public static final int M_TO_KM_CONVERSION = 1000;
    @EqualsAndHashCode.Include
    private Locality start;
    @EqualsAndHashCode.Include
    private Locality destination;
    private double vehicleAutonomy;
    private List<Locality> route;
    private Set<Locality> charged;
    private double totalDistance;

    public MinimumRoute() {
        this.charged = new HashSet<>();
    }

    public int getNumberOfStops() {
        return charged.size();
    }

    public double distance() {
        Coordinates coordinates = new Coordinates(start.getLatitude(), start.getLongitude());
        return coordinates.distance(destination.getLatitude(), destination.getLongitude());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("===============ROUTE DETAILS===============").append("\n");
        sb.append("Start: ").append(destination.getName()).append("\n");
        sb.append("Destination: ").append(start.getName()).append("\n");
        sb.append(String.format("Distance Traveled: %.3fkm", totalDistance / M_TO_KM_CONVERSION)).append("\n");

        sb.append("Route:").append("\n");

        double totalRouteDistance = 0;

        // Inverte a lista route
        List<Locality> reversedRoute = new ArrayList<>(route);
        Collections.reverse(reversedRoute);

        for (int i = 0; i < reversedRoute.size() - 1; i++) {
            Locality currentLocality = reversedRoute.get(i);
            Locality nextLocality = reversedRoute.get(i + 1);

            double distanceBetweenHubs = currentLocality.distanceTo(nextLocality);

            totalRouteDistance += distanceBetweenHubs;

            sb.append("\t").append(currentLocality.getName()).append(" -> ").append(nextLocality.getName());
            if (charged.contains(nextLocality)) {
                sb.append("*");
            }
            sb.append(" (Distance: ").append(String.format("%.3fkm", distanceBetweenHubs / M_TO_KM_CONVERSION)).append(")\n");
        }

        // Adiciona o último elemento (destino) apenas se não for a mesma estação que a de início
        Locality lastLocality = reversedRoute.get(reversedRoute.size() - 1);
        if (!lastLocality.equals(start)) {
            double distanceBetweenHubs = lastLocality.distanceTo(start);
            sb.append("\t").append(lastLocality.getName()).append(" -> ").append(start.getName());
            if (charged.contains(start)) {
                sb.append("*");
            }
            sb.append(" (Distance: ").append(String.format("%.3fkm", distanceBetweenHubs / M_TO_KM_CONVERSION)).append(")\n");
        }

        sb.append("Total number of stops: ").append(getNumberOfStops()).append("\n");
        sb.append("Note: \"*\" means charging on that station").append("\n");
        sb.append("============================================").append("\n");
        return sb.toString();
    }
}