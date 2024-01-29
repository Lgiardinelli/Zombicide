import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class City {
    private int width;
    private int height;
    private List<Street> streets;
    private Area[][] areas;

    public City(int width, int height) {
        this.width = width;
        this.height = height;
        this.streets = new ArrayList<>();
        this.areas = new Area[width][height];
        initCity();
    }

    
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
