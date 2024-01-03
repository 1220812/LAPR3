package LAPR.Interface.UI.Console.menu;

import LAPR.Interface.UI.Console.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationUI implements Runnable {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BOLD = "\u001B[1m";

    @Override
    public void run() {
        List<MenuItem> authenticationOption = new ArrayList<>();
        System.out.println(ANSI_CYAN + "\n=============================================");
        System.out.println("          Authentication Options             ");
        System.out.println("=============================================" + ANSI_RESET);

        authenticationOption.add(new MenuItem(ANSI_GREEN + ANSI_BOLD + "Product Owner" + ANSI_RESET, new ProductOwnerUI()));
        authenticationOption.add(new MenuItem(ANSI_GREEN + ANSI_BOLD + "Gestor Agricola" + ANSI_RESET, new GestorAgricolaUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(authenticationOption, "\n\nSelect Role:");

            if ((option >= 0) && (option < authenticationOption.size())) {
                authenticationOption.get(option).run();
            }
        } while (option != -1);
    }
}
