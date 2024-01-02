package LAPR.Interface.UI.Console;

import LAPR.Interface.Domain.ResultEntry;
import LAPR.Interface.controller.OperationRegisterController;
import LAPR.Interface.dataAccess.IrrigationProgramRepository;

import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WateringRegisterUI implements Runnable {
    private OperationRegisterController controller;

    public WateringRegisterUI(){
        controller = new OperationRegisterController();
    }
    @Override
    public void run() {
        try {
            Scanner sc = new Scanner(new File("output.txt"));
            sc.nextLine();

            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split("\\s+");

                if(parts.length >= 5){
                    String day = parts[0];
                    String setor = parts[1];
                    int duration = Integer.parseInt(parts[2]);
                    String start = parts[3];
                    String end = parts[4];
                    String mix = parts[5];
                    int formule = Integer.parseInt(parts[6]);
                    Date date;
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        date = dateFormat.parse(day);
                    } catch (ParseException e) {
                        System.err.println("Erro ao fazer parse da data: " + e.getMessage());
                        continue; // Skip to the next iteration
                    }

                    ResultEntry watering = new ResultEntry(date, setor, duration, start, end, mix, formule);
                    controller.registerWateringOperation(watering);
                    int status = (controller.registerWateringOperation(watering));

                    if(status == 1){
                        System.out.println("Operation successfully registered");
                    }else{
                        System.out.println("Error on register. Status: " + status);
                    }
                }else {
                    System.err.println("The read line doesn't contain the needed information: " + line);
                }
            }

            sc.close();

        } catch (FileNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
