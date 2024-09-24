package project_2;


import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements Observer {
    private ScheduleManager scheduleManager;
    private Scanner scanner;

    public ConsoleUI() {
        this.scheduleManager = ScheduleManager.getInstance();
        this.scheduleManager.attach(this);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void update(String message) {
        System.out.println(message);
    }

    public void run() throws TaskException {
        while (true) {
            System.out.println("\nAstronaut Daily Schedule Organizer");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Edit Task");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. View Tasks by Priority");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    removeTask();
                    break;
                case "3":
                    viewTasks();
                    break;
                case "4":
                    editTask();
                    break;
                case "5":
                    markTaskCompleted();
                    break;
                case "6":
                    viewTasksByPriority();
                    break;
                case "7":
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addTask() throws TaskException {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter start time (HH:mm): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:mm): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter priority (High/Medium/Low): ");
        String priority = scanner.nextLine();

        try {
            Task task = TaskFactory.createTask(description, startTime, endTime, priority);
            scheduleManager.addTask(task);
            System.out.println("Task added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void removeTask() throws TaskException {
        System.out.print("Enter task description to remove: ");
        String description = scanner.nextLine();
        scheduleManager.removeTask(description);
        System.out.println("Task removed successfully.");
    }

    private void viewTasks() {
        List<Task> tasks = scheduleManager.viewTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private void editTask() throws TaskException {
        System.out.print("Enter the description of the task to edit: ");
        String oldDescription = scanner.nextLine();
        System.out.print("Enter new task description: ");
        String newDescription = scanner.nextLine();
        System.out.print("Enter new start time (HH:mm): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter new end time (HH:mm): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter new priority (High/Medium/Low): ");
        String priority = scanner.nextLine();

        Task newTask = TaskFactory.createTask(newDescription, startTime, endTime, priority);
        scheduleManager.editTask(oldDescription, newTask);
        System.out.println("Task edited successfully.");
    }

    private void markTaskCompleted() throws TaskException {
        System.out.print("Enter the description of the task to mark as completed: ");
        String description = scanner.nextLine();
        scheduleManager.markTaskCompleted(description);
        System.out.println("Task marked as completed.");
    }

    private void viewTasksByPriority() {
        System.out.print("Enter priority level to view (High/Medium/Low): ");
        String priority = scanner.nextLine();
        List<Task> tasks = scheduleManager.viewTasksByPriority(priority);
        if (tasks.isEmpty()) {
            System.out.println("No tasks found with priority level: " + priority);
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}

