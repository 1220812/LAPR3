package ESINF.US08;

import ESINF.Domain.Locality;
import ESINF.Domain.Trajetory;
import ESINF.Structure.Edge;
import ESINF.Structure.GraphAlgorithms;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindCircuitForProducer {
    private static final int N = 5;
    private static final double VM = 60;
    private static final double AUTONOMY = 300;
    NetworkBuilder networkBuilder = NetworkBuilder.getInstance();
    MapGraph<Locality, Integer> graph = networkBuilder.getDistribution();

    double totalDistance = 0;

    public void runUS08() {

        System.out.println("#### US08 ####");


        Locality origin = graph.vertices().get(0);

        Locality firstEnd = firstPath(origin);

        System.out.println();


        LinkedList<Trajetory> trajetory = secondPath(firstEnd, origin);

        System.out.println();



        System.out.println("\u001B[31mTotal Distance: \u001B[0m" + totalDistance);

        double time = calculateTime(totalDistance, VM);
        System.out.println("Time: " + time + " horas");
        totalDistance = totalDistance / 1000;
        System.out.println("Number of Chargers= " + calculateNrCharges(totalDistance, AUTONOMY));

    }

    public Locality firstPath(Locality currentLocation) {
        System.out.println("First Path: ");
        List<Edge<Locality, Integer>> newOrigin;

        int maxCollab;
        int counter = 0;

        Locality maxLocal = null;
        List<Locality> alreadyPassed = new ArrayList<>();

        while (counter < N) {
            newOrigin = (List<Edge<Locality, Integer>>) graph.outgoingEdges(currentLocation);
            maxCollab = 0;

            for (Edge<Locality, Integer> edge : newOrigin) {
                int collaborator = edge.getVDest().getColaborator();

                if (collaborator > maxCollab) {
                    if (!alreadyPassed.contains(edge.getVDest())) {
                        maxCollab = collaborator;
                        maxLocal = edge.getVDest();
                    }
                }
            }
            System.out.println(currentLocation.getName() + " -> " + maxLocal.getName());
            System.out.println(" Distance: " + graph.edge(maxLocal, currentLocation).getWeight());
            totalDistance = totalDistance + graph.edge(maxLocal, currentLocation).getWeight();
            currentLocation = maxLocal;
            counter++;
            alreadyPassed.add(currentLocation);
        }
        System.out.println("------------------------------------");
        return maxLocal;
    }

    public LinkedList<Trajetory> secondPath(Locality start, Locality end) {
        System.out.println("Second Path: ");
        LinkedList<Locality> shortPath = new LinkedList<>();
        LinkedList<Trajetory> trajetory = new LinkedList<>();

        GraphAlgorithms.shortestPath(graph, start, end, shortPath);
        int counter = 0;
        for (Locality local : shortPath) {
            if (counter == 0) {
                counter++;
                continue;
            }

            Double distanceBeetween = Double.valueOf(graph.edge(start, local).getWeight());
            totalDistance = totalDistance + graph.edge(start, local).getWeight();


            trajetory.add(new Trajetory(start, local, distanceBeetween));
            start = local;

        }
        for (int i = 0; i < trajetory.size(); i++) {
            System.out.println(trajetory.get(i).toString());
        }
        System.out.println("------------------------------------");
        return trajetory;
    }

    public double calculateTime(double totalDistance, double VM) {
        double totalDistanceInKm;
        totalDistanceInKm = totalDistance / 1000.00;
        return (totalDistanceInKm / VM);
    }

    public int calculateNrCharges(double totalDistance, double AUTONOMY) {
        int nrCharges = (int) (totalDistance / AUTONOMY);
        double nrChargesDouble = totalDistance / AUTONOMY;

        if (nrChargesDouble > nrCharges) {
            nrCharges++;
        }

        return nrCharges;
    }

}



