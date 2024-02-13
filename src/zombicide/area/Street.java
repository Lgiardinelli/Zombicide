package zombicide.area;

import zombicide.Area;
import zombicide.DoorDirection;

/**
 * Represents a street area on the game board.
 */
public class Street extends Area {
    private static final char name = 'S';


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
    }

    @Override
    protected String getName() {
        return "\u001B[44m\u001B[30m" + name + "\u001B[0m";
    }

    /**
     * Displays the street area with specific formatting.
     *
     * @param n The formatting level (0, 1, or 2).
     */
//    @Override
//    public void display(int n) {
//        if (n == 0) {
//            System.out.print(this.getDoor(DoorDirection.UP).isOpen() ? OPEN_UP : "-----");
//        } else if (n == 1) {
//            System.out.print("  " + name + "   ");
//        } else {
//            System.out.print("      ");
//        }
//    }
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
//                System.out.print("  S  ");
//            } else {
//                System.out.print("| S  ");
//            }
//        } else {
//            if (this.getDoor(DoorDirection.LEFT).isOpen()) {
//                System.out.print("     ");
//            } else {
//                System.out.print("|    ");
//            }
//        }
//    }
}
