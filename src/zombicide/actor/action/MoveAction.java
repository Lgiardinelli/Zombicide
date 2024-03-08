package zombicide.actor.action;

import zombicide.*;

/**
 * Represents an action for moving an Actor in a specified direction.
 */
public class MoveAction implements ActorAction {

    /** The direction in which the Actor will move. */
    final ActorDirection direction;

    /**
     * Constructs a new MoveAction with the specified direction.
     *
     * @param d The direction in which the Actor will move.
     */
    public MoveAction(ActorDirection d){
        this.direction = d;
    }

    /**
     * Calculates the new position of an Actor after moving in the specified direction.
     *
     * @param a The Actor whose position is to be calculated.
     * @return The new Position after moving the Actor.
     */
    public Position PositionAfterMoving(Actor a){
        // Get the current area of the Actor
        Area actorArea = a.getArea();

        // Get the current X and Y coordinates of the Actor's area
        int x = actorArea.getX();
        int y = actorArea.getY();

        // Calculate the new X and Y coordinates after moving in the specified direction
        int i = x + direction.getX();
        int j = y + direction.getY();

        // Create and return the new Position
        return new Position(i , j);
    }

}
