package zombicide.area.room;

import zombicide.DoorDirection;
import zombicide.area.Room;

/**
 * Represents the special room "The Pharmacy" in the game.
 */
public class ThePharmacy extends Room {

    /**
     * Constructs a new ThePharmacy room object with the specified position.
     *
     * @param x The X-coordinate position of the room.
     * @param y The Y-coordinate position of the room.
     */
    public ThePharmacy(int x, int y) {
        super(x, y);
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

    /**
     * Displays the room with specific formatting.
     *
     * @param n The formatting level (0, 1, or 2).
     */
    @Override
    public void display(int n) {
        if (n == 0) {
            if (this.getDoor(DoorDirection.UP).isOpen()) {
                System.out.print(OPEN_UP);
            } else {
                System.out.print("-----");
            }
        } else if (n == 1) {
            if (this.getDoor(DoorDirection.LEFT).isOpen()) {
                System.out.print("- P  ");
            } else {
                System.out.print("| P  ");
            }
        } else {
            if (this.getDoor(DoorDirection.LEFT).isOpen()) {
                System.out.print("-    ");
            } else {
                System.out.print("|    ");
            }
        }
    }
}
