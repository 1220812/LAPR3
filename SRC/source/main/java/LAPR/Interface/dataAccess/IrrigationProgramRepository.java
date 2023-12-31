package LAPR.Interface.dataAccess;

import LAPR.Interface.Domain.WateringPlanGenerator;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class IrrigationProgramRepository {
    /*
    public int wateringRegister(WateringPlanGenerator watering) throws SQLException{
        CallableStatement callStet = null;
        int status;
        try{
            Connection connection = DatabaseConnection.getInstance().getConnection();
            status = 0;

            if(watering.getDate().isBefore(LocalDate.now()) || (watering.getDate().isEqual(LocalDate.now()) && watering.getEndTime().isBefore(LocalTime.now()))){
                String[] errorMessage = {null};

                callStet = connection.prepareCall("{call }")
            }
        }
    }

 */
}
