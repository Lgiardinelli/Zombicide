package zombicide;

public class Door {
	private boolean isOpen;

	public Door() {
		isOpen = false;
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
	
	public boolean isOpen() {
		return isOpen;
	}
}
