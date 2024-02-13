package zombicide.area.street;

import zombicide.DoorDirection;
import zombicide.area.Street;

/**
 * Represents a special street with manholes in the game.
 */
public class ManholeStreet extends Street {

    /**
     * Constructs a new ManholeStreet object with the specified position.
     *
     * @param posX The X-coordinate position of the street.
     * @param posY The Y-coordinate position of the street.
     */
    public ManholeStreet(int posX, int posY) {
        super(posX, posY);
        this.name = 'M';
    }

    /**
     * Displays the manhole street with specific formatting.
     *
     * @param n The formatting level (0, 1, or 2).
     */
    @Override
    public void display(int n) {
        if (n == 0) {
            if (this.getDoor(DoorDirection.UP).isOpen()) {
                System.out.print(OPEN_UP);
            } else {
                System.out.print("------");
            }
        } else if (n == 1) {
            if (this.getDoor(DoorDirection.LEFT).isOpen()) {
                System.out.print("  M   ");
            } else {
                System.out.print("| M   ");
            }
        } else {
            if (this.getDoor(DoorDirection.LEFT).isOpen()) {
                System.out.print("      ");
            } else {
                System.out.print("|     ");
            }
        }
    }
}
