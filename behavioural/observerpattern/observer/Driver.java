package observer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver implements Observer {
    private static final Logger logger = Logger.getLogger(Driver.class.getName());
    private final String name;

    public Driver(String name) {
        if (name == null || name.trim().isEmpty()) {
            logger.log(Level.SEVERE, "Driver name must not be empty");
            throw new IllegalArgumentException("Driver name must not be empty");
        }
        this.name = name;
    }

    @Override
    public void update(String eventType, String roadLocation, String details) {
        logger.log(Level.INFO, "Notifying driver {0}: {1} at {2}. {3}", new Object[]{name, eventType, roadLocation, details});
        // Reroute or take action based on road conditions.
    }
}
