package zombicide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zombicide.actor.*;

/**
 * Abstract class representing an area in the game.
 */
public abstract class Area {
    /**
     * The string representation for an open door in the up direction.
     */
    protected static final String OPEN_UP = "-    ";

    /**
     * The string representation for an open door in the left direction.
     */
    protected static final String OPEN_LEFT = "-    ";

    /**
     * The X position of the area.
     */
    private int posX;

    /**
     * The Y position of the area.
     */
    private int posY;

    /**
     * The list of survivors in the area.
     */
    private List<Survivor> survivors;

    /**
     * The list of zombies in the area.
     */
    private List<Zombie> zombies;

    /**
     * The noise level of the area.
     */
    private int noise;

    /**
     * Flag indicating if the area is on the top layer.
     */
    protected int isTop;

    /**
     * Map containing doors in different directions.
     */
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
        this.isTop = 0;
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
    	
    }
}
