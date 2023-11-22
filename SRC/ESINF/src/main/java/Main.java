import Algorithm.Algorithms;
import FileReader.ReaderFiles;
import US01.NetworkBuilder;
import US03.MinimumRoute;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        ReaderFiles importer = new ReaderFiles();

        importer.importLocalData("C:\\Users\\Utilizador\\Desktop\\Sem3pi202324_g081\\ESINF\\src\\main\\resources\\locais_big.csv");
        importer.importLocalData("C:\\Users\\Utilizador\\Desktop\\Sem3pi202324_g081\\ESINF\\src\\main\\resources\\locais_small.csv");

        importer.importDistanceData("C:\\Users\\Utilizador\\Desktop\\Sem3pi202324_g081\\ESINF\\src\\main\\resources\\distancias_big.csv");
        importer.importDistanceData("C:\\Users\\Utilizador\\Desktop\\Sem3pi202324_g081\\ESINF\\src\\main\\resources\\distancias_small.csv");


        NetworkBuilder networkBuilder = NetworkBuilder.getInstance();

        MinimumRoute minimumRoute = new Algorithms().findTripManifestoForMostDistantVertex(networkBuilder.getDistribution(), 300e3);

        System.out.println("Hello World!");

        System.out.println(minimumRoute);

        System.out.println("Hello World!");
    }
}
