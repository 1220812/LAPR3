package LAPR.Interface.controller;

import LAPR.Interface.Domain.WateringData;
import LAPR.Interface.Domain.WateringPlanGenerator;
import LAPR.Interface.Readers.ReadInstructionsFromFile;

import java.io.IOException;
import java.util.List;

public class SimulateWateringController {
    public static List<WateringData> readWateringData(String textFile) throws IOException {
        return ReadInstructionsFromFile.readInformation(textFile);
    }
}
