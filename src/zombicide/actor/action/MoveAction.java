package zombicide.actor.action;

import zombicide.actor.action.ActorAction;
import zombicide.actor.Actor;
import zombicide.city.City;
import zombicide.util.Direction;
import zombicide.util.Position;

/**
 * Represents an action for moving an Actor in a specified direction.
 */
public class MoveAction implements ActorAction {

    /** The direction in which the Actor will move. */
    private final Direction direction;
    private Actor actor;

    /**
     * Constructs a new MoveAction with the specified direction.
     *
     * @param d The direction in which the Actor will move.
     * @param actor - the actor
     */
    public MoveAction(Direction d, Actor actor){
        this.direction = d;
        this.actor = actor;
    }

    /**
     * Calculates the new position of an Actor after moving in the specified direction.
     *
     * @return The new Position after moving the Actor.
     */
    public Position positionAfterMoving(){
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
    public void doSomething() {
        Position p = positionAfterMoving();
        City city = this.actor.getCity();
        this.actor.setArea(city.getArea(p));
        this.actor.removeActionPoint();
    }
}
