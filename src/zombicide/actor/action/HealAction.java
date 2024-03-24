package zombicide.actor.action;

import zombicide.actor.survivor.Survivor;

public class HealAction implements Action {

    private final Survivor survivor;
    private int lifePointsToAdd;

    public HealAction(Survivor s){
        this.survivor =s;
    }

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
