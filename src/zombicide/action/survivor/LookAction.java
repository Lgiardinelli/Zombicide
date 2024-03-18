package zombicide.action.survivor;

import zombicide.action.SurvivorAction;
import zombicide.actor.survivor.Survivor;
import zombicide.area.Area;
import zombicide.util.Direction;

public class LookAction implements SurvivorAction {

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
            System.out.println("La porte " + d.name() + " est " + a.getDoor(d).isOpen());
        }

    }

}
