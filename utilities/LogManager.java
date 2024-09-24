    package utilities;

    import java.util.logging.Level;
    import java.util.logging.Logger;

    public class LogManager {
        private static final Logger logger = Logger.getLogger(LogManager.class.getName());

        // Log an info message
        public static void logInfo(String message) {
            logger.info(message);
        }

        // Log a warning message
        public static void logWarning(String message) {
            logger.warning(message);
        }

        // Log an error message with an exception
        public static void logError(String message, Exception e) {
            logger.log(Level.SEVERE, message, e);
        }
    }
