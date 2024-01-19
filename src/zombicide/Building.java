/**
 * The {@code Building} class represents a building in the Zombicide game.
 * A building is composed of rooms arranged in a grid.
 */
public class Building {
    private final Room[][] rooms;
    
    /**
     * Constructs a building with the specified width and height.
     * 
     * @param width The width of the building (number of rooms horizontally).
     * @param height The height of the building (number of rooms vertically).
     */
    public Building(int width, int height) {
        this.rooms = new Room[width][height];
    }
    
    /**
     * Adds a room to the building at the specified position.
     * 
     * @param room The room to add.
     * @param x The x-coordinate (horizontal position) in the building grid.
     * @param y The y-coordinate (vertical position) in the building grid.
     * @throws IndexOutOfBoundsException If the specified position is out of range.
     */
    public void addRoom(Room room, int x, int y) {
        this.rooms[x][y] = room;
    }
    
    /**
     * Gets the room at the specified position in the building.
     * 
     * @param x The x-coordinate (horizontal position) in the building grid.
     * @param y The y-coordinate (vertical position) in the building grid.
     * @return The room at the specified position.
     * @throws IndexOutOfBoundsException If the specified position is out of range.
     */
    public Room getRoom(int x, int y) {
        return this.rooms[x][y];
    }
    
    /**
     * Gets the width of the building (number of rooms horizontally).
     * 
     * @return The width of the building.
     */
    public int getWidth() {
        return this.rooms.length;
    }
    
    /**
     * Gets the height of the building (number of rooms vertically).
     * 
     * @return The height of the building.
     */
    public int getHeight() {
        return this.rooms[0].length;
    }
}
