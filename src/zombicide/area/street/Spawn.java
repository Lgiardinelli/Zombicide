package zombicide.area.street;

import zombicide.area.Street;
import zombicide.util.Color;

/**
 * Represents a special street where players spawn in the game.
 */
public class Spawn extends Street {
    private static final char name = '¤';
    private static final String redColorCode = Color.RED.getCode();

    private int nbZombies;

    private int nbSurvivors;

    /**
     * Constructs a new Street object with the specified position.
     *
     * @param posX The X-coordinate position of the street.
     * @param posY The Y-coordinate position of the street.
     */
    public Spawn(int posX, int posY) {
        super(posX, posY);
        this.nbSurvivors = 0;
        this.nbZombies = 0;
    }

    @Override
    public String getName() {
        return redColorCode + name + resetColorCode;
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
