package utilities;

public class Validator {
    // Validates input and throws an exception if invalid
    public static void validateNotNull(Object obj, String name) {
        if (obj == null) {
            String message = name + " must not be null.";
            LogManager.logError(message, new IllegalArgumentException(message));
            throw new IllegalArgumentException(message);
        }
    }

    // Validates string input and throws an exception if invalid
    public static void validateStringNotEmpty(String str, String name) {
        if (str == null || str.trim().isEmpty()) {
            String message = name + " must not be empty.";
            LogManager.logError(message, new IllegalArgumentException(message));
            throw new IllegalArgumentException(message);
        }
    }
}

