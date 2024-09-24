
package creational.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class RoomAvailabilityManager {
    private static RoomAvailabilityManager instance;
    private Map<String, Boolean> roomAvailability; 
    private static final Logger logger = Logger.getLogger(RoomAvailabilityManager.class.getName());

    // Private constructor
    private RoomAvailabilityManager() {
        roomAvailability = new HashMap<>();
        // Initialize rooms as available
        roomAvailability.put("Room101", true);
        roomAvailability.put("Room102", true);
        roomAvailability.put("Room103", true);
    }

    // Public static method to get the single instance
    public static RoomAvailabilityManager getInstance() {
        if (instance == null) {
            synchronized (RoomAvailabilityManager.class) {
                if (instance == null) {
                    instance = new RoomAvailabilityManager();
                }
            }
        }
        return instance;
    }

    // Method to check room availability
    public synchronized boolean isRoomAvailable(String roomID) {
        return roomAvailability.getOrDefault(roomID, false);
    }

    // Method to book a room
    public synchronized boolean bookRoom(String roomID) {
        if (isRoomAvailable(roomID)) {
            roomAvailability.put(roomID, false); // Mark room as booked
            logger.info("Room " + roomID + " has been successfully booked.");
            return true;
        } else {
            logger.warning("Room " + roomID + " is already booked.");
            return false;
        }
    }

    // Method to release a room (when user cancels or checks out)
    public synchronized void releaseRoom(String roomID) {
        roomAvailability.put(roomID, true); // Mark room as available
        logger.info("Room " + roomID + " is now available.");
    }
}
