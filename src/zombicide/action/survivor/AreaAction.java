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
        displayAreasAround();
    }

    private void displayAreasAround(){
        City city = this.survivor.getCity();
        for(Direction d : Direction.values()){
            System.out.print(d.name()+" :");
            int i = d.getX();
            int j = d.getY();

            int x = survivor.getArea().getX();
            int y = survivor.getArea().getY();

            Area a = city.getAreas()[y+j][x+i];

            a.displayActors();
            System.out.println();
            if(city.isARoom(a)){
                Room r = (Room) a;
                r.displayItems();
            }
            System.out.println();
        }
    }


}
