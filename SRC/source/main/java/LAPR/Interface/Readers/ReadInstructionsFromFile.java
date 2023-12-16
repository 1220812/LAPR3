package LAPR.Interface.Readers;


import LAPR.Interface.Domain.Partition;
import LAPR.Interface.Domain.ResultEntry;
import LAPR.Interface.Domain.SprinklingSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadInstructionsFromFile {

    public List<ResultEntry> readInformation(String fileName) throws IOException {
        List<Partition> result = new ArrayList<>();
        List<ResultEntry> resultEntries;
        String[] header;

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {

            header = reader.readLine().split(",");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    result.add(new Partition(fields[0], Integer.parseInt(fields[1]), fields[2]));
                } else {
                    result.add(new Partition(fields[0], Integer.parseInt(fields[1]), fields[2], fields[3], Integer.parseInt(fields[4])));
                }
            }
        }

        SprinklingSystem sprinklingSystem = new SprinklingSystem(result);
        resultEntries = sprinklingSystem.generateSimulation(30, header[0], header[1]);
        return resultEntries;
    }
}