package zombicide.action.survivor;

import zombicide.action.SurvivorAction;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.survivor.Survivor;

import java.util.List;

public class RoomAction implements SurvivorAction {

    private Survivor survivor;

    public RoomAction(Survivor s) {
        this.survivor = s;
    }

    /**
     * TODO
     * @return boolean
     */
    public boolean searchRoom(){
        return true;
    }

    @Override
    public void doSomething() {
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
        this.survivor.getArea().displayActors();
    }
}
