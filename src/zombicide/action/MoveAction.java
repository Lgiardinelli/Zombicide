package zombicide.action;

import zombicide.actor.Actor;
import zombicide.city.City;
import zombicide.util.Direction;
import zombicide.util.Position;

/**
 * Represents an action for moving an Actor in a specified direction.
 */
public class MoveAction extends ActorAction {

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
    public Position positionAfterMoving(){
        this.direction = randomDirection();
        // Get the current X and Y coordinates of the Actor's area
        int x = this.actor.getArea().getX();
        int y = this.actor.getArea().getY();

        // Calculate the new X and Y coordinates after moving in the specified direction
        int i = x + direction.getX();
        int j = y + direction.getY();

        // Create and return the new Position
        return new Position(i , j);
    }

    @Override
    public void doSomething(Actor actor) {
        Position p = positionAfterMoving();
        City city = this.actor.getCity();
        this.actor.setArea(city.getArea(p.getX(), p.getY()));
        this.actor.removeActionPoint();
    }
}
