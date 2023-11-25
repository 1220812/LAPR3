package US03;


import Domain.Coordinates;
import Domain.Hub;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class MinimumRoute {





    public static final int M_TO_KM_CONVERSION = 1000;
    @EqualsAndHashCode.Include
    private Hub start;
    @EqualsAndHashCode.Include
    private Hub destination;
    private double vehicleAutonomy;
    private List<Hub> route;
    private Set<Hub> charged;
    private double totalDistance;

    public MinimumRoute() {

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
        sb.append("Start: ").append(destination.getHubId()).append("\n");
        sb.append("Destination: ").append(start.getHubId()).append("\n");
        sb.append(String.format("Distance Traveled: %.3fkm", totalDistance / M_TO_KM_CONVERSION)).append("\n");
        sb.append("Route:").append("\n");

        // Inverte a lista route
        List<Hub> reversedRoute = new ArrayList<>(route);
        Collections.reverse(reversedRoute);

        for (int i = 0; i < reversedRoute.size() - 1; i++) {
            Hub currentHub = reversedRoute.get(i);
            Hub nextHub = reversedRoute.get(i + 1);

            sb.append("\t").append(currentHub.getHubId()).append(" -> ").append(nextHub.getHubId());
            if (charged.contains(nextHub)) {
                sb.append("*");
            }
            sb.append("\n");
        }

        // Adiciona o último elemento (destino) apenas se não for a mesma estação que a de início
        Hub lastHub = reversedRoute.get(reversedRoute.size() - 1);
        if (!lastHub.equals(start)) {
            sb.append("\t").append(lastHub.getHubId()).append(" -> ").append(start.getHubId());
            if (charged.contains(start)) {
                sb.append("*");
            }
            sb.append("\n");
        }

        sb.append("Total number of stops: ").append(getNumberOfStops()).append("\n");
        sb.append("Note: \"*\" means charging on that station").append("\n");
        sb.append("============================================").append("\n");
        return sb.toString();
    }





}

