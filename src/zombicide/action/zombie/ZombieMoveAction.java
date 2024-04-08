package zombicide.action.zombie;

import zombicide.action.MoveAction;
import zombicide.actor.zombie.Zombie;
import zombicide.city.area.Area;
import zombicide.util.Direction;

public class ZombieMoveAction extends MoveAction<Zombie> {
    @Override
    protected Direction getDirectionFrom(Area area) throws IllegalStateException {
        Direction direction = randomOpenDirectionFrom(area);

        if (direction == null)
            throw new IllegalStateException("Zombie must have direction to move !");

        return direction;
    }
}
