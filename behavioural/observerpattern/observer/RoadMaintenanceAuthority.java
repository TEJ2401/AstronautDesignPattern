package observer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RoadMaintenanceAuthority implements Observer {
    private static final Logger logger = Logger.getLogger(RoadMaintenanceAuthority.class.getName());

    @Override
    public void update(String eventType, String roadLocation, String details) {
        logger.log(Level.INFO, "{0} at {1}: {2}", new Object[]{eventType, roadLocation, details});
    }
}
