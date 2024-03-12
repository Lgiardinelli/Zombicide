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
    private City city;

    public AreaAction(Survivor s,City c){
        this.survivor = s;
        this.city = c;
    }

    public void displayAreasAround(){
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

            Area area = this.city.getAreas()[y+j][x+i];
            if(this.city.isARoom(area)){
                rooms.add((Room) area);
            }

        }
        return rooms;
    }
}
