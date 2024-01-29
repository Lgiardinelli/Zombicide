package zombicide;

/**
 * The {@code Room} class represents a room in the Zombicide game.
 * Each room can have multiple doors.
 */
public class Room extends Area {
    
    /**
     * An array of doors in the room.
     */
    private final Door[] doors;
    
    /**
     * Constructs a room with the specified number of doors.
     * 
     * @param nbDoors The number of doors in the room.
     */
    public Room(int x, int y, int nbDoors) {
    	super(x, y);
        this.doors = new Door[nbDoors];
        
        for (int i = 0; i < this.doors.length; i++) {
            this.doors[i] = new Door();
        }
    }
    
    /**
     * Gets the door at the specified index in the room.
     * 
     * @param index The index of the door to retrieve.
     * @return The door at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public Door getDoor(int index) {
        return this.doors[index];
    }

	@Override
	public String toString() {
		return "| . ";
	}
}

