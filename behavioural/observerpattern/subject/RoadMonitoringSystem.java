package subject;

import observer.Observer;

public interface RoadMonitoringSystem {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String eventType, String roadLocation, String details);
}
