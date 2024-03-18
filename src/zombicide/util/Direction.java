package zombicide.util;

public enum Direction {
    UP(0, -1, Direction.valueOf("DOWN")),
    RIGHT(1, 0, Direction.valueOf("LEFT")),
    DOWN(0, 1, Direction.valueOf("UP")),
    LEFT(-1, 0, Direction.valueOf("RIGHT"));

    private final int x;
    private final int y;
    private final Direction reverse;

    Direction(int x, int y, Direction reverse) {
        this.x = x;
        this.y = y;
        this.reverse = reverse;
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
