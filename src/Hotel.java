import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
        rooms.add(new Room("R101", "Standard", 1000));
        rooms.add(new Room("R102", "Deluxe", 2000));
        rooms.add(new Room("R103", "Suite", 3000));
    }

    public List<Room> getAvailableRooms() {
        List<Room> available = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isBooked()) {
                available.add(room);
            }
        }
        return available;
    }

    public Room findRoomById(String id) {
        for (Room room : rooms) {
            if (room.getRoomId().equalsIgnoreCase(id)) return room;
        }
        return null;
    }
}

