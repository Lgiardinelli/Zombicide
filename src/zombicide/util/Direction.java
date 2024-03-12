package zombicide.util;

public enum Direction {


    UP,
    RIGHT,
    DOWN,
    LEFT;

    static {
        UP.x = 0;
        UP.y = -1;
        UP.reverse = DOWN;

        RIGHT.x = 1;
        RIGHT.y = 0;
        RIGHT.reverse = LEFT;

        DOWN.x = 0;
        DOWN.y = 1;
        DOWN.reverse = UP;

        LEFT.x = -1;
        LEFT.y = 0;
        LEFT.reverse = RIGHT;
    }

    int x;
    int y;
    Direction reverse;



    Direction() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getReverse() {
        return this.reverse;
    }

}
