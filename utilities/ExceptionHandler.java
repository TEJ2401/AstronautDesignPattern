package utilities;

public class ExceptionHandler {
    // Catch and log exceptions, rethrow if necessary
    public static void handleException(Exception e) {
        LogManager.logError("An error occurred: ", e);
        throw new RuntimeException("An unexpected error occurred.", e);
    }
}

