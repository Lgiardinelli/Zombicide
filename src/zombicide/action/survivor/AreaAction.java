package zombicide.action.survivor;

;
import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;
import zombicide.city.City;
import zombicide.city.area.Area;
import zombicide.city.area.room.Room;
import zombicide.util.Direction;

public class AreaAction implements Action<Survivor> {

    /**
     * TODO
     * @return boolean
     */
    private void displayAreasAround(Survivor survivor){
        City city = survivor.getCity();
        for(Direction d : Direction.values()){
            // System.out.print(d.name()+" :");
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
    public void doSomething(Survivor survivor) {
        displayAreasAround(survivor);
        survivor.removeActionPoint();
    }
}

