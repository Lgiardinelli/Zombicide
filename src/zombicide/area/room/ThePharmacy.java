package zombicide.area.room;

import zombicide.util.Color;

/**
 * Represents the special room "The Pharmacy" in the game.
 */
public class ThePharmacy extends Room {
    private static final char name = 'P';
    private static final String greenBgBrightCode = Color.GREEN_BG_BRIGHT.getCode();


    /**
     * Constructs a new ThePharmacy room object with the specified position.
     *
     * @param x The X-coordinate position of the room.
     * @param y The Y-coordinate position of the room.
     */
    public ThePharmacy(int x, int y) {
        super(x, y);
    }

    @Override
    protected String getName() {
    	return greenBgBrightCode + blackBoldColorCode + name + resetColorCode;
    }

    /**
     * Determines if fighting is allowed in this room. Fighting is allowed in The Pharmacy.
     *
     * @return Always returns true, as fighting is allowed in The Pharmacy room.
     */
    @Override
    public boolean canFight() {
        return true;
    }


}
