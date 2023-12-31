package LAPR.Interface.UI.Console;

import LAPR.Interface.Domain.DateHour;
import LAPR.Interface.Domain.WateringData;
import LAPR.Interface.Domain.WateringPlanGenerator;
import LAPR.Interface.controller.SimulateWateringController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class IrrigationUI implements Runnable {

    @Override
    public void run() {

        try {
            simulatePlan();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void simulatePlan() throws IOException {
        setBegginingDate();
        boolean dataReadFromFile = readWateringDataFromFile();
        if (!dataReadFromFile) {
            System.out.println("The data in the file is wrong!");
            return;
        }
        generateWateringPlan();
        System.out.println("Watering plan successfully generated");
    }

    private void setBegginingDate() {
        DateHour dateHour = new DateHour();
        String userResponse = dateHour.promptForDateSettingChoice("beginning date");
        if ("y".equalsIgnoreCase(userResponse) || "yes".equalsIgnoreCase(userResponse)) {
            WateringData.setStartDate(dateHour.askDate());
        } else {
            setBeginningDateToToday();
        }
    }

    private void setBeginningDateToToday() {
        LocalDate localDate = LocalDate.now();
        Date date = java.sql.Date.valueOf(localDate);
        WateringData.setStartDate(date);
    }

    private boolean readWateringDataFromFile() throws IOException {
        String textFile = "C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\source\\main\\resources\\LAPR\\instructions.txt";
        List<WateringData> wateringDataList = SimulateWateringController.readWateringData(textFile);
        if (wateringDataList.isEmpty()) {
            return false;
        }
        WateringData.setWateringInstructionsList(wateringDataList);
        return true;
    }

    private void generateWateringPlan() {
        WateringPlanGenerator wateringPlanGenerator = new WateringPlanGenerator();
        int daysPlanned = 30;
        WateringData.setWateringDataMap(wateringPlanGenerator.planGenerator(WateringData.getWateringInstructionsList(), daysPlanned));
    }


}

