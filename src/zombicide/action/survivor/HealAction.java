package zombicide.action.survivor;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;

public class HealAction extends SurvivorAction {
    private int lifePointsToAdd;

    public void doSomething(){
        this.heal();
        this.survivor.removeActionPoint();
    }

    public void setLifePointsToAdd(int n){
        this.lifePointsToAdd = n;
    }

    public void heal(){
        this.survivor.addLifePoints(this.lifePointsToAdd);
    }
    
}
