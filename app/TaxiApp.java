package farecalculator1.app;

import farecalculator1.model.*;
import java.util.Scanner;

/**
 * Taxi Fare Calculator Application
 */
public class TaxiApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println(" Welcome to Taxi Fare Calculator ");
        System.out.println("==================================");

        while (true) {

            System.out.println("\nChoose Taxi Type:");
            System.out.println("1. Standard Taxi");
            System.out.println("2. Luxury Taxi");
            System.out.println("3. Bajaj Taxi");
            System.out.println("4. Exit");

            int choice = 0;
            while (true) {
                System.out.print("Enter choice: ");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice >= 1 && choice <= 4) {
                        break;
                    } else {
                        System.out.println("Choice must be 1-4. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Enter a number.");
                }
            }

            if (choice == 4) {
                System.out.println("Thank you for using Taxi Fare Calculator. Goodbye!");
                break;
            }

            Taxi taxi = null;

            // -----------------------------
            // Standard Taxi
            // -----------------------------
            if (choice == 1) {
                int stType = 0;
                while (true) {
                    System.out.println("Choose Standard Taxi type:");
                    System.out.println("1. Public");
                    System.out.println("2. Private");
                    System.out.print("Enter type: ");
                    try {
                        stType = Integer.parseInt(scanner.nextLine());
                        if (stType == 1 || stType == 2) {
                            break;
                        } else {
                            System.out.println("Invalid input! Enter 1 or 2.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Enter a number.");
                    }
                }

                if (stType == 1) {
                    taxi = new StandardTaxi(StandardTaxi.StandardType.PUBLIC);
                } else {
                    taxi = new StandardTaxi(StandardTaxi.StandardType.PRIVATE);
                }
            }

            // -----------------------------
            // Luxury Taxi
            // -----------------------------
            else if (choice == 2) {
                int ltType = 0;
                while (true) {
                    System.out.println("Choose Luxury Taxi company:");
                    System.out.println("1. YANGO (cheaper 5%)");
                    System.out.println("2. SEREGELA (cheaper 3%)");
                    System.out.println("3. RIDE (most expensive)");
                    System.out.print("Enter type: ");
                    try {
                        ltType = Integer.parseInt(scanner.nextLine());
                        if (ltType >= 1 && ltType <= 3) {
                            break;
                        } else {
                            System.out.println("Invalid input! Enter 1-3.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Enter a number.");
                    }
                }

                LuxuryTaxi.LuxuryType luxuryType;
                if (ltType == 1) luxuryType = LuxuryTaxi.LuxuryType.YANGO;
                else if (ltType == 2) luxuryType = LuxuryTaxi.LuxuryType.SEREGELA;
                else luxuryType = LuxuryTaxi.LuxuryType.RIDE;

                LuxuryTaxi luxuryTaxi = new LuxuryTaxi(luxuryType);

                double distance = 0;
                while (true) {
                    System.out.print("Enter distance in km: ");
                    try {
                        distance = Double.parseDouble(scanner.nextLine());
                        if (distance > 0) break;
                        else System.out.println("Distance must be positive!");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Enter a number.");
                    }
                }

                System.out.println("Press ENTER to start trip");
                scanner.nextLine();
                long startTime = System.currentTimeMillis();

                System.out.println("Trip started... Press ENTER to finish trip");
                scanner.nextLine();
                long endTime = System.currentTimeMillis();

                double tripTime = (endTime - startTime) / 60000.0; // minutes
                luxuryTaxi.setTripTime(tripTime);

                System.out.println("\n--- Trip Details ---");
                luxuryTaxi.displayTaxiInfo();
                System.out.println("Distance entered : " + distance);
                System.out.printf("Trip duration    : %.2f minutes\n", tripTime);
                System.out.printf("Total Fare       : %.2f ETB\n", luxuryTaxi.calculateFare(distance, tripTime));
                continue;
            }

            // -----------------------------
            // Bajaj Taxi
            // -----------------------------
            else if (choice == 3) {
                taxi = new BajajTaxi();
            }

            // -----------------------------
            // Distance & Time Input for Standard/Bajaj
            // -----------------------------
            double distance = 0, time = 0;

            while (true) {
                System.out.print("Enter distance in km: ");
                try {
                    distance = Double.parseDouble(scanner.nextLine());
                    if (distance > 0) break;
                    else System.out.println("Distance must be positive!");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Enter a number.");
                }
            }

            while (true) {
                System.out.print("Enter travel time in minutes: ");
                try {
                    time = Double.parseDouble(scanner.nextLine());
                    if (time > 0) break;
                    else System.out.println("Time must be positive!");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Enter a number.");
                }
            }

            System.out.println("\n--- Trip Details ---");
            taxi.displayTaxiInfo();
            System.out.println("Distance entered : " + distance);
            System.out.println("Time entered     : " + time + " minutes");
            System.out.printf("Total Fare       : %.2f ETB\n", taxi.calculateFare(distance, time));
        }

        scanner.close();
    }
}
