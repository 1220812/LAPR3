package LAPR.Interface.Readers;

import LAPR.Interface.Domain.Partition;
import LAPR.Interface.Domain.ResultEntry;
import LAPR.Interface.Domain.SprinklingSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadInstructionsFromFile {

    public List<ResultEntry> readInformation(String fileName) throws IOException {
        File file = new File(fileName);

        // Verification 1: Check if the file exists
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }

        // Verification 2: Check if the file is a regular file (not a directory, etc.)
        if (!file.isFile()) {
            throw new IOException("Not a valid file: " + fileName);
        }

        Scanner sc = new Scanner(file);

        // Verification 3: Check if the file is not empty
        if (!sc.hasNextLine()) {
            throw new IOException("File is empty: " + fileName);
        }

        String[] header = sc.nextLine().split(",");
        List<Partition> result = new ArrayList<>();

        // Verification 4: Check if header has expected number of fields
        if (header.length != 2) {
            throw new IOException("Invalid header format in file: " + fileName);
        }

        // Verification 5: Check for valid data rows
        while (sc.hasNextLine()) {
            String[] fields = sc.nextLine().split(",");

            // Verification 6: Check if each data row has the expected number of fields
            if (fields.length == 3) {
                result.add(new Partition(fields[0], Integer.parseInt(fields[1]), fields[2]));
            } else if (fields.length == 5) {
                result.add(new Partition(fields[0], Integer.parseInt(fields[1]), fields[2], fields[3], Integer.parseInt(fields[4])));
            } else {
                // Verification 7: Handle unexpected number of fields in a data row
                throw new IOException("Invalid data format in file: " + fileName);
            }
        }

        // Verification 8: Check if any partitions were read
        if (result.isEmpty()) {
            throw new IOException("No partitions found in file: " + fileName);
        }

        SprinklingSystem sprinklingSystem = new SprinklingSystem(result);
        List<ResultEntry> resultEntries = sprinklingSystem.generateSimulation(30, header[0], header[1]);

        // Verification 9: Check if simulation results were generated
        if (resultEntries.isEmpty()) {
            throw new IOException("Simulation results are empty for file: " + fileName);
        }

        return resultEntries;
    }
}