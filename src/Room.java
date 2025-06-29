public class Room {
    private String roomId;
    private String type;
    private double price;
    private boolean isBooked;

    public Room(String roomId, String type, double price) {
        this.roomId = roomId;
        this.type = type;
        this.price = price;
        this.isBooked = false;
    }

    public String getRoomId() { return roomId; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public boolean isBooked() { return isBooked; }

    public void book() { this.isBooked = true; }
    public void cancel() { this.isBooked = false; }
}

