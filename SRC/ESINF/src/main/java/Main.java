import Algorithm.Algorithms;
import Domain.Hub;
import FileReader.ReaderFiles;
import Structure.MapGraph;
import US01.NetworkBuilder;
import US03.MinimumRoute;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        ReaderFiles importer = new ReaderFiles();

        importer.importLocalData("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\ESINF\\src\\main\\resources\\locais_small.csv");

        importer.importDistanceData("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\ESINF\\src\\main\\resources\\distancias_small.csv");


        NetworkBuilder networkBuilder = NetworkBuilder.getInstance();

        MapGraph<Hub, Integer> mapGraph = networkBuilder.getDistribution();

        mapGraph.printGraph();

        MinimumRoute minimumRoute = new Algorithms().findTripManifestoForMostDistantVertex(networkBuilder.getDistribution(), 0);

        System.out.println("Hello World!");

        System.out.println(minimumRoute);

        System.out.println("Hello World!");

    }
}
