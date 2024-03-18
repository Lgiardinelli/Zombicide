package zombicide.action.survivor;

import zombicide.action.SurvivorAction;
import zombicide.actor.survivor.Survivor;
import zombicide.city.City;
import zombicide.area.door.Door;
import zombicide.listchooser.RandomListChooser;
import zombicide.util.Direction;

import java.util.ArrayList;
import java.util.List;

public class DoorAction implements SurvivorAction {

    private final Survivor survivor;


    public DoorAction(Survivor s){
        this.survivor = s;
    }
    /**
     * Opens a door in a random adjacent area around the Survivor's current position.
     * This action selects the door from the adjacent areas and opens it.
     */
    public void doSomething(){
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
        List<Door> doors = doorsAround();
        RandomListChooser<Door> chooser = new RandomListChooser<>();
        Door door = chooser.choose(doors);
        door.open();
    }

    private List<Door> doorsAround(){

        List<Door> doors = new ArrayList<>();
        for(Direction d : Direction.values()){
            int i = d.getX();
            int j = d.getY();

            int x = survivor.getArea().getX();
            int y = survivor.getArea().getY();

            City city = this.survivor.getCity();
            Door door = city.getAreas()[y+j][x+i].getDoor(d.getReverse());

            if(door != null && !door.isOpen()) {
                doors.add(door);
            }
        }
        return doors;
    }
}
