package ESINF.US11;

import ESINF.Domain.Locality;
import ESINF.Domain.Schedule;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;

import java.util.Map;

public class ScheduleSetter {
    /**
     * Sets schedules for hub localities in a given graph based on the provided map of localities and schedules.
     * This method iterates through the vertices of the graph, checks if a locality is present in the provided map,
     * and if the locality is a hub. If the locality is a hub, it retrieves the schedule from the map and sets it for the
     * corresponding locality in the graph.
     * If a locality is not a hub, an error message is printed to the standard error stream, indicating that it's not
     * possible to define a schedule for non-hub localities.
     *
     * @param map   A map containing localities as keys and schedules as values.
     * @param graph The graph containing localities for which schedules need to be set.
     */
    public static void ScheduleSetter(Map<Locality, Schedule> map, MapGraph<Locality, Integer> graph) {
        for (Locality vertex : graph.vertices()) {
            if(map.containsKey(vertex)){
                if(vertex.getHub().equals(true)){
                    Schedule schedule = map.get(vertex);
                    graph.vertex(p->p.equals(vertex)).setSchedules(schedule);
                }else{
                    System.err.println("Error: Locality " + vertex.getName() + "it's not a hub, so that isn't possible to define a schedule!");
                }
            }
        }
    }
}