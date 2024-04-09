package zombicide.action;

import zombicide.actor.Actor;
import zombicide.city.City;
import zombicide.city.area.Area;
import zombicide.util.Direction;
import zombicide.util.Position;
import zombicide.util.listchooser.ListChooser;
import zombicide.util.listchooser.RandomListChooser;

import java.util.List;
import java.util.stream.Stream;

public abstract class MoveAction<T extends Actor> implements Action<T> {
    private static final ListChooser<Direction> DIRECTION_CHOOSER =
            new RandomListChooser<>();

    protected List<Direction> getOpenDirectionsFrom(Area area) {
        return Stream.of(Direction.values())
                .filter(d -> area.getDoor(d).isOpen())
                .toList();
    }

    protected Direction randomOpenDirectionFrom(Area area) {
        return DIRECTION_CHOOSER.choose(getOpenDirectionsFrom(area));
    }

    protected Direction randomDirection(Area area) {
        return DIRECTION_CHOOSER.choose(List.of(Direction.values()));
    }

    /**
     * Calculates the new position of an Actor after moving in the specified direction.
     *
     * @return The new Position after moving the Actor.
     */
    protected Position positionAfterMoving(Actor actor) {
        if (actor == null)
            return null;

        Direction direction = getDirectionFrom(actor.getArea());

        int x = actor.getArea().getX();
        int y = actor.getArea().getY();

        if (direction == null)
            return new Position(x, y);

        int i = x + direction.getX();
        int j = y + direction.getY();

        return new Position(i , j);
    }

    protected abstract Direction getDirectionFrom(Area area);

    @Override
    public void doSomething(T actor) {
        Position p = positionAfterMoving(actor);
        City city = actor.getCity();
        actor.setArea(city.getArea(p.getX(), p.getY()));
        actor.removeActionPoint();
    }
}
