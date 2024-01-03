package LAPR.Interface.UI.Console;
import LAPR.Interface.UI.Console.menu.MainMenuUI;
import LAPR.Interface.dataAccess.DatabaseConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws IOException{

        try {
            loadProperties();

            String ipAddress = System.getProperty("database.inet");
            InetAddress inet = InetAddress.getByName(ipAddress);

            MainMenuUI menu = new MainMenuUI();
            menu.run();
            DatabaseConnection.getInstance().closeConnection();
        } catch (UnknownHostException e) {
            System.out.println("\nDatabase Server not reachable");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    private static void loadProperties() throws IOException{
        Properties properties = new Properties(System.getProperties());

        InputStream inputStream = new Main().getClass().getClassLoader().getResource("application.properties").openStream();

        if(inputStream != null){
            properties.load(inputStream);
            inputStream.close();
            System.setProperties(properties);
        }else{
            System.out.println("File not founded!");
        }
    }
}