package zombicide.actor.action.attack;

import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.item.Item;
import zombicide.item.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class AttackZombieAction extends AttackAction {

    public AttackZombieAction(Survivor survivor) {
        super(survivor);
    }

    @Override
    public void doSomething() {
        Survivor survivor = (Survivor) this.actor;
        Item itemHeld =  survivor.getItemHeld();
        if (!itemHeld.canAttack())
            return;

        Weapon weapon = (Weapon) itemHeld;
        weapon.shoot();

        if (!weapon.shotHitsTarget())
            return;

        List<Actor> l = new ArrayList<>(weapon.shootRange());
        Zombie zombie = (Zombie) chooseRandomActor(l);
        if (zombie.getIsStrong() && weapon.getDamage() < 2)
            return;

        zombie.removeLifePoints(weapon.getDamage());
        if (zombie.getLifePoints() <= 0) {
            l.remove(zombie);
            survivor.addSkillPoints(1);
        }
    }
}
