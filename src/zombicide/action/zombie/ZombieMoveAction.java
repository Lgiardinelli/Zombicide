package zombicide.action.zombie;

import zombicide.action.MoveAction;
import zombicide.actor.zombie.Zombie;
import zombicide.city.area.Area;
import zombicide.util.Direction;

import java.util.HashMap;
import java.util.Map;

/**
 * A class representing the move action for a Zombie in the game.
 * This class extends the MoveAction class and provides the specific
 * implementation for a Zombie's movement behavior.
 */
public class ZombieMoveAction extends MoveAction<Zombie> {

    /**
     * Calculates the direction of movement for the Zombie.
     *
     * @param area The Area in which the Zombie is located.
     * @return The direction of movement for the Zombie.
     * @throws IllegalStateException If the Zombie cannot move.
     */
    @Override
    protected Direction getDirectionFrom(Zombie z , Area area) throws IllegalStateException {
        Direction direction = bestDirectionToTake(z , area);

        if (direction == null)
            throw new IllegalStateException("Zombie must have direction to move!");

        return direction;
    }

    public String toString () {
        return "Move Action";
    }

    private double distance(Area areaofZombie , Area area){
        int x1 = areaofZombie.getX();
        int y1 = areaofZombie.getY();

        int x2 = area.getX();
        int y2 = area.getY();

        double result = Math.pow(x2-x1 , 2) +  Math.pow(y2-y1 , 2);

        return Math.sqrt(result);
    }

    private Direction minimalDistance(HashMap<Direction , Double> map){
        Double min = (double) -1;
        Direction direction = null;

        for(Map.Entry<Direction , Double> entry : map.entrySet()){
            if(entry.getValue() >= min){
                min = entry.getValue();
                direction = entry.getKey();
            }
        }

        return direction;
    }

    private Direction bestDirectionToTake(Zombie z , Area area){
        HashMap<Direction , Double> distanceFromEachDirection = new HashMap<>();
        Area a = z.getArea();

        for(Direction d : Direction.values()){
            int x = a.getX()+d.getX();
            int y = a.getY()+d.getY();

            Area areaDirection = z.getCity().getArea(x , y);

            distanceFromEachDirection.put(d , distance(a , areaDirection));
        }

        return minimalDistance(distanceFromEachDirection);

    }
}
