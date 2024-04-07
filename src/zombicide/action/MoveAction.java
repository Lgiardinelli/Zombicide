package zombicide.action;

import zombicide.actor.Actor;
import zombicide.city.City;
import zombicide.util.Direction;
import zombicide.util.Position;

/**
 * Represents an action for moving an Actor in a specified direction.
 */
public class MoveAction<T extends Actor> implements Action<T> {

    /** The direction in which the Actor will move. */
    private Direction direction;

    /**
     * Constructs a new MoveAction with the specified direction.
     */
    public MoveAction() {
        this.direction = null;
    }

    private Direction randomDirection() {
        int random = (int) (Math.random() * Direction.values().length);
        return Direction.values()[random];
    }

    /**
     * Calculates the new position of an Actor after moving in the specified direction.
     *
     * @return The new Position after moving the Actor.
     */
    private Position positionAfterMoving(Actor actor){
        this.direction = randomDirection();

        int x = actor.getArea().getX();
        int y = actor.getArea().getY();

        if (!actor.getArea().getDoor(this.direction).isOpen()) {
            System.out.printf("fermé : %s", this.direction);
            return new Position(x, y);
        }

        // Calculate the new X and Y coordinates after moving in the specified direction
        int i = x + direction.getX();
        int j = y + direction.getY();

        // Create and return the new Position
        return new Position(i , j);
    }

    @Override
    public void doSomething(T actor) {
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
        Position p = positionAfterMoving(actor);
        City city = actor.getCity();
        actor.setArea(city.getArea(p.getX(), p.getY()));
        actor.removeActionPoint();
    }
}
