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
        splitAreas(this.areas, new Position(0, 0));
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
    
    private void splitAreas(Area[][] areas, Position areasPos) {
    	Map<Position, Area[][]> splittedAreas = null;
    	
    	int width = getAreasWidth(areas);
    	int height = getAreasHeight(areas);
    	
    	if (this.spawnStreet == null) {
    		createSpawnStreet();
    		splittedAreas = splitVertically(width, height, areasPos, this.spawnStreet.getX());
    	}
    	
    	if (isWidthSplittable(areas)) {
    		
    	}
    	
    	if (isHeightSplittable(areas)) {
    		
    	}
    	
    	if (splittedAreas == null) return;
    	
    	for (Map.Entry<Position, Area[][]> entry : splittedAreas.entrySet()) {
    		Area[][] subAreas = entry.getValue();
    		Position newAreasPos = entry.getKey();
    		
    		if (isSplittable(subAreas)) {
    			splitAreas(subAreas, newAreasPos);
    		}
        }
	}
    
    private boolean isSplittable(Area[][] areas) {
    	return isWidthSplittable(areas) || isHeightSplittable(areas);
    }
    
    private boolean isWidthSplittable(Area[][] areas) {
        return areas[0].length >= 5;
    }
    
    private boolean isHeightSplittable(Area[][] areas) {
        return areas.length >= 5;
    }
    
    private Map<Position, Area[][]> splitVertically(int areasWidth, int areasHeight, Position areasPos, int splitIndex) {
		int areasX = areasPos.getX();
		int areasY = areasPos.getY();
		
		for (int i = 0; i < areasHeight; i++) {
			int x = areasX + splitIndex;
			int y = areasY + i;
			if (getAreas()[y][x] == null)
				getAreas()[y][x] = new Street(x, y);
		}
		
		System.out.printf("%d | %d | %d | %d | %d%n", areasWidth, areasHeight, areasX, areasY, splitIndex);
		
		Area[][] leftAreas = new Area[areasHeight][splitIndex - areasX];
		Area[][] rightAreas = new Area[areasHeight][areasWidth - 1 - splitIndex + areasX];
		
		Position leftAreasPos = new Position(areasX, areasY);
		Position rightAreasPos = new Position(splitIndex + 1, areasY);
		
		System.out.println("Left : " + leftAreasPos.getX() + " | " + leftAreasPos.getY());
		System.out.println("Right : " + rightAreasPos.getX() + " | " + rightAreasPos.getY());
		
		Map<Position, Area[][]> result = new HashMap<>();
		result.put(leftAreasPos, leftAreas);
		result.put(rightAreasPos, rightAreas);
		
		return result;
	}
    
    public void display() {
    	for (int i = 0; i < this.getHeight(); i++) {
    		System.out.println();
    		for (int j = 0; j < this.getWidth(); j++) {
    			if (this.areas[i][j] == null) {
    				Room r = new Room(j, i, 4);
    				this.areas[i][j] = r;
    			}
    			System.out.println(this.areas[i][j]);
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
