package structural.adapter;

import java.util.Scanner;
import java.util.logging.Logger;

public class MainAdapterDemo {
    private static final Logger logger = Logger.getLogger(MainAdapterDemo.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            try {
                // Display menu options
                logger.info("Select a payment processing option:");
                logger.info("1. Process Payment with Legacy Payment Processor");
                logger.info("2. Process Payment with PayPal Adapter");
                logger.info("3. Exit");

                // Get user input
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: // Legacy Payment Processor
                        logger.info("Attempting to process payment using legacy payment processor...");
                        legacyPaymentProcessor.processPayment(100);
                        break;

                    case 2: // PayPal Adapter
                        logger.info("Attempting to process payment using PayPal adapter...");
                        payPalAdapter.processPayment(250);
                        break;

                    case 3: // Exit
                        exit = true;
                        logger.info("Exiting the program. Goodbye!");
                        break;

                    default:
                        logger.warning("Invalid choice. Please select a valid option.");
                }

                logger.info("\n-------------------\n");

            } catch (PaymentException e) {
                logger.severe("Error processing payment: " + e.getMessage());
            } catch (Exception e) {
                logger.severe("Unexpected error: " + e.getMessage());
                scanner.next(); // Clear the invalid input
            }
        }

        // Close the scanner
        scanner.close();
    }

    // Create instances of processors
    private static PaymentProcessor legacyPaymentProcessor = new LegacyPaymentProcessor();
    private static PaymentProcessor payPalAdapter = new PayPalAdapter();
}
