public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        BookingManager manager = new BookingManager(hotel);
        manager.start();
    }
}
