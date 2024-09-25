package creational.singleton;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelBookingService bookingService = HotelBookingService.getInstance();
        PaymentGateway paymentGateway = PaymentGateway.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHotel Booking System:");
            System.out.println("1. Book a room");
            System.out.println("2. Cancel a booking");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("3") || option.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the booking system. Goodbye!");
                break;
            }

            switch (option) {
                case "1": // Book a room
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter room number (e.g., Room101): ");
                    String roomNumber = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    // Simulate payment process
                    if (paymentGateway.processPayment(guestName, price)) {
                        bookingService.bookRoom(guestName, roomNumber, price);
                    } else {
                        System.out.println("Payment failed. Booking not completed.");
                    }
                    break;

                case "2": // Cancel a booking
                    System.out.print("Enter room number to cancel booking: ");
                    roomNumber = scanner.nextLine();
                    bookingService.cancelBooking(roomNumber);
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
        scanner.close();
    }
}
