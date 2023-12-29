package LAPR.Interface.UI.Console.menu;


import LAPR.Interface.UI.Console.ConsumesUI;
import LAPR.Interface.UI.Console.IrrigationUI;
import LAPR.Interface.UI.Console.SecheduleSetterUI;
import LAPR.Interface.UI.Console.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ProductOwnerUI implements Runnable {
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Simulate irrigation system", new IrrigationUI()));
        options.add(new MenuItem("Consume irrigation plan", new ConsumesUI()));
        options.add(new MenuItem("Set Hubs schedules", new SecheduleSetterUI()));

        int option;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}