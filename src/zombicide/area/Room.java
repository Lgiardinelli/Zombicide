package zombicide.area;

import java.util.HashMap;
import java.util.Map;

import zombicide.Area;
import zombicide.Door;
import zombicide.DoorDirection;

/**
 * The {@code Room} class represents a room in the Zombicide game.
 * Each room can have multiple doors.
 */
public class Room extends Area {	
	
	/**
	 * Constructs a room at the specified position.
	 *
	 * @param x The X-coordinate position of the room.
	 * @param y The Y-coordinate position of the room.
	 */
	public Room(int x, int y) {
	    super(x, y);
	    this.name = 'R';
	}


//	@Override
//	public void  display(int n) {
//		Door upDoor = getDoor(DoorDirection.UP);
//		Door leftDoor = getDoor(DoorDirection.LEFT);
//		
//		if (n == 0) {
//			System.out.print(upDoor.isOpen() ? OPEN_UP : "-----");
//		}
//		else if (n == 1){
//			System.out.print(leftDoor.isOpen() ? OPEN_LEFT1 : "|    ");
//		}
//		else {
//			System.out.print(leftDoor.isOpen() ? OPEN_LEFT2 : "|    ");
//		}
//	}
	
	@Override
	public String toString() {
		return "| . ";
	}
}

