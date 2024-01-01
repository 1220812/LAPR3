package LAPR.Interface.dataAccess;

//import LAPR.Interface.Domain.WateringData;

import LAPR.Interface.Domain.ResultEntry;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

public class OperationRepository {
    public OperationRepository() {

    }
    IrrigationProgramRepository irrigationProgramRepository = new IrrigationProgramRepository();

    public void registerSowingOperation(Date date, int plantationID) throws SQLException {

    }

    public void registerWeedOperation(Date date, int plantationID) throws SQLException {
    }

    public void registerHarvestOperation(Date date, int plantationID, int quantity) throws SQLException {
    }

    public void registerPruningOperation( Date date, int plantationID) throws SQLException {
    }

    public void registerFertilizationOperation( Date date, int plantation, int productID, String mode) {
    }

    public int wateringRegister(ResultEntry wateringData) throws SQLException {
        return irrigationProgramRepository.registerWatering(wateringData);
    }
    public void sowingRegister( Date date, int PlantationplantationID) throws SQLException {
        CallableStatement callableStatement = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callableStatement = connection.prepareCall("{call prcRegisterOperation(?, ?, ?, ?, ?)}");

            callableStatement.setDate(1, (java.sql.Date) date);
            callableStatement.setInt(2, PlantationplantationID);

            callableStatement.execute();

            callableStatement = connection.prepareCall("{ call prcRegisterSowingOperation()}");

            callableStatement.execute();
            connection.commit();
        } finally {
            if (!Objects.isNull(callableStatement)) {
                callableStatement.close();
            }
        }
    }
    public void pruningRegister(Date date, int PlantationplantationID) throws SQLException {
        CallableStatement callableStatement = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callableStatement = connection.prepareCall("{call prcRegisterOperation( ?, ?)}");

            callableStatement.setDate(1, (java.sql.Date) date);
            callableStatement.setInt(2, PlantationplantationID);

            callableStatement.execute();

            callableStatement = connection.prepareCall("{ call prcRegisterPrunigOperation()}");

            callableStatement.execute();
            connection.commit();
        } finally {
            if (!Objects.isNull(callableStatement)) {
                callableStatement.close();
            }
        }
    }
    public void weedRegister( Date date, int PlantationplantationID) throws SQLException {
        CallableStatement callableStatement = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callableStatement = connection.prepareCall("{call prcRegisterOperation( ?, ?)}");

            callableStatement.setDate(1, (java.sql.Date) date);
            callableStatement.setInt(2, PlantationplantationID);

            callableStatement.execute();

            callableStatement = connection.prepareCall("{ call prcRegisterWeedOperation()}");

            callableStatement.execute();
            connection.commit();
        } finally {
            if (!Objects.isNull(callableStatement)) {
                callableStatement.close();
            }
        }
    }
    public void harvestRegister( Date date, int PlantationplantationID, int quantity) throws SQLException {
        CallableStatement callableStatement = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callableStatement = connection.prepareCall("{call prcRegisterOperation( ?, ?)}");

            callableStatement.setDate(1, (java.sql.Date) date);
            callableStatement.setInt(2, PlantationplantationID);

            callableStatement.execute();

            callableStatement = connection.prepareCall("{ call prcRegisterHarvestOperation(?)}");

            callableStatement.setInt(1, quantity);

            callableStatement.execute();
            connection.commit();
        } finally {
            if (!Objects.isNull(callableStatement)) {
                callableStatement.close();
            }
        }
    }
    public void fertilizationRegister( Date date, int PlantationplantationID, int productID, String mode) throws SQLException {
        CallableStatement callableStatement = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callableStatement = connection.prepareCall("{call prcRegisterOperation( ?, ?)}");

            callableStatement.setDate(1, (java.sql.Date) date);
            callableStatement.setInt(2, PlantationplantationID);

            callableStatement.execute();

            callableStatement = connection.prepareCall("{ call prcRegisterFertilizationOperation( ?, ?)}");

            callableStatement.setInt(1, productID);
            callableStatement.setString(2, mode);

            callableStatement.execute();
            connection.commit();
        } finally {
            if (!Objects.isNull(callableStatement)) {
                callableStatement.close();
            }
        }
    }
}