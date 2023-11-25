package LAPR.US02.main.java.UI.Console;



import LAPR.US02.main.java.Domain.ResultEntry;
import LAPR.US02.main.java.Readers.ReadInstructionsFromFile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class IrrigationUI implements Runnable {

    @Override
    public void run() {

        ReadInstructionsFromFile r = new ReadInstructionsFromFile();
        try {
            List<ResultEntry> result = r.readInformation("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\src\\main\\resources\\LAPR\\instructions.txt");
            new File("output.txt").createNewFile();
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
