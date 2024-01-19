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
    private List<Street> streets;

    /** The list of buildings in the city. */
    private List<Building> buildings;

    /** The list of areas in the city. */
    private List<Area> areas;

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

}
