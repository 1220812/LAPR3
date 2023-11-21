package UI.Console.menu;


import ui.console.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainMenuUI implements Runnable {

    public MainMenuUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Do Login", new AuthenticationUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }


}
