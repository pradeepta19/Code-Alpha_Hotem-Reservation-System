import java.util.Scanner;
import java.util.UUID;

public class BookingManager {
    private Hotel hotel;
    private Scanner scanner;

    public BookingManager(Hotel hotel) {
        this.hotel = hotel;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n1. View Available Rooms\n2. Book Room\n3. Cancel Room\n4. View All Bookings\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1 -> viewAvailableRooms();
                case 2 -> bookRoom();
                case 3 -> cancelRoom();
                case 4 -> scanner.tokens();
                case 5 -> {
                    System.out.println("Thank you for using our system!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void viewAvailableRooms() {
        var available = hotel.getAvailableRooms();
        if (available.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            System.out.println("Available Rooms:");
            for (Room room : available) {
                System.out.println(room.getRoomId() + " - " + room.getType() + " - ₹" + room.getPrice());
            }
        }
    }

    private void bookRoom() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        User user = new User(name);
        viewAvailableRooms();
        System.out.print("Enter Room ID to book: ");
        String roomId = scanner.nextLine();
        Room room = hotel.findRoomById(roomId);

        if (room == null || room.isBooked()) {
            System.out.println("Room unavailable.");
            return;
        }

        // Simulate payment
        System.out.println("Processing payment of ₹" + room.getPrice() + "...");
        System.out.println("Payment successful!");

        room.book();
        String bookingId = UUID.randomUUID().toString().substring(0, 8);
        System.out.print("Enter date (DD-MM-YYYY): ");
        String date = scanner.nextLine();
        Booking booking = new Booking(bookingId, user.getName(), room, date);
        FileHandler.saveBooking(booking);
        System.out.println("Booking successful! ID: " + bookingId);
    }

    private void cancelRoom() {
        System.out.print("Enter Room ID to cancel: ");
        String roomId = scanner.nextLine();
        Room room = hotel.findRoomById(roomId);
        if (room != null && room.isBooked()) {
            room.cancel();
            System.out.println("Booking cancelled.");
        } else {
            System.out.println("Invalid or unbooked room.");
        }
    }
}

