package zombicide.area;

import zombicide.Area;
import zombicide.DoorDirection;
import zombicide.util.Color;

/**
 * Represents a street area on the game board.
 */
public class Street extends Area {
    private static final char name = 'S';
    private static final String backBlueColorCode = Color.BACK_BLUE.getCode();

    private int nbZombies;

    private int nbSurvivors;


    /** Indicates whether the street is vertical or not. */
    protected boolean isVertically;

    /**
     * Constructs a new Street object with the specified position.
     *
     * @param posX The X-coordinate position of the street.
     * @param posY The Y-coordinate position of the street.
     */
    public Street(int posX, int posY) {
        super(posX, posY);
        this.nbSurvivors = 0;
        this.nbZombies = 0;
    }

    @Override
    protected String getName() {
        return backBlueColorCode + blackColorCode + name + resetColorCode;
    }

    @Override
    protected int getNbSurvivors() {
        return this.nbSurvivors;
    }

    @Override
    protected int getNbZombies() {
        return this.nbZombies;
    }
}
