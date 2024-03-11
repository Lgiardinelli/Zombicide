package zombicide.util;

public enum Direction {

    UP(0,-1,0,1),
    DOWN(0,1,0,-1),
    LEFT(-1,0,1,0),
    RIGHT(1,0,-1,0);

    final int x;
    final int y;

    final int reversex;

    final int reversey;

    Direction(int x, int y, int rx, int ry) {
        this.x = x;
        this.y = y;
        this.reversex = rx;
        this.reversey = ry;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getReversex() {
        return reversex;
    }

    public int getReversey() {
        return reversey;
    }
}
