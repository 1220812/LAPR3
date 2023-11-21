package UI.Console.menu;

import UI.Console.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationUI implements Runnable {

    @Override
    public void run() {
        List<MenuItem> authenticationOption = new ArrayList<MenuItem>();
        authenticationOption.add(new MenuItem("Product Owner", new ProductOwnerUI()));
        authenticationOption.add(new MenuItem("Gestor Agricola", new GestorAgricolaUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(authenticationOption, "\n\nSelect Role:");

            if ((option >= 0) && (option < authenticationOption.size())) {
                authenticationOption.get(option).run();
            }
        } while (option != -1);
    }

}

