package zombicide.actor.action;

import zombicide.actor.action.ActorAction;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;
import zombicide.item.weapon.Weapon;
import java.util.List;
import java.util.Random;

public class AttackAction implements ActorAction {

    private Survivor survivor;

    private Zombie zombie;
    private Weapon weapon;
    private static final Random RANDOM = new Random();

    public AttackAction(Survivor s, Zombie z) {
        this.survivor = s;
        this.zombie = z;
    }

    /**
     * Performs an action on the specified Zombie.
     * If the weapon shot hits the target, reduces the Zombie's life points by the weapon's damage.
     *
     */
    public void doSomething() {
        if (this.zombie == null) {
            zombieAttacked();
        }
        else {
            survivorAttacked();
        }
    }

    private Zombie chooseZombieList(List<Zombie> l) {
        int randomZombie = RANDOM.nextInt(l.size());
        return l.get(randomZombie);
    }

    private void zombieAttacked() {
        Item handleItem =  this.survivor.getHandleItem();
        if (handleItem.canAttack()) {
            Weapon weapon = (Weapon) handleItem;
            weapon.shoot();
            if (weapon.shotHitsTarget()) {
                List<Zombie> l = weapon.shootRange();
                Zombie zombie = chooseZombieList(l);
                if (!(zombie.getIsStrong() && weapon.getDamage() < 2)) {
                    zombie.removeLifePoints(this.weapon.getDamage());
                    if (zombie.getLifePoints() <= 0) {
                        l.remove(zombie);
                        this.survivor.addSkillPoints(1);
                    }
                }
            }
        }
    }

    private void survivorAttacked () {
        List<Survivor> l = this.zombie.getArea().getSurvivors();
        Survivor s = chooseSurvivorList(l);
        s.removeLifePoints(this.zombie.getAttackPoints());
    }

    private Survivor chooseSurvivorList(List<Survivor> l) {
        int randomSurvivor = RANDOM.nextInt(l.size());
        return l.get(randomSurvivor);
    }


}
