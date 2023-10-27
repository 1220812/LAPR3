package readers;

import data.Partition;
import data.ResultEntry;
import data.SprinklingSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadInstructionsFromFile {
    public List<ResultEntry> readInformation(String fileName) throws IOException {
        Scanner sc = new Scanner(getClass().getClassLoader().getResourceAsStream(fileName));
        String[] header = sc.nextLine().split(",");
        List<Partition> result = new ArrayList<>();
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            result.add(new Partition(line[0], Integer.parseInt(line[1]), line[2]));
        }
        SprinklingSystem sprksis = new SprinklingSystem(result);
        return sprksis.generateSimulation(30, header[0], header[1]);
    }
}
