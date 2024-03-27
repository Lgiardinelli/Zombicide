package zombicide.action.survivor;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;

import java.util.ArrayList;
import java.util.List;

public abstract class SurvivorAction implements Action {
    protected Survivor survivor;

    @Override
    public abstract void doSomething();

    public void setSurvivor(Survivor survivor) {
        this.survivor = survivor;
    }
}
