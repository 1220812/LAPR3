package LAPR.US02.main.java.UI.Console.menu;


import LAPR.US02.main.java.UI.Console.IrrigationUI;
import LAPR.US02.main.java.UI.Console.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ProductOwnerUI implements Runnable {
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Simulate irrigation system", new IrrigationUI()));


        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}