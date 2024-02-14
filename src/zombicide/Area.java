package zombicide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zombicide.actor.*;
import zombicide.util.Color;

/**
 * Abstract class representing an area in the game.
 */
public abstract class Area {
    private static int nbZombies = 0;
    private static int nbSurvivors = 0;
    protected static final String resetColorCode = Color.RESET.getCode();
    protected static final String blackColorCode = Color.BLACK.getCode();
    private final String OPEN_UP = "-     ";
	private final String CLOSE_UP = "------";
    private final String OPEN_LEFT1 = " " + getName() + " Z" + getNbZombies() + " ";
    private final String CLOSE_LEFT1 = "|" + getName() + " Z" + getNbZombies() + " ";
    private final String OPEN_LEFT2 = "  " + " S" + getNbSurvivors() + " ";
    private final String CLOSE_LEFT2 = "| " + " S" + getNbSurvivors() + " ";

    private int posX;
    private int posY;
    private List<Survivor> survivors;
    private List<Zombie> zombies;
    private int noise;
    protected final Map<DoorDirection, Door> doors;

    /**
     * Constructor for the Area class.
     * 
     * @param posX The X position of the area.
     * @param posY The Y position of the area.
     */
    public Area(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.survivors = new ArrayList<>();
        this.zombies = new ArrayList<>();
        this.noise = 0;
        this.doors = new HashMap<>();
        for (DoorDirection d : DoorDirection.values()) {
            doors.put(d, new Door());
        }
    }

    /**
     * Retrieves the door in the specified direction.
     * 
     * @param direction The direction of the door.
     * @return The door in the specified direction.
     */
    public Door getDoor(DoorDirection direction) {
        return this.doors.get(direction);
    }

    /**
     * Retrieves all doors in the area.
     * 
     * @return Map containing all doors in the area.
     */
    public Map<DoorDirection, Door> getDoors() {
        return doors;
    }

    /**
     * Adds a door to the area in the specified direction.
     * 
     * @param direction The direction of the door.
     * @param door The door to add.
     */
    public void addDoor(DoorDirection direction, Door door) {
        doors.put(direction, door);
    }

    /**
     * Retrieves the X position of the area.
     * 
     * @return The X position of the area.
     */
    public int getX() {
        return this.posX;
    }

    /**
     * Retrieves the Y position of the area.
     * 
     * @return The Y position of the area.
     */
    public int getY() {
        return this.posY;
    }

    /**
     * Checks if fighting is possible in the area.
     * 
     * @return true if fighting is possible, false otherwise.
     */
    public boolean canFight() {
        return true;
    }

    /**
     * Abstract method to display the area.
     */
    protected void display() {
    }

    /**
     * Abstract method to display the area with specific parameters.
     * 
     * @param n Specific parameters for displaying the area.
     */
    protected void display(int n) {
    	if (n == 0) {
			System.out.print(this.getDoor(DoorDirection.UP).isOpen() ? OPEN_UP : CLOSE_UP);
    	}
    	else if (n == 1) {
    		System.out.print(this.getDoor(DoorDirection.LEFT).isOpen() ? OPEN_LEFT1 : CLOSE_LEFT1);
    	}
    	else {
    		System.out.print(this.getDoor(DoorDirection.LEFT).isOpen() ? OPEN_LEFT2 : CLOSE_LEFT2);
    	}
    }

    abstract protected String getName();

    abstract protected int getNbZombies();

    abstract protected int getNbSurvivors();

}
