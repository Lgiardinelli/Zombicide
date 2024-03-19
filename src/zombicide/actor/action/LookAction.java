package zombicide.actor.action;

import zombicide.actor.survivor.Survivor;
import zombicide.city.area.Area;
import zombicide.util.Direction;

public class LookAction implements ActorAction {

    private Survivor survivor;

    public LookAction(Survivor survivor) {
        this.survivor = survivor;
    }

    public void doSomething(){
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
        rummage();
    }

    private void rummage() {
        Area a = this.survivor.getArea();
        a.displayActors();
        for (Direction d : Direction.values()) {
            System.out.println("The door " + d.name() + " is " + (a.getDoor(d).isOpen()? "open" : "closed"));
        }

    }

}
