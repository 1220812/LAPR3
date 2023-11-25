package LAPR.US02_US03.UI.Console;



import LAPR.US02_US03.Domain.ResultEntry;
import LAPR.US02_US03.Readers.ReadInstructionsFromFile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class IrrigationUI implements Runnable {

    @Override
    public void run() {

        ReadInstructionsFromFile r = new ReadInstructionsFromFile();
        try {
            List<ResultEntry> result = r.readInformation("instructions.txt");
            //new File("output.txt").createNewFile();
            PrintWriter pw = new PrintWriter("output.txt");
            pw.printf("%10s %10s %10s %10s %10s\n", "Dia", "Sector", "Duração", "Inicio", "Final");
            System.out.printf("%10s %10s %10s %10s %10s\n", "Dia", "Sector", "Duração", "Inicio", "Final");
            for (ResultEntry resultEntry : result) {
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
