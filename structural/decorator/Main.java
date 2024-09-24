package structural.decorator;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            try {
                // Display menu options
                logger.info("Select a car configuration:");
                logger.info("1. Basic Car");
                logger.info("2. Luxury Car");
                logger.info("3. Sport Car");
                logger.info("4. Exit");

                // Get user input
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: // Basic Car
                        Car basicCar = new BasicCar();
                        logger.info("Configuration 1:");
                        logger.info("Description: " + basicCar.getDescription());
                        logger.info("Total Cost: $" + basicCar.getCost());
                        break;

                    case 2: // Luxury Car
                        Car luxuryCar = new LeatherSeats(new NavigationSystem(new SunRoof(new BasicCar())));
                        logger.info("Configuration 2 (Luxury):");
                        logger.info("Description: " + luxuryCar.getDescription());
                        logger.info("Total Cost: $" + luxuryCar.getCost());
                        break;

                    case 3: // Sport Car
                        Car sportCar = new SportPackage(new NavigationSystem(new BasicCar()));
                        logger.info("Configuration 3 (Sport):");
                        logger.info("Description: " + sportCar.getDescription());
                        logger.info("Total Cost: $" + sportCar.getCost());
                        break;

                    case 4: // Exit
                        exit = true;
                        logger.info("Exiting the program. Goodbye!");
                        break;

                    default:
                        logger.warning("Invalid choice. Please select a valid option.");
                }

                logger.info("\n-------------------\n");

            } catch (Exception e) {
                logger.log(Level.SEVERE, "An error occurred: " + e.getMessage());
                scanner.next(); // Clear the invalid input
            }
        }

        // Close the scanner
        scanner.close();
    }
}
