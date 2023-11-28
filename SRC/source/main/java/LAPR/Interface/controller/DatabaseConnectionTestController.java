package LAPR.Interface.controller;

import LAPR.Interface.dataAccess.DatabaseConnection;

import java.sql.SQLException;

public class DatabaseConnectionTestController {

    public DatabaseConnectionTestController(){

    }
    public int DatabaseConnectionTest() throws SQLException{
        int result = DatabaseConnection.getInstance().testConnection();
        return result;
    }
}
