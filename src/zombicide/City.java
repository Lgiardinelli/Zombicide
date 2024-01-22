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
    
    /** The two-dimensional array representing different areas in the city. */
    private Area[][] areas;
    
    /** The spawn street for player entry. */
    private SpawnStreet spawnStreet;
    
    /** Random generator for various city-related operations. */
    private Random random;

    /**
     * Constructs a new City with the specified width and height.
     *
     * @param width  The width of the city.
     * @param height The height of the city.
     */
    public City(int width, int height) {
        this.areas = new Area[width][height];
        this.streets = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.random = new Random();
    }

    /**
     * Creates a crossroad at a random position within the given areas and initializes it.
     *
     * @param areas The two-dimensional array representing different areas in the city.
     * @return The created crossroad street.
     */
    private Street createCrossRoad(Area[][] areas) {
        Position p = getRandomPositionForCrossRoad(areas);
        int x = p.getX();
        int y = p.getY();
        Street crossRoad;
        if (this.spawnStreet == null) {
            crossRoad = new SpawnStreet(x, y);
            this.spawnStreet = (SpawnStreet) crossRoad;
        } else 
            crossRoad = new Street(x, y);
        return crossRoad;
    }
    
    /**
     * Generates a random position within the given areas for creating a crossroad.
     *
     * @param areas The two-dimensional array representing different areas in the city.
     * @return The randomly generated position.
     */
    private Position getRandomPositionForCrossRoad(Area[][] areas) {
        int x = random.nextInt(2, areas.length - 2);
        int y = random.nextInt(2, areas[0].length - 2);
        return new Position(x, y);
    }
    
    /**
     * Initializes streets originating from the given crossroad within the city areas.
     *
     * @param crossRoad The crossroad street.
     * @param areas The two-dimensional array representing different areas in the city.
     */
    private void initStreetsFromCrossRoad(Street crossRoad, Area[][] areas) {
        int x = crossRoad.getX();
        int y = crossRoad.getY();
        
        for (int i = 0; i < areas[0].length; i++) {
            if (this.areas[x][i] == null)
                this.areas[x][i] = new Street(x, i);
        }
        for (int i = 0; i < areas.length; i++) {
            if (this.areas[i][y] == null)
                this.areas[i][y] = new Street(i, y);
        }
    }
    
    /**
     * Divides the city areas into four sub-areas based on the given crossroad.
     *
     * @param crossRoad The crossroad street.
     * @param areas The two-dimensional array representing different areas in the city.
     * @return A list containing the four sub-areas.
     */
    private List<Area[][]> getSplittedAreasList(Street crossRoad, Area[][] areas) {
        List<Area[][]> splittedAreas = new ArrayList<>();
        
        int x = crossRoad.getX();
        int y = crossRoad.getY();

        Area[][] topLeft = getSubAreas(0, 0, x - 1, y - 1);
        Area[][] topRight = getSubAreas(x + 1, 0, areas.length - 1, y - 1);
        Area[][] bottomLeft = getSubAreas(0, y + 1, x - 1, areas[0].length - 1);
        Area[][] bottomRight = getSubAreas(x + 1, y + 1, areas.length - 1, areas[0].length - 1);
        
        splittedAreas.add(topLeft);
        splittedAreas.add(topRight);
        splittedAreas.add(bottomLeft);
        splittedAreas.add(bottomRight);
        
        return splittedAreas;
    }
    
    /**
     * Retrieves a sub-area from the given areas based on specified start and end coordinates.
     *
     * @param startX The starting x-coordinate.
     * @param startY The starting y-coordinate.
     * @param endX The ending x-coordinate.
     * @param endY The ending y-coordinate.
     * @return The sub-area represented by a two-dimensional array.
     */
    private Area[][] getSubAreas(int startX, int startY, int endX, int endY) {
        Area[][] subArea = new Area[endX - startX + 1][endY - startY + 1];
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                subArea[i - startX][j - startY] = areas[i][j];
            }
        }
        return subArea;
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
            if (isAStreet(this.areas[x + i][y])) {
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
}
