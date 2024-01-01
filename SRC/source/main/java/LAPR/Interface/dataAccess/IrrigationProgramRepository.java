package LAPR.Interface.dataAccess;


import LAPR.Interface.Domain.ResultEntry;

import java.sql.*;
import java.time.Instant;
import java.util.Date;

public class IrrigationProgramRepository {

    public int registerWatering(ResultEntry wateringData) throws SQLException {
        CallableStatement callStat = null;
        int status;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            status = 0;

            if (wateringData.getDate().before(Date.from(Instant.now()))) {

                String[] errorMsg = {null};

                callStat = connection.prepareCall("{ call PRCWATERINGREGISTER(?, ?, ?, ?, ?, ?, ?, ?)}");

                java.sql.Date sqlDate = new java.sql.Date(wateringData.getDate().getTime());
                callStat.setDate(1, sqlDate);
                callStat.setString(2, String.valueOf(wateringData.getStartTime()));
                callStat.setString(3, String.valueOf(wateringData.getEndTime()));
                callStat.setInt(4, Integer.parseInt(String.valueOf(wateringData.getDuration())));
                callStat.setInt(5, Integer.parseInt(String.valueOf(wateringData.getDesignation())));
                callStat.setString(6, String.valueOf(wateringData.getMixDesignation()));

                callStat.registerOutParameter(7, Types.VARCHAR);
                callStat.registerOutParameter(8, Types.INTEGER);

                callStat.execute();

                errorMsg[0] = callStat.getString(7);
                status = callStat.getInt(8);

                if(errorMsg[0] != null){
                    System.out.println(errorMsg[0]);
                }
                connection.commit();
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            callStat.close();
        }
        return status;
    }
}
