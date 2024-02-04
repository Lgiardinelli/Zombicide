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
	public void  display() {
		Door upDoor = getDoor(DoorDirection.UP);
		Door leftDoor = getDoor(DoorDirection.LEFT);
		
		if (this.isTop == 0) {
			System.out.print(upDoor.isOpen() ? "--  -" : "-----");
			this.isTop = 1;
		}
		else if (this.isTop == 1){
			System.out.print(leftDoor.isOpen() ? "-    " : "|    ");
			this.isTop = 2;
		}
		else {
			System.out.print(leftDoor.isOpen() ? "-    " : "|    ");
			this.isTop = 0;
		}
	}
	
	@Override
	public String toString() {
		return "| . ";
	}
}

