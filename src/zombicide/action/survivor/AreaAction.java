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
        List<Room> rooms = roomsAround();
        for(Room r : rooms){
            r.displayItems();
        }
    }
    private List<Room> roomsAround(){

        List<Room> rooms = new ArrayList<>();
        for(Direction d : Direction.values()){
            int i = d.getX();
            int j = d.getY();

            int x = survivor.getArea().getX();
            int y = survivor.getArea().getY();

            City city = this.survivor.getCity();
            Area area = city.getAreas()[y+j][x+i];
            if(city.isARoom(area)){
                rooms.add((Room) area);
            }

        }
        return rooms;
    }
}
