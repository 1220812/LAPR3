package LAPR.US02_US03.Readers;


import LAPR.US02_US03.Domain.ResultEntry;
import LAPR.US02_US03.Domain.SprinklingSystem;
import LAPR.US02_US03.Domain.Partition;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadInstructionsFromFile {
    public List<ResultEntry> readInformation(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        String[] header = sc.nextLine().split(",");
        List<Partition> result = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            result.add(new Partition(line[0], Integer.parseInt(line[1]), line[2]));
        }

        SprinklingSystem sprksis = new SprinklingSystem(result);
        List<ResultEntry> resultEntries = sprksis.generateSimulation(30, header[0], header[1]);

        return resultEntries;
    }
}