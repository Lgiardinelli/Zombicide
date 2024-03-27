package zombicide.action.survivor;


import zombicide.action.survivor.SurvivorAction;
import zombicide.actor.zombie.Zombie;
import zombicide.item.Item;
import zombicide.item.weapon.Weapon;
import zombicide.util.listchooser.RandomListChooser;

import java.util.List;

public class AttackZombieAction extends SurvivorAction {
    private static final RandomListChooser<Zombie> ZOMBIE_CHOOSER = new RandomListChooser<>();

    @Override
    public void doSomething() {
        Item itemHeld =  this.survivor.getItemHeld();
        if (!itemHeld.canAttack())
            return;

        Weapon weapon = (Weapon) itemHeld;
        int shotValue = weapon.shoot();

        if (!weapon.shotHitsTarget(shotValue))
            return;

        List<Zombie> zombies = weapon.shootRange();
        Zombie zombie = chooseRandomZombie(zombies);
        if (zombie.getIsStrong() && weapon.getDamage() < 2)
            return;

        zombie.removeLifePoints(weapon.getDamage());
        if (zombie.getLifePoints() <= 0) {
            zombies.remove(zombie);
            this.survivor.addSkillPoints(1);
        }
    }

    protected Zombie chooseRandomZombie(List<Zombie> zombies) {
        return ZOMBIE_CHOOSER.choose(zombies);
    }
}
