package zombicide.actor.action;

import zombicide.actor.survivor.Survivor;
import zombicide.city.City;
import zombicide.city.area.Area;
import zombicide.city.area.room.Room;
import zombicide.util.Direction;

public class AreaAction implements Action {

    private Survivor survivor;

    public AreaAction(Survivor s) {
        this.survivor = s;
    }

    /**
     * TODO
     * @return boolean
     */
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
            if(!a.isARoom())
                return;
            Room r = (Room) a;
            if (city.containsRoom(r))
                r.displayItems();
            System.out.println();
        }
    }

    @Override
    public void doSomething() {
        displayAreasAround();
        this.survivor.removeActionPoint();
    }
}
