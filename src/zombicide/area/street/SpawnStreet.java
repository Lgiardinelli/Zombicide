package zombicide.area.street;

import zombicide.area.Street;

/**
 * Represents a special street where players spawn in the game.
 */
public class SpawnStreet extends Street {

    /**
     * Constructs a new SpawnStreet object with the specified position.
     *
     * @param posX The X-coordinate position of the street.
     * @param posY The Y-coordinate position of the street.
     */
    public SpawnStreet(int posX, int posY) {
        super(posX, posY);
        name = '¤';
    }

    /**
     * Displays the spawn street with specific formatting.
     *
     * @param n The formatting level (0, 1, or 2).
     */
//    @Override
//    public void display(int n) {
//        if (n == 0) {
//            System.out.print(OPEN_UP);
//        } else if (n == 1) {
//            System.out.print("  ¤   ");
//        } else {
//            System.out.print("      ");
//        }
//    }
}
