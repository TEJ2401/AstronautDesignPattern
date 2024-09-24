package creational.factory;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProjectFactory projectFactory = new ProjectFactory();
        Logger logger = new Logger();
        ProjectTypeValidator validator = new ProjectTypeValidator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Project Initialization System");
        System.out.println("Available platforms: React, Vite, NextJS");
        boolean flag=true;
        while (flag) {
            System.out.print("Enter project type or 'exit' to quit: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                logger.log("Exiting the system.");
                break;
            }

            try {
                // Validate the project type
                validator.validate(input);
                logger.log("Creating project of type: " + input);

                Project project = projectFactory.createProject(input);
                project.createProject();
                project.installDependencies();
                project.startDevelopmentServer();
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage());
            }
        }

        scanner.close();
    }
}
