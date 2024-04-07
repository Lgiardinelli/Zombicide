package zombicide.action.survivor;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;
import zombicide.city.City;
import zombicide.city.area.door.Door;
import zombicide.item.Item;
import zombicide.util.listchooser.RandomListChooser;
import zombicide.util.Direction;

import java.util.ArrayList;
import java.util.List;

public class DoorAction implements Action<Survivor> {

    /**
     * Opens a door in a random adjacent area around the Survivor's current position.
     * This action selects the door from the adjacent areas and opens it.
     */
    public void doSomething(Survivor survivor){
        if(canOpen(survivor)) {
            List<Door> doors = doorsAround(survivor);
            RandomListChooser<Door> chooser = new RandomListChooser<>();
            Door door = chooser.choose(doors);
            door.open();
            survivor.removeActionPoint();
        }
    }

    private List<Door> doorsAround(Survivor survivor){

        List<Door> doors = new ArrayList<>();
        for(Direction d : Direction.values()){
            int i = d.getX();
            int j = d.getY();

            int x = survivor.getArea().getX();
            int y = survivor.getArea().getY();

            City city = survivor.getCity();
            Door door = city.getAreas()[y+j][x+i].getDoor(d.getReverse());

            if(door != null && !door.isOpen()) {
                doors.add(door);
            }
        }
        return doors;
    }

    public boolean canOpen(Survivor survivor){
        Item i = survivor.getItemHeld();
        return i.canOpen();
    }
}
