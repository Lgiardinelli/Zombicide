package zombicide.action.survivor;

import zombicide.Area;
import zombicide.City;
import zombicide.Door;
import zombicide.action.SurvivorAction;
import zombicide.actor.survivor.Survivor;
import zombicide.util.Direction;

import java.util.ArrayList;
import java.util.List;

public class AreaAction implements SurvivorAction {

    private Survivor survivor;
    private City city;

    public AreaAction(Survivor s,City c){
        this.survivor = s;
        this.city = c;
    }

    private List<Door> areaArround(){

        List<Area> areas = new ArrayList<>();
        for(Direction d : Direction.values()){
            int i = d.getX();
            int j = d.getY();

            int x = survivor.getArea().getX();
            int y = survivor.getArea().getY();

            Door door = this.city.getAreas()[y+j][x+i].getDoor(d.getReverse());

            if(door != null) {
                doors.add(door);
            }
        }
        return doors;
    }
}
