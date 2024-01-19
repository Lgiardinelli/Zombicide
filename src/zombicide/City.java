package zombicide;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code City} class represents a city in the game of Zombicide. It includes information
 * about the city's dimensions, streets, buildings, and areas.
 */
public class City {

    /** The width of the city. */
    private int width;

    /** The height of the city. */
    private int height;

    /** The list of streets in the city. */
    private List<Street streets;

    /** The list of buildings in the city. */
    private List<Building> buildings;

    /** The list of areas in the city. */
    private Area[][] areas;

    /**
     * Constructs a new City with the specified width and height.
     *
     * @param width  The width of the city.
     * @param height The height of the city.
     */
    public City(int width, int height) {
        this.width = width;
        this.height = height;
        this.streets = new ArrayList<>();
        this.buildings = new ArrayList<>();
        this.areas = new ArrayList<>();
        initCity();
    }
    
    /**
     * Creates an empty city by initializing all areas as streets.
     * This method populates the city with streets at each coordinate.
     */
    public void createEmptyCity() {
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                areas[x][y] = new Street(x, y);
            }
        }
    }

    
    /**
     * Adds a street to the city.
     *
     * @param e The Street to be added.
     * @return true if the street is successfully added, false otherwise.
     */
    public boolean addStreet(Street e) {
        return streets.add(e);
    }
    
    /**
     * Adds a building to the city.
     *
     * @param e The Building to be added.
     * @return true if the building is successfully added, false otherwise.
     */
    public boolean addBuilding(Building e) {
        return buildings.add(e);
    }
    
    /**
     * Checks if an area is a street in the city.
     *
     * @param a The Area to check.
     * @return true if the area is a street, false otherwise.
     */
    public boolean isAStreet(Area a) {
        return streets.contains(a);
    }
    
    

}
