package command;

import utilities.ExceptionHandler;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            Light livingRoomLight = new Light();

            Command lightOn = new LightOnCommand(livingRoomLight);
            Command lightOff = new LightOffCommand(livingRoomLight);

            RemoteControl remote = new RemoteControl();
            Scanner scanner = new Scanner(System.in);
            boolean flag=true;
            while (flag) {
                System.out.println("Type 'on' to turn on the light, 'off' to turn it off, or 'exit' to quit:");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    break; // Exit the loop
                } else if (input.equalsIgnoreCase("on")) {
                    remote.setCommand(lightOn);
                    remote.pressButton();
                    logger.log(Level.INFO, "Light turned ON");
                } else if (input.equalsIgnoreCase("off")) {
                    remote.setCommand(lightOff);
                    remote.pressButton();
                    logger.log(Level.INFO, "Light turned OFF");
                } else {
                    System.out.println("Invalid command. Please type 'on', 'off', or 'exit'.");
                }
            }

            logger.log(Level.INFO, "Command execution stopped.");
            scanner.close(); // Close the scanner to free resources
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }
}
