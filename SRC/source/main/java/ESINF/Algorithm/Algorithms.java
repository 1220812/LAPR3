package ESINF.Algorithm;

import ESINF.Domain.Locality;
import ESINF.Structure.Auxiliary.Path;
import ESINF.Structure.MapGraph;
import ESINF.Structure.MoreGraphAlgorithms;
import ESINF.US03.MinimumRoute;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Algorithms {

    public MinimumRoute findTripManifestoForMostDistantVertex(MapGraph<Locality, Integer> graph, double vehicleAutonomy) {
        Path<Locality> path = MoreGraphAlgorithms.mostDistantVertexOnGraph(graph);
        double autonomyLeft = vehicleAutonomy;
        double distance = 0;
        Locality lastLocality = null;
        if (path != null && path.getPath() != null && !path.getPath().isEmpty()) {
            lastLocality = path.getPath().get(0).getOrigin();
        }

        Set<Locality> chargingStops = new HashSet<>();
        List<Locality> route = new LinkedList<>();
        route.add(lastLocality);

        ESINF.Structure.Auxiliary.Segment<Locality> v = null;
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
            for (ESINF.Structure.Auxiliary.Segment<Locality> hubSegment : path.getPath()) {

                if (hubSegment.getDistance() > autonomyLeft) {
                    chargingStops.add(lastLocality);
                    autonomyLeft = vehicleAutonomy;
                }
                autonomyLeft -= hubSegment.getDistance();
                distance += hubSegment.getDistance();
                route.add(hubSegment.getOrigin());
                lastLocality = hubSegment.getDestination();
            }
            ESINF.Structure.Auxiliary.Segment<Locality> last = path.getPath().get(path.getPath().size() - 1);
            route.add(last.getDestination());
        }
        if (path != null) {
            return new MinimumRoute(path.getOrigin(), path.getDestination(), vehicleAutonomy, route, chargingStops, distance);
        }
        return null;
    }
}

