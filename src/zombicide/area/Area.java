package zombicide.area;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.door.Door;
import zombicide.util.Color;
import zombicide.util.Direction;

/**
 * Abstract class representing an area in the game.
 */
public abstract class Area {
    protected static final String resetColorCode = Color.RESET.getCode();
    protected static final String blackBoldColorCode = Color.BLACK_BOLD.getCode();
    private static final String greenBoldBrightCode = Color.GREEN_BOLD_BRIGHT.getCode();
    private static final String redBoldBrightColorCode = Color.RED_BOLD_BRIGHT.getCode();
    private static final String OPEN_UP = "-     ";
	private static final String CLOSE_UP = "------";
    private final static char ZOMBIE = 'Z';
    private final static char SURVIVOR = 'S';
    protected List<Survivor> survivors;
    protected List<Zombie> zombies;
    private final int posX;
    private final int posY;
    private int noise;
    protected final Map<Direction, Door> doors;

    /**
     * Constructor for the Area class.
     * 
     * @param posX The X position of the area.
     * @param posY The Y position of the area.
     */
    public Area(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.survivors = new ArrayList<>();
        this.zombies = new ArrayList<>();
        this.noise = 0;
        this.doors = new HashMap<>();
        for (Direction d : Direction.values()) {
            doors.put(d, new Door());
        }
    }

    public List<Survivor> getSurvivors() {
        return survivors;
    }

    public List<Zombie> getZombies() {
        return zombies;
    }

    /**
     * Retrieves the door in the specified direction.
     * 
     * @param direction The direction of the door.
     * @return The door in the specified direction.
     */
    public Door getDoor(Direction direction) {
        return this.doors.get(direction);
    }

    /**
     * Retrieves all doors in the area.
     * 
     * @return Map containing all doors in the area.
     */
    public Map<Direction, Door> getDoors() {
        return doors;
    }

    /**
     * Adds a door to the area in the specified direction.
     * 
     * @param direction The direction of the door.
     * @param door The door to add.
     */
    public void addDoor(Direction direction, Door door) {
        doors.put(direction, door);
    }

    /**
     * Retrieves the X position of the area.
     * 
     * @return The X position of the area.
     */
    public int getX() {
        return this.posX;
    }

    /**
     * Retrieves the Y position of the area.
     * 
     * @return The Y position of the area.
     */
    public int getY() {
        return this.posY;
    }

    /**
     * Checks if fighting is possible in the area.
     * 
     * @return true if fighting is possible, false otherwise.
     */
    public boolean canFight() {
        return true;
    }

    /**
     * Abstract method to display the area.
     */
    protected void display() {
    }

    /**
     * Abstract method to display the area with specific parameters.
     * 
     * @param n Specific parameters for displaying the area.
     */
    public void display(int n) {
    	if (n == 0) {
			System.out.print(this.getDoor(Direction.UP).isOpen() ? OPEN_UP : CLOSE_UP);
    	}
    	else if (n == 1) {
    		System.out.print(this.getDoor(Direction.LEFT).isOpen() ? openLeft1() : closeLeft1());
    	}
    	else {
    		System.out.print(this.getDoor(Direction.LEFT).isOpen() ? openLeft2() : closeLeft2());
    	}
    }

    abstract protected String getName();

    public int getNbZombies() {
        return this.zombies.size();
    }

    public int getNbSurvivors() {
        return this.survivors.size();
    }

    private String hasZombies() {
        int z = getNbZombies();
        if (z == 0) {
            return "    ";
        }
        return " " + redBoldBrightColorCode + ZOMBIE + z + resetColorCode + " ";
    }

    private String hasSurvivors() {
        int s = getNbSurvivors();
        if (s == 0) {
            return "    ";
        }
        return " " + greenBoldBrightCode + SURVIVOR + s + resetColorCode + " ";
    }

    public void addZombie(Zombie z) {
        // z.setArea(this);
        this.zombies.add(z);
    }

    public void addSurvivor(Survivor s) {
        // s.setArea(this);
        this.survivors.add(s);
    }

    public void removeActor(Actor a) {
        this.survivors.remove(a);
        this.zombies.remove(a);
    }

    public int getNoise(){
        return this.noise;
    }

    public void setNoise(int noise){
        this.noise = noise;
    }

    public void increaseNoiseLevel(){
        this.noise++;
    }

    public String openLeft1() {
        return " " + getName() + hasZombies();
    }

    public String closeLeft1() {
        return "|" + getName() + hasZombies();
    }

    public String openLeft2() {
        return "  " + hasSurvivors();
    }

    public String closeLeft2() {
        return "| " + hasSurvivors();
    }
}
