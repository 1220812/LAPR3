package LAPR.Interface.UI.Console;

import ESINF.Domain.Locality;
import ESINF.FileReader.ReaderFiles;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;
import ESINF.US02.HubDefiner;
import ESINF.US11.ScheduleSetter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecheduleSetterUI implements Runnable{
    @SneakyThrows
    public void run(){
        try {
            ReaderFiles.importLocalData("SRC/source/main/resources/ESINF/locais_big.csv");
            ReaderFiles.importDistanceData("SRC/source/main/resources/ESINF/distancias_big.csv", "SRC/source/main/resources/ESINF/locais_big.csv");
            NetworkBuilder networkBuilder = NetworkBuilder.getInstance();
            MapGraph<Locality, Integer> graph = networkBuilder.getDistribution();
            int numberOfHubs = 5;
            HubDefiner hubDefiner = new HubDefiner();
            hubDefiner.defineHubs(graph, numberOfHubs);
            String filePath;
            do{
                filePath = promptForFilePath();
            }while (!fileValidation(filePath));
            String[] schedules = ReaderFiles.importNewSchedules(filePath);
            ScheduleSetter.ScheduleSetter(schedules, graph);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private boolean fileValidation(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("The file does not exist!");
            return false;
        }

        if (file.length() == 0) {
            System.out.println("The file is empty");
            return false;
        }

        return true;
    }
    private String promptForFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please insert the path of the file with the schedules that you want to load:");
        return scanner.nextLine();
    }
}
