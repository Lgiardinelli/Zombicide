package zombicide.area.street;

import zombicide.area.Street;
import zombicide.util.Color;

/**
 * Represents a special street where players spawn in the game.
 */
public class Spawn extends Street {
    private static final char name = '¤';
    private static final String redColorCode = Color.RED.getCode();


    /**
     * Constructs a new Street object with the specified position.
     *
     * @param posX The X-coordinate position of the street.
     * @param posY The Y-coordinate position of the street.
     */
    public Spawn(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public String getName() {
        return redColorCode + name + resetColorCode;
    }


}
