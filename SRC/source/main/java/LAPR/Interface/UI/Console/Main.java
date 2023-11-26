package LAPR.Interface.UI.Console;
import LAPR.Interface.UI.Console.menu.MainMenuUI;
import LAPR.Interface.dataAccess.DatabaseConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
    public static void main(String[] args) {

        try {
            loadProperties();

            String ipAddress = System.getProperty("");
            InetAddress inet = InetAddress.getByName(ipAddress);

            MainMenuUI menu = new MainMenuUI();
            menu.run();
            DatabaseConnection.getInstance().closeConnection();
        } catch (UnknownHostException e) {
            System.out.println("\nDatabase Server not reachable");
        } catch (Exception e) {
            System.out.println("App properties not loaded!");
        }
    }
    private static void loadProperties() throws IOException{
        Properties properties = new Properties(System.getProperties());

        InputStream inputStream = new Main().getClass().getResourceAsStream("application.properties");
        properties.load(inputStream);
        inputStream.close();

        System.setProperties(properties);
    }
}