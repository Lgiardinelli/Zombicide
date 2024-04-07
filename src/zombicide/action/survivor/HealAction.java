package zombicide.action.survivor;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;

public class HealAction implements Action<Survivor> {
    private int lifePointsToAdd;

    public void doSomething(Survivor survivor){
        this.heal(survivor);
        survivor.removeActionPoint();
    }

    public void setLifePointsToAdd(int n){
        this.lifePointsToAdd = n;
    }

    public void heal(Survivor survivor){
        survivor.addLifePoints(this.lifePointsToAdd);
    }
}
