package zombicide.actor.action;

import zombicide.*;


public class MoveAction implements ActorAction {

    private ActorDirection direction;

    public Position PositionAfterMoving(Actor a){
        Area actorArea = a.getArea();
        int x = actorArea.getX();
        int y = actorArea.getY();

        int i = x + direction.getX();
        int j = y + direction.getY();

        return new Position(i , j);
    }

}
