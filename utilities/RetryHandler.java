package utilities;

public class RetryHandler {
    public static void retry(Runnable task, int retries) {
        int attempts = 0;
        while (attempts < retries) {
            try {
                task.run();
                return;
            } catch (Exception e) {
                attempts++;
                if (attempts >= retries) {
                    Logger.logError("Task Failed", "Max retries reached: " + e.getMessage());
                }
            }
        }
    }
}
