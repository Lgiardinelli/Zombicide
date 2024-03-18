package zombicide.action.survivor;

import zombicide.action.ActorAction;
import zombicide.action.SurvivorAction;

public class LookAction implements SurvivorAction {

    public void doSomething(){
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
        rummage();
    }

    private void rummage() {

    }

}
