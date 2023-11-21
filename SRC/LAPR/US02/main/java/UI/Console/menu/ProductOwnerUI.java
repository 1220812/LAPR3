package UI.Console.menu;

import UI.Console.Utils.Utils;
import UI.Console.IrrigationUI;

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