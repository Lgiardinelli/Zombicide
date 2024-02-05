package zombicide;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Room} class represents a room in the Zombicide game.
 * Each room can have multiple doors.
 */
public class Room extends Area {
     /**
     * Constructs a room with the specified number of doors.
     * 
     * @param nbDoors The number of doors in the room.
     */
    public Room(int x, int y) {
    	super(x, y);
    }

	@Override
	public void  display(int n) {
		Door upDoor = getDoor(DoorDirection.UP);
		Door leftDoor = getDoor(DoorDirection.LEFT);
		
		if (n == 0) {
			System.out.print(upDoor.isOpen() ? "--  -" : "-----");
		}
		else if (n == 1){
			System.out.print(leftDoor.isOpen() ? "-    " : "|    ");
		}
		else {
			System.out.print(leftDoor.isOpen() ? "-    " : "|    ");
		}
	}
	
	@Override
	public String toString() {
		return "| . ";
	}
}

