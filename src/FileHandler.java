import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String FILE_NAME = "bookings.txt";

    public static void saveBooking(Booking booking) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(booking.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving booking.");
        }
    }

    public static void showAllBookings() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nAll Bookings:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line.replace(",", " | "));
            }
        } catch (IOException e) {
            System.out.println("No bookings found.");
        }
    }
}

