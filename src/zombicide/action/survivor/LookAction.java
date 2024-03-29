package zombicide.action.survivor;

import zombicide.actor.survivor.Survivor;
import zombicide.city.area.Area;
import zombicide.util.Direction;

public class LookAction implements SurvivorAction {

    public void doSomething(Survivor survivor){
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
        rummage(survivor);
    }

    private void rummage(Survivor survivor) {
        Area a = survivor.getArea();
        a.displayActors();
        for (Direction d : Direction.values()) {
            System.out.println("The door " + d.name() + " is " + (a.getDoor(d).isOpen()? "open" : "closed"));
        }
    }
}
