package LAPR.Interface.UI.Console.menu;

import LAPR.Interface.controller.OperationRegisterController;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class GestorAgricolaUI implements Runnable {
    private OperationRegisterController controller;

    public GestorAgricolaUI() {
        controller = new OperationRegisterController();
    }

    @Override
    public void run() {
        System.out.println("Register a new Operation");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select the type of the operation that you want to register!");
        System.out.println("1-Register a sowing operation");
        System.out.println("2-Register a weed operation");
        System.out.println("3-Register a harvest operation");
        System.out.println("4-Register a fertilization operation");
        System.out.println("5-Register a pruning operation");

        int selectedOption = 0;

        while (true) {
            if (scanner.hasNextInt()) {
                selectedOption = scanner.nextInt();

                if (selectedOption >= 1 && selectedOption <= 5) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        switch (selectedOption) {
            case 1:

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println("Please insert date of the operation: (DD-MM-YYYY)");
                String input = scanner.nextLine();
                dateFormat.setLenient(false);
                try {
                    dateFormat.parse(input);

                    System.out.println("Wrong date!");
                } catch (ParseException e) {
                    System.out.println("Inválid date, please insert a valid date in the format specified");
                }
                System.out.println("Please insert the id of the plantation where the operation was done");

                int entry = scanner.nextInt();

                try {
                    controller.registerSowingOperation( entry, Date.valueOf(input));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case 2:
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println("Please insert date of the operation: (DD-MM-YYYY)");
                String input1 = scanner.nextLine();
                dateFormat1.setLenient(false);
                try {
                    dateFormat1.parse(input1);

                    System.out.println("Wrong date!");
                } catch (ParseException e) {
                    System.out.println("Inválid date, please insert a valid date in the format specified");
                }
                System.out.println("Please insert the id of the plantation where the operation was done");

                int entry1 = scanner.nextInt();

                try {
                    controller.registerWeedOperation(entry1, Date.valueOf(input1));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case 3:
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println("Please insert date of the operation: (DD-MM-YYYY)");
                String input2 = scanner.nextLine();
                dateFormat2.setLenient(false);
                try {
                    dateFormat2.parse(input2);

                    System.out.println("Wrong date!");
                } catch (ParseException e) {
                    System.out.println("Inválida date, please insert a valid date in the format specified");
                }
                System.out.println("Please insert the id of the plantation where the operation was done");

                int entry2 = scanner.nextInt();

                System.out.println("Please Insert the quantity of the harvest:");

                int quantity = scanner.nextInt();

                try {
                    controller.registerHarvestOperation( Date.valueOf(input2), entry2, quantity);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case 4:
                SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println("Please insert date of the operation: (DD-MM-YYYY)");
                String input3 = scanner.nextLine();
                dateFormat3.setLenient(false);
                try {
                    dateFormat3.parse(input3);

                    System.out.println("Wrong date!");
                } catch (ParseException e) {
                    System.out.println("Inválid date, please insert a valid date in the format specified");
                }
                System.out.println("Please insert the id of the plantation where the operation was done");

                int entry3 = scanner.nextInt();

                System.out.println("Please insert the id of the product used in the fertilization");

                int id = scanner.nextInt();

                System.out.println("Please insert the mode of the fertilization (eg: solo)");

                String mode = scanner.nextLine();

                try {
                    controller.registerFertilizationOperation( Date.valueOf(input3), entry3, id, mode);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case 5:
                SimpleDateFormat dateFormat4 = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println("Please insert date of the operation: (DD-MM-YYYY)");
                String input4 = scanner.nextLine();
                dateFormat4.setLenient(false);
                try {
                    dateFormat4.parse(input4);

                    System.out.println("Wrong date!");
                } catch (ParseException e) {
                    System.out.println("Inválid date, please insert a valid date in the format specified");
                }
                System.out.println("Please insert the id of the plantation where the operation was done");

                int entry4 = scanner.nextInt();

                try {
                    controller.registerPruningOperation( Date.valueOf(input4), entry4);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }
}
