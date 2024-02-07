package zombicide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zombicide.actor.*;

public abstract class Area {
	
	protected static final String OPEN_UP = "¤    ";
	protected static final String OPEN_LEFT = "-    ";
	
	private int posX;
	private int posY;
	private List<Survivor> survivors;
	private List<Zombie> zombies;
	private int noise;
	protected int isTop;
    protected final Map<DoorDirection, Door> doors;
	
	/**
	 * Constructor of area
	 * @param posX - int - the position X of this Cell
	 * @param posY - int - the position Y of this Cell
	 */
	public Area(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;		// TODO Auto-generated method stubY;
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
     * Gets the door at the specified index in the room.
     * 
     * @param index The index of the door to retrieve.
     * @return The door at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public Door getDoor(DoorDirection direction) {
        return this.doors.get(direction);
    }
    
    public Map<DoorDirection, Door> getDoors() {
    	return doors;
    }
     
	/**
	* Adds a door to the room at the specified direction.
	* 
	* @param direction The direction to add the door.
	*/
	
	public void addDoor(DoorDirection direction, Door door) {
		doors.put(direction, door);
	}
	
	/**
	 * Get the position X
	 * @return int 
	 */
	public int getX() {
		return this.posX;
	}
	
	/**
	 * Get the position		// TODO Auto-generated method stub Y
	 * @return int 
	 */
	public int getY() {
		return this.posY;
	}
	
	/**
	 * the cell accepts the fight or not
	 * @return true if there can be a fight no otherwise
	 */
	public boolean canFight() {
		return true;
	}
	
	protected void display() {	
	}
	
	protected void display(int n) {	
	}
}
