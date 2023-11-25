package ESINF;

import ESINF.Algorithm.Algorithms;
import ESINF.Domain.Hub;
import ESINF.FileReader.ReaderFiles;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;
import ESINF.US03.MinimumRoute;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        ReaderFiles importer = new ReaderFiles();

        importer.importLocalData("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\src\\main\\resources\\ESINF\\locais_small.csv");

        importer.importDistanceData("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\src\\main\\resources\\ESINF\\distancias_small.csv");


        NetworkBuilder networkBuilder = NetworkBuilder.getInstance();

        MapGraph<Hub, Integer> mapGraph = networkBuilder.getDistribution();

        mapGraph.printGraph();

        MinimumRoute minimumRoute = new Algorithms().findTripManifestoForMostDistantVertex(networkBuilder.getDistribution(), 0);



        System.out.println(minimumRoute);



    }
}
