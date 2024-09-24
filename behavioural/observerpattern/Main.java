import observer.Driver;
import observer.RoadMaintenanceAuthority;
import observer.TrafficManagementSystem;
import subject.CityRoadMonitor;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final Random random = new Random();

    public static void main(String[] args) {
        CityRoadMonitor roadMonitor = new CityRoadMonitor("Highway 21");

        RoadMaintenanceAuthority maintenanceAuthority = new RoadMaintenanceAuthority();
        Driver driver1 = new Driver("Alice");
        Driver driver2 = new Driver("Bob");
        TrafficManagementSystem trafficSystem = new TrafficManagementSystem();

        roadMonitor.addObserver(maintenanceAuthority);
        roadMonitor.addObserver(driver1);
        roadMonitor.addObserver(driver2);
        roadMonitor.addObserver(trafficSystem);

        logger.log(Level.INFO, "Monitoring: Start monitoring for Highway 21.");

        Scanner scanner = new Scanner(System.in);
        boolean flag=true;
        // Infinite loop to simulate ongoing road health changes
        while (flag) {
            // Generate a random road health value between 0 and 100
            int health = random.nextInt(101);
            roadMonitor.setRoadHealth(health);

            // Log the current health value
            logger.log(Level.INFO, "Current road health: " + health + "%");

            // Prompt user for exit
            System.out.println("Type 'exit' to stop monitoring or press Enter to continue...");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break; // Exit the loop
            }

            // Sleep for a while before the next update (e.g., 3 seconds)
            try {
                Thread.sleep(3000); // Pause for 3 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore the interrupted status
                logger.log(Level.SEVERE, "Thread was interrupted", e);
            }
        }

        logger.log(Level.INFO, "Monitoring stopped.");
        scanner.close(); // Close the scanner to free resources
    }
}
