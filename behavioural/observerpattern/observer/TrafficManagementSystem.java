package observer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TrafficManagementSystem implements Observer {
    private static final Logger logger = Logger.getLogger(TrafficManagementSystem.class.getName());

    @Override
    public void update(String eventType, String roadLocation, String details) {
        logger.log(Level.INFO, "Road status change at {0}: {1}. {2}", new Object[]{roadLocation, eventType, details});
    }
}
