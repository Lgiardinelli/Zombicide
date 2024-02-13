package zombicide.area.room;

import zombicide.DoorDirection;
import zombicide.area.Room;

/**
 * Represents the special room "The Continental" in the game.
 */
public class TheContinental extends Room {
    private static final char name = 'C';

    /**
     * Constructs a new TheContinental room object with the specified position.
     *
     * @param x The X-coordinate position of the room.
     * @param y The Y-coordinate position of the room.
     */
    public TheContinental(int x, int y) {
        super(x, y);
    }

    @Override
    protected String getName() {
    	return "\u001B[45m\u001B[30m" + name + "\u001B[0m";
    }

    /**
     * Determines if fighting is allowed in this room. Fighting is not allowed in The Continental.
     *
     * @return Always returns false, as fighting is not allowed in The Continental room.
     */
    @Override
    public boolean canFight() {
        return false;
    }

    /**
     * Displays the room with specific formatting.
     *
     * @param n The formatting level (0, 1, or 2).
     */
//    @Override
//    public void display(int n) {
//        if (n == 0) {
//            if (this.getDoor(DoorDirection.UP).isOpen()) {
//                System.out.print(OPEN_UP);
//            } else {
//                System.out.print("-----");
//            }
//        } else if (n == 1) {
//            if (this.getDoor(DoorDirection.LEFT).isOpen()) {
//                System.out.print("- C  ");
//            } else {
//                System.out.print("| C  ");
//            }
//        } else {
//            if (this.getDoor(DoorDirection.LEFT).isOpen()) {
//                System.out.print("-    ");
//            } else {
//                System.out.print("|    ");
//            }
//        }
//    }
}
