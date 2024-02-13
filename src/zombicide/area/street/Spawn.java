package zombicide.area.street;

import zombicide.area.Street;

/**
 * Represents a special street where players spawn in the game.
 */
public class Spawn extends Street {
    private static final char name = '¤';

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
        return "\u001B[31m" + name + "\u001B[0m";
    }

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
