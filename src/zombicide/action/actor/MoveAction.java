package zombicide.action.actor;

import zombicide.*;
import zombicide.action.ActorAction;
import zombicide.actor.Actor;
import zombicide.city.City;
import zombicide.util.ActorDirection;
import zombicide.util.Position;
import zombicide.area.Area;

/**
 * Represents an action for moving an Actor in a specified direction.
 */
public class MoveAction implements ActorAction {

    /** The direction in which the Actor will move. */
    final ActorDirection direction;
    private Actor actor;
    private City city;

    /**
     * Constructs a new MoveAction with the specified direction.
     *
     * @param d The direction in which the Actor will move.
     */
    public MoveAction(ActorDirection d, Actor actor, City city){
        this.direction = d;
        this.actor = actor;
        this.city = city;
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
        this.actor.setArea(this.city.getArea(p));
    }
}
