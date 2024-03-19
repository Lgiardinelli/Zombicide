package zombicide.util;

public enum Direction {
    UP(0, -1),
    RIGHT(1, 0),
    DOWN(0, 1),
    LEFT(-1, 0);

    private final int x;
    private final int y;
    private Direction reverse;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static {
        UP.reverse = DOWN;
        RIGHT.reverse = LEFT;
        DOWN.reverse = UP;
        LEFT.reverse = RIGHT;
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
