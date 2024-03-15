package zombicide.action.survivor;

import zombicide.area.Area;
import zombicide.city.City;
import zombicide.action.SurvivorAction;
import zombicide.actor.survivor.Survivor;
import zombicide.area.room.Room;
import zombicide.util.Direction;

import java.util.ArrayList;
import java.util.List;

public class AreaAction implements SurvivorAction {

    private Survivor survivor;

    public AreaAction(Survivor s){
        this.survivor = s;
    }

    /**
     * Displays the items in the rooms around the Survivor's current position.
     * This action retrieves adjacent areas and displays the items they contain.
     */
    public void doSomething(){
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
        City city = this.survivor.getCity();
        List<Area> areas = areasAround();
        for(Area a : areas){
            a.displayActors();
            if(city.isARoom(a)){
                Room r = (Room) a;
                r.displayItems();
            }
        }
    }

    private List<Area> areasAround(){

        List<Area> areas = new ArrayList<>();
        for(Direction d : Direction.values()){
            int i = d.getX();
            int j = d.getY();

            int x = survivor.getArea().getX();
            int y = survivor.getArea().getY();

            City city = this.survivor.getCity();
            Area area = city.getAreas()[y+j][x+i];
            if(city.isARoom(area)){
                areas.add((Room) area);
            }

        }
        return areas;
    }


}
