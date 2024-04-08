package zombicide.action.survivor;

import zombicide.action.MoveAction;
import zombicide.actor.survivor.Survivor;
import zombicide.city.area.Area;
import zombicide.util.Direction;

/**
 * Represents an action for moving an Actor in a specified direction.
 */
public class SurvivorMoveAction extends MoveAction<Survivor> {
    @Override
    protected Direction getDirectionFrom(Area area) {
        Direction direction = randomOpenDirection();

        if (!area.getDoor(direction).isOpen()) {
            System.out.printf("fermé : %s", direction);
            System.out.println();
            return null;
        }
        return direction;
    }
}
