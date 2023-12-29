package ESINF;

import ESINF.Domain.Locality;
import ESINF.Domain.Schedule;
import ESINF.FileReader.ReaderFiles;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;
import ESINF.US02.HubDefiner;
import ESINF.US11.ScheduleSetter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        ReaderFiles.importLocalData("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\source\\main\\resources\\ESINF\\locais_big.csv");
        ReaderFiles.importDistanceData("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\source\\main\\resources\\ESINF\\distancias_big.csv", "C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\source\\main\\resources\\ESINF\\locais_big.csv");

        NetworkBuilder networkBuilder = NetworkBuilder.getInstance();

        MapGraph<Locality, Integer> graph = networkBuilder.getDistribution();
        //graph.printGraph();

        System.out.println();

        int numberOfHubs = 5;

        System.out.println("US 2");
        HubDefiner hubDefiner = new HubDefiner();

        hubDefiner.defineHubs(graph, numberOfHubs);

        //graph.printGraph();

        //ScheduleSetter.importFromFile("SRC/source/main/resources/ESINF/schedulesHub.txt", graph);

        String[] schedules = ReaderFiles.importNewSchedules("SRC/source/main/resources/ESINF/schedulesHub.txt");
        ScheduleSetter.ScheduleSetter(schedules, graph);
    }
}
