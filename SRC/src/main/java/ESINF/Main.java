package ESINF;

import ESINF.Algorithm.Algorithms;
import ESINF.Domain.Hub;
import ESINF.FileReader.ReaderFiles;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;
import ESINF.US03.MinimumRoute;
import ESINF.US04.MinSpanningTreeResult;

import java.io.IOException;

import static ESINF.US04.MinSpanningTreeResult.printMinimumSpanningTree;

public class Main {
    public static void main(String[] args) throws IOException{


        ReaderFiles importer = new ReaderFiles();

        importer.importLocalData("C:\\Users\\leono\\IdeaProjects\\sem3pi2023\\sem3pi2023\\sem3pi2023_24_g081\\SRC\\src\\main\\resources\\ESINF\\locais_small.csv");

        importer.importDistanceData("C:\\Users\\leono\\IdeaProjects\\sem3pi2023\\sem3pi2023\\sem3pi2023_24_g081\\SRC\\src\\main\\resources\\ESINF\\distancias_small.csv");


        NetworkBuilder networkBuilder = NetworkBuilder.getInstance();

        MapGraph<Hub, Integer> mapGraph = networkBuilder.getDistribution();

        mapGraph.printGraph();

        MinimumRoute minimumRoute = new Algorithms().findTripManifestoForMostDistantVertex(networkBuilder.getDistribution(), 0);



        System.out.println(minimumRoute);


        //US04
        MapGraph<Hub, Integer> testGraph = networkBuilder.getInstance().getDistribution();

        MapGraph<Hub, Integer> minSpanning = MinSpanningTreeResult.getMinimumSpanningTree(testGraph);
        printMinimumSpanningTree(minSpanning);

        int totalDistance = MinSpanningTreeResult.calculateTotalDistance(minSpanning);
        System.out.println("Total Minimum Distance: " + totalDistance + "meters.");
    }
}
