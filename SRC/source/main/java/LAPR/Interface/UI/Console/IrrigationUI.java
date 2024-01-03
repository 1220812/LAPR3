package LAPR.Interface.UI.Console;

import LAPR.Interface.Domain.ResultEntry;
import LAPR.Interface.Readers.ReadInstructionsFromFile;

import java.io.*;
import java.util.*;

public class IrrigationUI implements Runnable {

    @Override
    public void run() {

        ReadInstructionsFromFile r = new ReadInstructionsFromFile();
        try {
            List<ResultEntry> result = r.readInformation("C:\\Users\\Utilizador\\Desktop\\sem3pi2023_24_g081_sprint3\\SRC\\source\\main\\resources\\LAPR\\instructions.txt");
            PrintWriter pw = new PrintWriter("output.txt");
            pw.printf("%10s %10s %10s %10s %10s %10s %10s\n", "Day", "Sector", "Duration", "Start", "End", "Mix", "Formule");
            System.out.printf("%10s  %10s  %10s  %10s  %10s  %10s  %10s\n", "Day", "Sector", "Duration", "Start", "End", "Mix", "Formule");
            for (ResultEntry resultEntry : result) {
                if(resultEntry.getMixDesignation() != null) {
                    if (resultEntry.getMixDesignation().equals("mix1")) {
                        resultEntry.setMixDesignation("10");
                    } else {
                        resultEntry.setMixDesignation("11");
                    }
                }
                pw.println(resultEntry);
                System.out.println(resultEntry);
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("error");
            throw new RuntimeException(e);
        }
    }
}

