package Algorithm;

import Domain.Hub;
import Structure.Auxiliary.Path;
import Structure.MapGraph;
import Structure.MoreGraphAlgorithms;
import US03.MinimumRoute;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Algorithms {

    public MinimumRoute findTripManifestoForMostDistantVertex(MapGraph<Hub, Integer> graph, double vehicleAutonomy) {
        Path<Hub> path = MoreGraphAlgorithms.mostDistantVertexOnGraph(graph);
        double autonomyLeft = vehicleAutonomy;
        double distance = 0;
        Hub lastHub = null;
        if (path != null && path.getPath() != null && !path.getPath().isEmpty()) {
            lastHub = path.getPath().get(0).getOrigin();
        }

        Set<Hub> chargingStops = new HashSet<>();
        List<Hub> route = new LinkedList<>();
        route.add(lastHub);

        Structure.Auxiliary.Segment<Hub> v = null;
        if (path != null && path.getPath() != null && !path.getPath().isEmpty()) {
            v = path.getPath().remove(0);
        }

        if (v != null) {
            autonomyLeft -= v.getDistance();
        }

        if (v != null) {
            distance += v.getDistance();
        }
        if (path != null && path.getPath() != null) {
            for (Structure.Auxiliary.Segment<Hub> hubSegment : path.getPath()) {

                if (hubSegment.getDistance() > autonomyLeft) {
                    chargingStops.add(lastHub);
                    autonomyLeft = vehicleAutonomy;
                }
                autonomyLeft -= hubSegment.getDistance();
                distance += hubSegment.getDistance();
                route.add(hubSegment.getOrigin());
                lastHub = hubSegment.getDestination();
            }
            Structure.Auxiliary.Segment<Hub> last = path.getPath().get(path.getPath().size() - 1);
            route.add(last.getDestination());
        }
        if (path != null) {
            return new MinimumRoute(path.getOrigin(), path.getDestination(), vehicleAutonomy, route, chargingStops, distance);
        }
        return null;
    }
}

