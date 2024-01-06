package LAPR.Interface.UI.Console.menu;


import LAPR.Interface.UI.Console.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static LAPR.Interface.UI.Console.menu.AuthenticationUI.ANSI_BOLD;

public class MainMenuUI implements Runnable {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public MainMenuUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<>();
        System.out.println(ANSI_CYAN + "\n=============================================");
        System.out.println("              Main Menu - Options             ");
        System.out.println("=============================================" + ANSI_RESET);

        options.add(new MenuItem(ANSI_GREEN + ANSI_BOLD+ "Do Login" +ANSI_RESET , new AuthenticationUI()));
        options.add(new MenuItem(ANSI_GREEN+ANSI_BOLD +"Database Connection Test" +ANSI_RESET, new DatabaseConnectionTestUI()));
        options.add(new MenuItem(ANSI_GREEN+ANSI_BOLD+ "Exit" + ANSI_RESET, new ExitUI()));
        options.add(new MenuItem(ANSI_GREEN+ANSI_BOLD+ "ESINF" + ANSI_RESET, new ESINF_UI()));

        int option = 0;
        do {
            System.out.println("\n\n=============================================");
            System.out.println("             Welcome to Main Menu             ");
            System.out.println("=============================================");

            option = Utils.showAndSelectIndex(options, "Choose an option:");

            System.out.println("=============================================\n\n");


            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }


}
