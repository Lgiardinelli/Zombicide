package zombicide.area;

import zombicide.Area;

/**
 * The {@code Room} class represents a room in the Zombicide game.
 * Each room can have multiple doors.
 */
public class Room extends Area {
	private static final char name = 'R';
	
	/**
	 * Constructs a room at the specified position.
	 *
	 * @param x The X-coordinate position of the room.
	 * @param y The Y-coordinate position of the room.
	 */
	public Room(int x, int y) {
	    super(x, y);
	}

	@Override
	protected String getName() {
		return "" + name;
	}

//	@Override
//	public void display(int n) {
//		if (n == 0) {
//			System.out.print(this.getDoor(DoorDirection.UP).isOpen() ? OPEN_UP : "-----");
//		} else if (n == 1) {
//			System.out.print("  " + name + "   ");
//		} else {
//			System.out.print("      ");
//		}
//	}

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
	
//	@Override
//	public String toString() {
//		return "| . ";
//	}
}

