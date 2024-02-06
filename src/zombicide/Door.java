package zombicide;

/**
 * Door class
 * 
 * Represents a door on the board
 */
public class Door {
	private boolean isOpen;

	/**
	 * Constructor for Door
	 */
	public Door() {
		isOpen = true;
	}
	
	/**
	 * Open the door
	 */
	public void open() {
		isOpen = true;
	}
	
	/**
	 * Close the door
	 */
	public void close() {
		isOpen = false;
	}
	
	/**
	 * Check if the door is open
	 * 
	 * @return true if the door is open, false otherwise
	 */
	public boolean isOpen() {
		return isOpen;
	}
}
