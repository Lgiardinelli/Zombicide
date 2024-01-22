package zombicide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private List<Street> streets;

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
        initCity();
    }
    
    /**
     * Gets the area at the specified coordinates in the city.
     *
     * @param x The x-coordinate of the area.
     * @param y The y-coordinate of the area.a
     * @return The area at the specified coordinates.
     */
    public Area getArea(int x, int y) {
        return this.areas[x][y];
    }

    
    /**
     * Creates an city by initializing all areas.
     * This method populates the city with streets at each coordinate.
     */
    public void createCity() {
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                areas[x][y] = new Area(x, y);
            }
        }
    }
    
    /**
     * Checks if the city can be split, i.e., if there are splitable areas present.
     *
     * @return True if the city can be split, otherwise false.
     */
    public boolean canBeSplit() {
        for (int x = 0; x <= this.width; x++) {
            for (int y = 0; y <= this.height; y++) {
                if (presentSplitableArea(areas[x][y])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    
    /**
     * Splits the city by spawning crossroads until it can no longer be split.
     * Crossroads are spawned in splitable areas within the city.
     */
    public void splitCity() {
        while (canBeSplit()) {
            spawnCrossroad();
        }
    }
    
    
    
    /**
     * Spawns a crossroad in a splitable area within the city.
     * The crossroad is randomly placed within the available range of the splitable area.
     */
    public void spawnCrossroad() {
        Random random = new Random();
        for (int x = 0; x <= this.width; x++) {
            for (int y = 0; y <= this.height; y++) {
                if (presentSplitableArea(areas[x][y])) {
                    int a = availableRange(areas[x][y])[0];
                    int b = availableRange(areas[x][y])[1];
                    a = random.nextInt((a+2) - (a-2) + 1) + (a-2);
                    b = random.nextInt((b+2) - (b-2) + 1) + (b-2);
                    areas[x + a][y + b] = new Street(x + a, y + b);
                }
            }
        }
    }
    
    
    
    
    /**
     * Checks if the specified area is splitable, considering both right and down directions.
     *
     * @param a The area to check for splitability.
     * @return True if the area is splitable, otherwise false.
     */
    public boolean presentSplitableArea(Area a) {
        int x = a.getX();
        int y = a.getY();
        return rightSplitable(areas[x][y]) && downSplitable(areas[x][y]);
    }
    
    
    
    
    
    
    /**
     * Checks if the four consecutive areas to the right of the specified area are of type Area.
     *
     * @param a The area to check.
     * @return True if the consecutive areas to the right are of type Area, otherwise false.
     */
    public boolean rightSplitable(Area a) {
    	int x = a.getX();
        int y = a.getY();
        for (int i = 0; i <= 4; i++) {
            if (!isAStreet(this.areas[x + i][y])) {
                return false;
            }
        }
        return true;
    }

    
    
    
    /**
     * Checks if the four consecutive areas below the specified area are of type Area.
     *
     * @param a The area to check.
     * @return True if the consecutive areas below are of type Area, otherwise false.
     */
    public boolean downSplitable(Area a) {
    	int x = a.getX();
        int y = a.getY();
        for (int i = 0; i <= 4; i++) {
            if (!isAStreet(this.areas[x][y + i])) {
                return false;
            }
        }
        return true;
    }
    
    
    
    
    /**
     * Checks if an area is a building in the city.
     *
     * @param a The Area to check.
     * @return true if the area is a building, false otherwise.
     */
    public boolean isABuilding(Area a) {
        return this.buildings.contains(a);
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
     * Adds a street to the city.
     *
     * @param e The Street to be added.
     * @return true if the street is successfully added, false otherwise.
     */
    public void addStreet(Area e) {
        return this.streets.add(e);
    }
    
    
    
    
    
    /**
     * Adds a building to the city.
     *
     * @param e The Building to be added.
     * @return true if the building is successfully added, false otherwise.
     */
    public void addBuilding(Building e) {
        this.buildings.add(e);
    }
    
    
    
    

}
