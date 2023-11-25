package LAPR.US02.main.java.UI.Console;
import LAPR.US02.main.java.UI.Console.menu.MainMenuUI;

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
            MainMenuUI menu = new MainMenuUI();
            menu.run();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}