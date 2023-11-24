package US03;


import Domain.Coordinates;
import Domain.Hub;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

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
        sb.append("===============TRIP MANIFESTO===============").append("\n");
        sb.append("Start: ").append(start.getHubId()).append("\n");
        sb.append("Destination: ").append(destination.getHubId()).append("\n");
        sb.append(String.format("Distance: %.3fkm", distance() / M_TO_KM_CONVERSION)).append("\n");
        sb.append("Route:").append("\n");
        int counter = 1;
        for (Hub hub : route) {
            sb.append("\t").append(counter + " - " + hub.getHubId());
            if (charged.contains(hub)) {
                sb.append("*");
            }
            sb.append("\n");
            counter++;
        }
        sb.append(String.format("Distance Traveled: %.3fkm", totalDistance/M_TO_KM_CONVERSION)).append("\n");
        sb.append("Note: \"*\" means charging on that station").append("\n");
        sb.append("============================================").append("\n");
        return sb.toString();
    }


}

