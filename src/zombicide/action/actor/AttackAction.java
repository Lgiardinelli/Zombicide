package zombicide.action.actor;

import zombicide.action.ActorAction;
import zombicide.action.SurvivorAction;
import zombicide.actor.Zombie;
import zombicide.actor.survivor.Survivor;
import zombicide.item.weapon.Weapon;

public class AttackAction implements ActorAction {

    private Survivor survivor;

    private Weapon weapon;

    public AttackAction(Survivor s){
        this.survivor = s;
    }
}
