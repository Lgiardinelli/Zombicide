package zombicide.action.survivor;

import zombicide.action.SurvivorAction;
import zombicide.actor.survivor.Survivor;

public class HealAction implements SurvivorAction {

    private final Survivor survivor;
    private int lifePointsToAdd;

    public HealAction(Survivor s , int n){
        this.survivor =s;
        this.lifePointsToAdd = n;
    }

    public void doSomething(){
        this.heal(this.survivor);
    }

    public void heal(Survivor s){
        s.addLifePoints(this.lifePointsToAdd);
    }
    
}
