package zombicide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import zombicide.area.Room;
import zombicide.area.Street;
import zombicide.area.room.TheContinental;
import zombicide.area.room.ThePharmacy;
import zombicide.area.street.Manhole;
import zombicide.area.street.Spawn;
import zombicide.util.Position;

public class City {
    private final Area[][] areas;
    private final Random random;
    private Spawn spawn;
    private TheContinental theContinental;
    private ThePharmacy thePharmacy;
    private static final String CLOSE_DOWN = "------";

    /**
     * Constructs a new City object with the specified width and height.
     *
     * @param width  the width of the city
     * @param height the height of the city
     */
    public City(int width, int height) {
        this.areas = new Area[height][width];
        this.random = new Random();
        initCity();
    }
    
    /**
     * Retrieves the array of areas representing the city.
     *
     * @return The array of areas representing the city.
     */
    public Area[][] getAreas() {
        return this.areas;
    }

    /**
     * Initializes the city by splitting the areas and creating rooms.
     */
    private void initCity() {
        Position topLeftPos = getTopLeftPosition();
        Position bottomRightPos = getBottomRightPosition();
        splitAreas(topLeftPos, bottomRightPos);
        createRooms();
     }

    /**
     * Retrieves the position of the bottom-right corner of the city.
     *
     * @return The position of the bottom-right corner of the city.
     */
    private Position getBottomRightPosition() {
        return new Position(getWidth() - 1, getHeight() - 1);
    }

    /**
     * Retrieves the position of the top-left corner of the city.
     *
     * @return The position of the top-left corner of the city.
     */
    private Position getTopLeftPosition() {
        return new Position(0, 0);
    }

    /**
     * Initializes doors for the rooms and areas.
     *
     * @param rooms The list of rooms in the city.
     */
    private void initDoors(List<Room> rooms) {
        createDoors();

        for (Room r : rooms) {
            for (DoorDirection d : DoorDirection.values()) {
                r.getDoor(d).close();
            }
        }

        for (int i = 0; i < this.getWidth(); i++) {
            this.getAreas()[0][i].getDoor(DoorDirection.UP).close();
        }
        
         for (int i = 0 ; i < this.getHeight(); i++) {
        	 this.getAreas()[i][0].getDoor(DoorDirection.LEFT).close();
         }
    }

    /**
     * Creates a spawn street at the given position.
     *
     * @param p The position of the spawn street.
     */
    private void createSpawnStreet(Position p) {
        int x = p.getX();
        int y = p.getY();
        this.spawn = new Spawn(x, y);
        this.areas[y][x] = this.spawn;
    }

    /**
     * Generates a random position between the given bounds.
     *
     * @param pos1 The first position.
     * @param pos2 The second position.
     * @return A random position between the bounds.
     */
    private Position getRandomCrossRoadPos(Position pos1, Position pos2) {
        return getRandomPos(pos1, pos2, 2);
    }

    /**
     * Generates a random position between the given bounds.
     *
     * @param pos1 The first position.
     * @param pos2 The second position.
     * @return A random position between the bounds.
     */
    private Position getRandomRoomPos(Position pos1, Position pos2) {
        return getRandomPos(pos1, pos2, 0);
    }

    /**
     * Generates a random position between the given bounds.
     *
     * @param pos1      The first position.
     * @param pos2      The second position.
     * @param delimiter The delimiter to adjust randomness.
     * @return A random position between the bounds.
     */
    private Position getRandomPos(Position pos1, Position pos2, int delimiter) {
        int x = random.nextInt((pos2.getX() - delimiter + 1) - (pos1.getX() + delimiter)) + pos1.getX() + delimiter;
        int y = random.nextInt((pos2.getY() - delimiter + 1) - (pos1.getY() + delimiter)) + pos1.getY() + delimiter;
        return new Position(x, y);
    }

    /**
     * Splits the areas of the city recursively.
     *
     * @param topLeftPos      The top left position of the area.
     * @param bottomRightPos  The bottom right position of the area.
     */
    private void splitAreas(Position topLeftPos, Position bottomRightPos) {
        Position crossroadPos = getRandomCrossRoadPos(topLeftPos, bottomRightPos);


        if (this.spawn == null) {
            createSpawnStreet(crossroadPos);
            createManholes(crossroadPos, topLeftPos, bottomRightPos);
        }


        createStreets(crossroadPos, topLeftPos, bottomRightPos);


        List<Position[]> areasPositions = getSplittedPositions(crossroadPos, topLeftPos, bottomRightPos);
        for (Position[] positions : areasPositions) {
            Position newTopLeftPos = positions[0];
            Position newBottomRightPos = positions[1];
            if (isAreaSplittable(newTopLeftPos, newBottomRightPos)) {
                splitAreas(newTopLeftPos, newBottomRightPos);
            }
        }
    }

    
    /**
     * Retrieves an empty position for a room.
     *
     * @return An empty position for a room.
     */
    private Position getEmptyRoomPos() {
        Position pos;
        do {
            pos = getRandomRoomPos(getTopLeftPosition(), getBottomRightPosition());
        } while (this.getAreas()[pos.getY()][pos.getX()] != null);
        return pos;
    }

    /**
     * Creates a special room of the given type and adds it to the city.
     *
     * @param room  The class representing the special room.
     * @param rooms The list of rooms in the city.
     * @return The created special room.
     */
    private Room createSpecialRoom(Class<? extends Room> room, List<Room> rooms) {
        Position pos = getEmptyRoomPos();
        int x = pos.getX();
        int y = pos.getY();

        try {
            Room r = room.getDeclaredConstructor(int.class, int.class).newInstance(x, y);
            this.areas[y][x] = r;
            rooms.add(r);
            return r;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Initializes the city by creating special rooms and regular rooms.
     */
    private void createRooms() {
        List<Room> rooms = new ArrayList<>();

        this.theContinental = (TheContinental) createSpecialRoom(TheContinental.class, rooms);
        this.thePharmacy = (ThePharmacy) createSpecialRoom(ThePharmacy.class, rooms);

        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (this.areas[i][j] == null) {
                    Room r = new Room(j, i);
                    this.areas[i][j] = r;
                    rooms.add(r);
                }
            }
        }
        initDoors(rooms);
    }

    /**
     * Creates manhole streets at the extremities of the principal crossroad's streets.
     *
     * @param crossroadPos    The position of the principal crossroad where streets intersect.
     * @param topLeftPos      The position representing the top-left corner of the area to be considered.
     * @param bottomRightPos  The position representing the bottom-right corner of the area to be considered.
     */
    private void createManholes(Position crossroadPos, Position topLeftPos, Position bottomRightPos) {
        this.areas[0][crossroadPos.getX()] = new Manhole(crossroadPos.getX(), 0);
        this.areas[crossroadPos.getY()][bottomRightPos.getX()] = new Manhole(bottomRightPos.getX(), crossroadPos.getY());
        this.areas[bottomRightPos.getY()][crossroadPos.getX()] = new Manhole(crossroadPos.getX(), bottomRightPos.getY());
        this.areas[crossroadPos.getY()][0] = new Manhole(0, crossroadPos.getY());
    }

    /**
     * Gets the positions of the areas after splitting.
     *
     * @param crossroadPos    The position of the crossroad.
     * @param topLeftPos      The top left position of the area.
     * @param bottomRightPos  The bottom right position of the area.
     * @return A list of positions representing the splitted areas.
     */
    private List<Position[]> getSplittedPositions(Position crossroadPos, Position topLeftPos, Position bottomRightPos) {
        Position[] topLeftArea = { topLeftPos, new Position(crossroadPos.getX() - 1, crossroadPos.getY() - 1) };
        Position[] topRightArea = { new Position(crossroadPos.getX() + 1, topLeftPos.getY()), new Position(bottomRightPos.getX(), crossroadPos.getY() - 1) };
        Position[] bottomLeftArea = { new Position(topLeftPos.getX(), crossroadPos.getY() + 1), new Position(crossroadPos.getX() - 1, bottomRightPos.getY()) };
        Position[] bottomRightArea = { new Position(crossroadPos.getX() + 1, crossroadPos.getY() + 1), bottomRightPos };
        return List.of(topLeftArea, topRightArea, bottomLeftArea, bottomRightArea);
    }

    /**
     * Creates streets based on the crossroad position and the area bounds.
     *
     * @param crossRoadPos    The position of the crossroad.
     * @param topLeftPos      The top left position of the area.
     * @param bottomRightPos  The bottom right position of the area.
     */
    private void createStreets(Position crossRoadPos, Position topLeftPos, Position bottomRightPos) {
        int width = getAreasWidth(topLeftPos, bottomRightPos);
        int height = getAreasHeight(topLeftPos, bottomRightPos);

        int cX = crossRoadPos.getX();
        int cY = crossRoadPos.getY();

        int tX = topLeftPos.getX();
        int tY = topLeftPos.getY();


        for (int i = 0; i < width; i++) {
            if (this.areas[cY][tX + i] == null) {
                this.areas[cY][tX + i] = new Street(tX + i, cY);
            }
        }


        for (int i = 0; i < height; i++) {
            if (this.areas[tY + i][cX] == null) {
                this.areas[tY + i][cX] = new Street(cX, tY + i);
            }
        }
    }

    /**
     * Checks if an area is splittable based on its size.
     *
     * @param pos1 The top left position of the area.
     * @param pos2 The bottom right position of the area.
     * @return True if the area is splittable, false otherwise.
     */
    private boolean isAreaSplittable(Position pos1, Position pos2) {
        return getAreasWidth(pos1, pos2) >= 5 && getAreasHeight(pos1, pos2) >= 5;
    }


    /**
     * Displays the city by printing the areas.
     */
    public void display() {
        for (int i = 0; i < getHeight(); i++) {
            for (int n = 0; n < 3; n++) {
                for (int j = 0; j < getWidth(); j++) {
                    this.areas[i][j].display(n);
                }
                if (n != 0) {
                    System.out.println('|');
                } else {
                    System.out.println();
                }
            }
        }
        for (int s = 0; s < getWidth(); s++) {
            System.out.print(CLOSE_DOWN);
        }
    }
    
    /**
     * Creates doors between areas.
     */
    private void createDoors() {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                Door upDoor = new Door();
                Door leftDoor = new Door();
                try {
                    Area area = this.areas[i][j];
                    area.addDoor(DoorDirection.UP, upDoor);
                    area.addDoor(DoorDirection.LEFT, leftDoor);
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                try {
                    Area upArea = this.areas[i - 1][j];
                    upArea.addDoor(DoorDirection.DOWN, upDoor);
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                try {
                    Area leftArea = this.areas[i][j - 1];
                    leftArea.addDoor(DoorDirection.RIGHT, leftDoor);
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
    }

    /**
     * Gets the width of the areas based on the given positions.
     *
     * @param pos1 The top left position of the area.
     * @param pos2 The bottom right position of the area.
     * @return The width of the areas.
     */
    private int getAreasWidth(Position pos1, Position pos2) {
        return pos2.getX() - pos1.getX() + 1;
    }

    /**
     * Gets the height of the areas based on the given positions.
     *
     * @param pos1 The top left position of the area.
     * @param pos2 The bottom right position of the area.
     * @return The height of the areas.
     */
    private int getAreasHeight(Position pos1, Position pos2) {
        return pos2.getY() - pos1.getY() + 1;
    }

    /**
     * Gets the width of the city.
     *
     * @return The width of the city.
     */
    public int getWidth() {
        return this.areas[0].length;
    }

    /**
     * Gets the height of the city.
     *
     * @return The height of the city.
     */
    public int getHeight() {
        return this.areas.length;
    }

    /**
     * Retrieves the area above a specified position.
     *
     * @param x The x-coordinate of the area.
     * @param y The y-coordinate of the area.
     * @return The area above the specified position.
     */
    public Area getCellUp(int x, int y) {
        return this.areas[x][y - 1];
    }

}
