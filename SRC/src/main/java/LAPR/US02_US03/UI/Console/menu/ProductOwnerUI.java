package LAPR.US02_US03.UI.Console.menu;


import LAPR.US02_US03.UI.Console.ConsumesUI;
import LAPR.US02_US03.UI.Console.IrrigationUI;
import LAPR.US02_US03.UI.Console.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ProductOwnerUI implements Runnable {
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Simulate irrigation system", new IrrigationUI()));
        options.add(new MenuItem("Consume irrigation plan", new ConsumesUI()));



        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}