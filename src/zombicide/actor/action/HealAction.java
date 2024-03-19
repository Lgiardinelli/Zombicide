package zombicide.actor.action;

import zombicide.actor.survivor.Survivor;

public class HealAction implements ActorAction {

    private final Survivor survivor;
    private int lifePointsToAdd;

    public HealAction(Survivor s){
        this.survivor =s;
    }

    public void doSomething(){
        this.heal(this.survivor);
    }

    public void setLifePointsToAdd(int n){
        this.lifePointsToAdd = n;
    }

    public void heal(Survivor s){
        s.addLifePoints(this.lifePointsToAdd);
    }
    
}
