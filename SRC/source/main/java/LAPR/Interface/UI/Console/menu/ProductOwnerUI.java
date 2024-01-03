package LAPR.Interface.UI.Console.menu;

import LAPR.Interface.UI.Console.IrrigationUI;
import LAPR.Interface.UI.Console.SecheduleSetterUI;
import LAPR.Interface.UI.Console.Utils.Utils;
import LAPR.Interface.UI.Console.WateringRegisterUI;

import java.util.ArrayList;
import java.util.List;

import static LAPR.Interface.UI.Console.menu.AuthenticationUI.ANSI_GREEN;

public class ProductOwnerUI implements Runnable {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BOLD = "\u001B[1m";

    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        System.out.println(ANSI_CYAN + "\n=============================================");
        System.out.println("          Product Owner Options              ");
        System.out.println("=============================================" + ANSI_RESET);

        options.add(new MenuItem(ANSI_GREEN+ANSI_BOLD + "Simulate Irrigation System" + ANSI_RESET, new IrrigationUI()));
        options.add(new MenuItem(ANSI_GREEN+ANSI_BOLD + "Consume Irrigation Plan" + ANSI_RESET, new WateringRegisterUI()));
        options.add(new MenuItem(ANSI_GREEN+ANSI_BOLD + "Set Hubs Schedules" + ANSI_RESET, new SecheduleSetterUI()));

        int option;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
