package zombicide.area.street;

import zombicide.Area;
import zombicide.area.Street;

/**
 * Represents a special street with manholes in the game.
 */
public class Manhole extends Area {
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
        return "\u001B[41m\u001B[30m" + name + "\u001B[0m";
    }

    /**
     * Displays the manhole street with specific formatting.
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
//    public void display(int n) {
//        if (n == 0) {
//            if (this.getDoor(DoorDirection.UP).isOpen()) {
//                System.out.print(OPEN_UP);
//            } else {
//                System.out.print("------");
//            }
//        } else if (n == 1) {
//            if (this.getDoor(DoorDirection.LEFT).isOpen()) {
//                System.out.print("  M   ");
//            } else {
//                System.out.print("| M   ");
//            }
//        } else {
//            if (this.getDoor(DoorDirection.LEFT).isOpen()) {
//                System.out.print("      ");
//            } else {
//                System.out.print("|     ");
//            }
//        }
//    }
}
