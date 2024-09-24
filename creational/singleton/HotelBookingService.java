package creational.singleton;

import java.util.HashMap;
import java.util.Map;

public class HotelBookingService {
    // Singleton instance
    private static HotelBookingService instance;

    // A map to hold the bookings
    private final Map<String, Booking> bookings;

    // Private constructor
    private HotelBookingService() {
        bookings = new HashMap<>();
    }

    // Method to get the singleton instance
    public static HotelBookingService getInstance() {
        if (instance == null) {
            instance = new HotelBookingService();
        }
        return instance;
    }

    // Method to book a room
    public void bookRoom(String guestName, String roomNumber, double price) {
        RoomAvailabilityManager availabilityManager = RoomAvailabilityManager.getInstance();
        
        if (availabilityManager.bookRoom(roomNumber)) {
            bookings.put(roomNumber, new Booking(guestName, roomNumber, price));
            System.out.println("Room " + roomNumber + " booked for " + guestName + " at $" + price);
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    // Method to cancel a booking
    public void cancelBooking(String roomNumber) {
        if (bookings.containsKey(roomNumber)) {
            bookings.remove(roomNumber);
            RoomAvailabilityManager.getInstance().releaseRoom(roomNumber); // Release room in the manager
            System.out.println("Booking for " + roomNumber + " has been cancelled.");
        } else {
            System.out.println("No booking found for " + roomNumber);
        }
    }

    // Inner class to represent a booking
    private static class Booking {
        private final String guestName;
        private final String roomNumber;
        private final double price;

        public Booking(String guestName, String roomNumber, double price) {
            this.guestName = guestName;
            this.roomNumber = roomNumber;
            this.price = price;
        }
    }
}
