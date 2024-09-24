package subject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import observer.Observer;

public class CityRoadMonitor implements RoadMonitoringSystem {
    private static final Logger logger = Logger.getLogger(CityRoadMonitor.class.getName());
    private final List<Observer> observers = new ArrayList<>();
    private int roadHealth;
    private final String roadLocation;

    public CityRoadMonitor(String roadLocation) {
        this.roadLocation = roadLocation;
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
            logger.log(Level.INFO, "Observer added: {0}", observer.getClass().getSimpleName());
        } else {
            logger.log(Level.SEVERE, "Attempted to add a null observer to the monitoring system.");
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        logger.log(Level.INFO, "Observer removed: {0}", observer.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers(String eventType, String roadLocation, String details) {
        for (Observer observer : observers) {
            try {
                observer.update(eventType, roadLocation, details);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Failed to notify observer: {0}", e.getMessage());
            }
        }
    }

    public void setRoadHealth(int health) {
        if (health >= 0 && health <= 100) {
            this.roadHealth = health;
            assessRoadHealth();
        } else {
            logger.log(Level.SEVERE, "The provided road health value is out of bounds: {0}", health);
        }
    }

    private void assessRoadHealth() {
        if (roadHealth < 30) {
            notifyObservers("Road in Critical Condition", roadLocation, "Road strength at " + roadHealth + "%");
        } else if (roadHealth < 60) {
            notifyObservers("Road Needs Attention", roadLocation, "Road strength at " + roadHealth + "%");
        } else {
            logger.log(Level.INFO, "Road condition at {0} is good at {1}%.", new Object[]{roadLocation, roadHealth});
        }
    }
}
