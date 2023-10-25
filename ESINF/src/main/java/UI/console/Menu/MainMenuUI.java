package UI.console.Menu;

import UI.console.Utils;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import UI.console.IrrigationUI;


public class MainMenuUI implements Runnable{

    public MainMenuUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<>();
        //options.add(new MenuItem("Irrigation", new IrrigationUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectMainMenuIndex(options, "\n\nMain Menu");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
            if (option == -1){}
        } while (option != -1);

    }
}
