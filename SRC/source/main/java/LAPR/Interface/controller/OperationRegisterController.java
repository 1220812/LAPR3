package LAPR.Interface.controller;

//import LAPR.Interface.Domain.WateringData;
import LAPR.Interface.Domain.ResultEntry;
import LAPR.Interface.dataAccess.IrrigationProgramRepository;
import LAPR.Interface.dataAccess.OperationRepository;
import LAPR.Interface.dataAccess.Repositories;

import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

public class OperationRegisterController {
    private OperationRepository operationRepository;
    private IrrigationProgramRepository irrigationProgramRepository;
    public OperationRegisterController(){
        getIrrigationProgramRepository();
    }
    private OperationRepository getOperationRepository(){
        if(Objects.isNull(operationRepository)){
            Repositories repositories = Repositories.getInstance();
            operationRepository = repositories.getOperationRepository();

        }
        return operationRepository;
    }
    private IrrigationProgramRepository getIrrigationProgramRepository(){
        if(Objects.isNull(irrigationProgramRepository)){
            Repositories repositories = Repositories.getInstance();
            irrigationProgramRepository = repositories.getIrrigationProgramRepository();
        }
        return irrigationProgramRepository;
    }
    public void registerSowingOperation( int plantationID, Date date) throws SQLException{
        operationRepository.registerSowingOperation(date, plantationID);
    }
    public void registerWeedOperation( int plantation, Date date) throws SQLException{
        operationRepository.registerWeedOperation( date, plantation);
    }
    public void registerHarvestOperation( Date date, int plantationID, int quantity) throws SQLException{
        operationRepository.registerHarvestOperation( date, plantationID, quantity);
    }
    public void registerPruningOperation( Date date, int plantationID) throws SQLException{
        operationRepository.registerPruningOperation( date, plantationID);
    }
    public void registerFertilizationOperation( Date date, int plantation, int productID, String mode) throws SQLException{
        operationRepository.registerFertilizationOperation( date, plantation, productID, mode);
    }

    public int registerWateringOperation (ResultEntry wateringDay) throws SQLException{
        return irrigationProgramRepository.registerWatering(wateringDay);
    }

}
