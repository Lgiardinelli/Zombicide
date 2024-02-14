package zombicide.area;

import zombicide.Area;

/**
 * The {@code Room} class represents a room in the Zombicide game.
 * Each room can have multiple doors.
 */
public class Room extends Area {
	private static final char name = 'R';
	private int nbZombies;

	private int nbSurvivors;
	
	/**
	 * Constructs a room at the specified position.
	 *
	 * @param x The X-coordinate position of the room.
	 * @param y The Y-coordinate position of the room.
	 */
	public Room(int x, int y) {
		super(x, y);
		this.nbZombies = 0;
		this.nbSurvivors = 0;
	}

	@Override
	protected String getName() {
		return "" + name;
	}

	@Override
	protected int getNbSurvivors() {
		return this.nbSurvivors;
	}

	@Override
	protected int getNbZombies() {
		return this.nbZombies;
	}

}

