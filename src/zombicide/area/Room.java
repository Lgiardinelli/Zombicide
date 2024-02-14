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

}

