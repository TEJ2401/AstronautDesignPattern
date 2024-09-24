package project_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ScheduleManager extends Subject {
    private static final Logger logger = Logger.getLogger(ScheduleManager.class.getName());
    private static ScheduleManager instance;
    private List<Task> tasks;

    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    // Singleton pattern with defensive instantiation
    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    // Task validation method
    private void validateTask(Task task) throws TaskException {
        if (task == null) {
            throw new TaskException("Task cannot be null.");
        }
        if (task.getStartTime() == null || task.getEndTime() == null) {
            throw new TaskException("Task start or end time cannot be null.");
        }
        if (task.getStartTime().isAfter(task.getEndTime())) {
            throw new TaskException("Task start time cannot be after the end time.");
        }
        if (task.getDescription() == null || task.getDescription().isEmpty()) {
            throw new TaskException("Task description cannot be null or empty.");
        }
        logger.info("Task validated successfully: " + task.getDescription());
    }

    // Add a task after validation and conflict check
    public boolean addTask(Task task) {
        try {
            validateTask(task); // Defensive check
            if (checkConflict(task)) {
                notify("Error: Task conflicts with existing task.");
                return false;
            }
            tasks.add(task);
            tasks.sort(Comparator.comparing(Task::getStartTime)); // Sort only after successful addition
            logger.info("Task added: " + task.getDescription());
            return true;
        } catch (TaskException e) {
            logger.log(Level.SEVERE, "Error adding task: " + e.getMessage(), e);
            notify("Error adding task: " + e.getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error occurred: " + e.getMessage(), e);
            notify("An unexpected error occurred.");
        }
        return false;
    }

    // Remove a task by description
    public boolean removeTask(String description) {
        try {
            if (description == null || description.isEmpty()) {
                throw new TaskException("Description cannot be null or empty.");
            }
            boolean removed = tasks.removeIf(task -> task.getDescription().equals(description));
            if (!removed) {
                notify("Error: Task not found.");
                logger.warning("Attempted to remove non-existent task: " + description);
            } else {
                logger.info("Task removed: " + description);
            }
            return removed;
        } catch (TaskException e) {
            logger.log(Level.SEVERE, "Error removing task: " + e.getMessage(), e);
            notify("Error removing task: " + e.getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error: " + e.getMessage(), e);
            notify("An unexpected error occurred.");
        }
        return false;
    }

    // View all tasks
    public List<Task> viewTasks() {
        logger.info("Viewing all tasks");
        return new ArrayList<>(tasks);
    }

    // Check for task conflicts
    private boolean checkConflict(Task newTask) {
        return tasks.stream().anyMatch(task ->
                newTask.getStartTime().isBefore(task.getEndTime()) &&
                newTask.getEndTime().isAfter(task.getStartTime()));
    }

    // Edit an existing task
    public boolean editTask(String oldDescription, Task newTask) {
        try {
            validateTask(newTask); // Defensive check
            for (int i = 0; i < tasks.size(); i++) {
                Task currentTask = tasks.get(i);
                if (currentTask.getDescription().equals(oldDescription)) {
                    // Remove task temporarily to check for conflicts
                    tasks.remove(i);

                    if (checkConflict(newTask)) {
                        tasks.add(i, currentTask);  // Revert if conflict found
                        notify("Error: New task conflicts with existing tasks.");
                        return false;
                    }

                    tasks.add(i, newTask); // Add and sort after editing
                    tasks.sort(Comparator.comparing(Task::getStartTime));
                    logger.info("Task edited: " + oldDescription + " -> " + newTask.getDescription());
                    return true;
                }
            }
            notify("Error: Task not found.");
        } catch (TaskException e) {
            logger.log(Level.SEVERE, "Error editing task: " + e.getMessage(), e);
            notify("Error editing task: " + e.getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error: " + e.getMessage(), e);
            notify("An unexpected error occurred.");
        }
        return false;
    }

    // Mark a task as completed
    public boolean markTaskCompleted(String description) {
        try {
            Optional<Task> taskOpt = tasks.stream()
                    .filter(task -> task.getDescription().equals(description))
                    .findFirst();

            if (taskOpt.isPresent()) {
                Task task = taskOpt.get();
                task.setCompleted(true);
                logger.info("Task marked completed: " + description);
                return true;
            } else {
                notify("Error: Task not found.");
                logger.warning("Task not found to mark completed: " + description);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error: " + e.getMessage(), e);
            notify("An unexpected error occurred.");
        }
        return false;
    }

    // View tasks by priority
    public List<Task> viewTasksByPriority(String priority) {
        try {
            List<Task> filteredTasks = tasks.stream()
                    .filter(task -> task.getPriority().equalsIgnoreCase(priority))
                    .collect(Collectors.toList());

            if (filteredTasks.isEmpty()) {
                notify("No tasks found with priority: " + priority);
                logger.info("No tasks found with priority: " + priority);
            } else {
                logger.info("Viewing tasks by priority: " + priority);
            }

            return filteredTasks;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error viewing tasks by priority: " + e.getMessage(), e);
            notify("Error viewing tasks by priority.");
            return new ArrayList<>();
        }
    }
}
