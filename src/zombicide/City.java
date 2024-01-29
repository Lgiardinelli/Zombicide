package zombicide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        this.areas = new Area[height][width];
        this.streets = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.random = new Random();
        initCity();
    }
    
    /**
     * Initializes the city by splitting areas.
     */
    public void initCity() {
        splitAreas(new Position(0, 0), new Position(getWidth(), getHeight()));
        
        System.out.println(spawnStreet.getX() + " | " + spawnStreet.getY());
    }
    
    private void createSpawnStreet() {
    	Position p = getRandomPositionInArea(this.areas);
    	int x = p.getX();
    	int y = p.getY();
    	this.spawnStreet = new SpawnStreet(x, y);
    	this.areas[y][x] = this.spawnStreet;
	}
    
    /**
     * Generates a random position within the given areas for creating a crossroad.
     *
     * @param areas The two-dimensional array representing different areas in the city.
     * @return The randomly generated position.
     */
    private Position getRandomPositionInArea(Area[][] areas) {
    	int x = getRandomIndex(getAreasWidth(areas));
    	int y = getRandomIndex(getAreasHeight(areas));
        return new Position(x, y);
    }
    
    private int getRandomIndex(int coords) {
		return random.nextInt(2, coords - 2);
	}
    
    /**
     * Recursively splits the given areas into smaller sub-areas until they are not splittable.
     *
     * @param areas The two-dimensional array representing different areas in the city.
     */
    private void splitAreas(Position topLeftPos, Position bottomRightPos) {
        
    	List<Position> areasPositions;
    	if (this.spawnStreet == null) {
        	createSpawnStreet();
        	areasPositions = getSplittedAreasList(spawnStreet, topLeftPos, bottomRightPos);
        }
        
        for (Position p : areasPositions) {
        	
        	if (isSplittable(areas)) {
        		
            	splitAreas(topLeftPos, bottomRightPos);
            }
        }
    }
    
    /**
     * Divides the city areas into four sub-areas based on the given crossroad.
     *
     * @param crossRoad The crossroad street.
     * @param areas The two-dimensional array representing different areas in the city.
     * @return A list containing the four sub-areas.
     */
    private List<Position> getSplittedAreasList(Street crossRoad, Position topLeftPos, Position bottomRightPos) {
        List<Area[][]> splittedAreas = new ArrayList<>();
        
        int x = crossRoad.getX();
        int y = crossRoad.getY();
        
        
        
        return splittedAreas;
    }


    
    private boolean isSplittable(Area[][] areas) {
    	return getWidth() >= 5 && getHeight() >= 5;
    }
    
    public void display() {
    	for (int i = 0; i < this.getHeight(); i++) {
    		System.out.println();
    		for (int j = 0; j < this.getWidth(); j++) {
    			if (this.areas[i][j] == null) {
    				Room r = new Room(j, i, 4);
    				this.areas[i][j] = r;
    			}
    			System.out.print(this.areas[i][j]);
    		}
    	}
    }
    
    private int getAreasWidth(Area[][] areas) {
    	return areas[0].length;
    }
    
    private int getAreasHeight(Area[][] areas) {
    	return areas.length;
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
    
    public Area[][] getAreas() {
    	return this.areas;
    }
    
    public int getWidth() {
    	return this.areas[0].length;
    }
    
	public int getHeight() {
		return this.areas.length;
	}
}
