package zombicide.action.survivor;

import zombicide.action.SurvivorAction;
import zombicide.actor.survivor.Survivor;

public class BackPackAction implements SurvivorAction {

    private Survivor survivor;

    public BackPackAction(Survivor s){
        this.survivor = s;
    }
    @Override
    public void doSomething() {
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());

    }
}
