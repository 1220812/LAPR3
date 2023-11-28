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
                SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date utilDate = null;
                while (utilDate == null) {
                    System.out.println("Please insert date of the operation: (DD-MM-YYYY)");
                    String inputDate = scanner.next();
                    try {
                        utilDate = inputFormat.parse(inputDate);
                    } catch (ParseException e) {
                        System.out.println("Inválid date, please insert a valid date in the format specified");
                    }
                }

                java.sql.Date dateSql = new java.sql.Date(utilDate.getTime());

                System.out.println("Please insert the id of the plantation where the operation was done");

                int entry = scanner.nextInt();

                try {
                    controller.registerSowingOperation( entry, dateSql);
                    System.out.println("Operation registered successfully");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                SimpleDateFormat inputFormat1 = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date utilDate1 = null;
                while (utilDate1 == null) {
                    System.out.println("Please insert date of the operation: (DD-MM-YYYY)");
                    String inputDate = scanner.next();
                    try {
                        utilDate1 = inputFormat1.parse(inputDate);
                    } catch (ParseException e) {
                        System.out.println("Inválid date, please insert a valid date in the format specified");
                    }
                }

                java.sql.Date dateSql1 = new java.sql.Date(utilDate1.getTime());
                System.out.println("Please insert the id of the plantation where the operation was done");

                int entry1 = scanner.nextInt();

                try {
                    controller.registerWeedOperation(entry1, dateSql1);
                    System.out.println("Operation registered successfully");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                SimpleDateFormat inputFormat2 = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date utilDate2 = null;
                while (utilDate2 == null) {
                    System.out.println("Please insert date of the operation: (DD-MM-YYYY)");
                    String inputDate = scanner.next();
                    try {
                        utilDate2 = inputFormat2.parse(inputDate);
                    } catch (ParseException e) {
                        System.out.println("Inválid date, please insert a valid date in the format specified");
                    }
                }

                java.sql.Date dateSql2 = new java.sql.Date(utilDate2.getTime());

                System.out.println("Please insert the id of the plantation where the operation was done");

                int entry2 = scanner.nextInt();

                System.out.println("Please Insert the quantity of the harvest:");

                int quantity = scanner.nextInt();

                try {
                    controller.registerHarvestOperation( dateSql2, entry2, quantity);
                    System.out.println("Operation registered successfully");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 4:
                SimpleDateFormat inputFormat3 = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date utilDate3 = null;
                while (utilDate3 == null) {
                    System.out.println("Please insert date of the operation: (DD-MM-YYYY)");
                    String inputDate = scanner.next();
                    try {
                        utilDate3 = inputFormat3.parse(inputDate);
                    } catch (ParseException e) {
                        System.out.println("Inválid date, please insert a valid date in the format specified");
                    }
                }

                java.sql.Date dateSql3 = new java.sql.Date(utilDate3.getTime());

                System.out.println("Please insert the id of the plantation where the operation was done");

                int entry3 = scanner.nextInt();

                System.out.println("Please insert the id of the product used in the fertilization");

                int id = scanner.nextInt();

                System.out.println("Please insert the mode of the fertilization (eg: solo)");

                String mode = scanner.nextLine();

                try {
                    controller.registerFertilizationOperation( dateSql3, entry3, id, mode);
                    System.out.println("Operation registered successfully");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 5:
                SimpleDateFormat inputFormat4 = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date utilDate4 = null;
                while (utilDate4 == null) {
                    System.out.println("Please insert date of the operation: (DD-MM-YYYY)");
                    String inputDate = scanner.next();
                    try {
                        utilDate4 = inputFormat4.parse(inputDate);
                    } catch (ParseException e) {
                        System.out.println("Inválid date, please insert a valid date in the format specified");
                    }
                }

                java.sql.Date dateSql4 = new java.sql.Date(utilDate4.getTime());

                System.out.println("Please insert the id of the plantation where the operation was done");

                int entry4 = scanner.nextInt();

                try {
                    controller.registerPruningOperation(dateSql4, entry4);
                    System.out.println("Operation registered successfully");

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
}
