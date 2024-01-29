package zombicide;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Room} class represents a room in the Zombicide game.
 * Each room can have multiple doors.
 */
public class Room extends Area {
    
    /**
     * An array of doors in the room.
     */
    private final Map<DoorDirection, Door> doors;
    
    /**
     * Constructs a room with the specified number of doors.
     * 
     * @param nbDoors The number of doors in the room.
     */
    public Room(int x, int y) {
    	super(x, y);
        this.doors = new HashMap<>();
        for (DoorDirection d : DoorDirection.values()) {
        	doors.put(d, null);
        }
    }
    
    /**
     * Gets the door at the specified index in the room.
     * 
     * @param index The index of the door to retrieve.
     * @return The door at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public Door getDoor(DoorDirection direction) {
        return this.doors.get(direction);
    }

	@Override
	public String toString() {
		return "";
	}
}

