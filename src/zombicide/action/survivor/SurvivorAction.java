package zombicide.action.survivor;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;

public interface SurvivorAction extends Action {
    void doSomething(Survivor survivor);
}
