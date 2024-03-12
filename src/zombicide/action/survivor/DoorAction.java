package zombicide.action.survivor;

import zombicide.door.Door;
import zombicide.action.SurvivorAction;
import zombicide.actor.survivor.Survivor;
import zombicide.city.City;
import zombicide.listchooser.RandomListChooser;
import zombicide.util.Direction;

import java.util.ArrayList;
import java.util.List;

public class DoorAction implements SurvivorAction {

    private final Survivor survivor;


    public DoorAction(Survivor s){
        this.survivor = s;
    }
    public void openTheDoor(){
        List<Door> doors = doorsArround();
        RandomListChooser<Door> chooser = new RandomListChooser<>();
        Door door = chooser.choose(doors);
        door.open();
    }

    private List<Door> doorsArround(){

        List<Door> doors = new ArrayList<>();
        for(Direction d : Direction.values()){
            int i = d.getX();
            int j = d.getY();

            int x = survivor.getArea().getX();
            int y = survivor.getArea().getY();

            City city = this.survivor.getCity();
            Door door = city.getAreas()[y+j][x+i].getDoor(d.getReverse());

            if(door != null) {
                doors.add(door);
            }
        }
        return doors;
    }
}
