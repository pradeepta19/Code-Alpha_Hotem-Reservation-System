public class Booking {
    private String bookingId;
    private String userName;
    private Room room;
    private String date;

    public Booking(String bookingId, String userName, Room room, String date) {
        this.bookingId = bookingId;
        this.userName = userName;
        this.room = room;
        this.date = date;
    }

    public String getBookingId() { return bookingId; }
    public String getUserName() { return userName; }
    public Room getRoom() { return room; }
    public String getDate() { return date; }

    @Override
    public String toString() {
        return bookingId + "," + userName + "," + room.getRoomId() + "," + room.getType() + "," + date;
    }
}

