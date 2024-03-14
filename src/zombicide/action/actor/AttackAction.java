package zombicide.action.actor;

import zombicide.action.ActorAction;
import zombicide.action.SurvivorAction;
import zombicide.actor.survivor.Survivor;
import zombicide.item.weapon.Weapon;

public class AttackAction implements ActorAction {

    private Survivor survivor;

    private Weapon w;

    public AttackAction(Survivor s){
        this.survivor = s;
    }
    public void attackZombie(){
        return true;
    }
}
