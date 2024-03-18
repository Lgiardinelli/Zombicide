package zombicide.actor.action;

import zombicide.actor.action.ActorAction;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.survivor.Survivor;
import zombicide.item.weapon.Weapon;

public class AttackAction implements ActorAction {

    private Survivor survivor;

    private Weapon weapon;

    public AttackAction(Survivor s){
        this.survivor = s;
    }

    /**
     * Performs an action on the specified Zombie.
     * If the weapon shot hits the target, reduces the Zombie's life points by the weapon's damage.
     *
     * @param z The Zombie on which the action is performed.
     */
    public void doSomething(Zombie z) {
        if (this.weapon.shotHitsTarget()) {
            z.removeLifePoints(this.weapon.getDamage());
        }
    }

}
