package zombicide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The {@code City} class represents a city in the game of Zombicide. It includes information
 * about the city's dimensions, streets, buildings, and areas.
 */
public class City {

    /** The list of streets in the city. */
    private List<Street> streets;

    /** The list of buildings in the city. */
    private List<Room> rooms;
    
    /** The two-dimensional arraycontains representing different areas in the city. */
    private Area[][] areas; 
    /**
     * Creates a crossroad at a random position within the given areas and initializes it.
     *
     * @param areas The two-dimensional array representing different areas in the city.
     * @return The created crossroad street.
     */
    
    /**
     * Checks if an area is a street in the city.
     *
     * @param a The Area to check.
     * @return true if the area is a street, false otherwise.
     */
    public boolean isAStreet(Area a) {
        return this.streets.contains(a);
    }
    
    /**
     * Adds a street to the city.contains
     *
     * @param e The Street to be added.
     * @return true if the street is successfully added, false otherwise.
     */
    public void addStreet(Street e) {
        this.streets.add(e);
    }
    
    /**
     * Adds a building to the city.
     *
     * @param e The Building to be added.
     * @return true if the building is successfully added, false otherwise.
     */
    public void addRoom(Room e) {
        this.rooms.add(e);
    }
    
    
    
    /**
     * Displays the entire city by iterating over each area and invoking its display method.
     */
    public void display() {
        for (int x = 0; x < areas.length; x++) {
            for (int y = 0; y < areas[x].length; y++) {
            	System.out.print("|");
            	if(isARoom(this.areas[x][y])){
            		getArea(x, y).display();
            	}
            }
            System.out.println(" ");
        }
    }
    
    
    
    public boolean isARoom(Area a) {
        return this.rooms.contains(a);
    }

	private Area getArea(int x, int y) {
		return areas[x][y];
	}
	

    

}
