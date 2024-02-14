package zombicide.area.street;

import zombicide.Area;
import zombicide.util.Color;

/**
 * Represents a special street with manholes in the game.
 */
public class Manhole extends Area {
    private static final String backRedColorCode = Color.BACK_RED.getCode();

    private static final char name = 'M';

    /**
     * Constructs a new ManholeStreet object with the specified position.
     *
     * @param posX The X-coordinate position of the street.
     * @param posY The Y-coordinate position of the street.
     */
    public Manhole(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    protected String getName() {
        return backRedColorCode + blackColorCode + name + resetColorCode;
    }
}
