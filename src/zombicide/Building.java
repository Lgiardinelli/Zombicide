package zombicide;

import java.util.ArrayList;

public class Building {
	/** The width of the building */
	private int width;
	
	/** The height of the building */
	private int height;
	
	/** List of the room in the building */
	private List<Room> rooms;
	
	/**
	 * Constructor of the building with the specifed width and height
	 * @param width the width of the building 
	 * @param height the height of the building
	 */
	public Building(int width, int height) {
		this.width = width;
		this.height = height;
		this.rooms = new ArrayList<>();
		initBuilding();
	}
	
	/** initialize the room of the building */
	public void initBuilding() {
		
	}
	
}
