package zombicide.action.survivor;


import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.item.Item;
import zombicide.item.weapon.Weapon;
import zombicide.util.listchooser.RandomListChooser;

import java.util.List;
import java.util.Random;

public class AttackZombieAction implements Action<Survivor> {
    private static final RandomListChooser<Zombie> ZOMBIE_CHOOSER = new RandomListChooser<>();
    protected static final Random RANDOM_DIE_VALUE = new Random();

    @Override
    public void doSomething(Survivor survivor) {
        survivor.removeActionPoint();
        Item itemHeld =  survivor.getItemHeld();
        if (!itemHeld.canAttack())
            return;

        Weapon weapon = (Weapon) itemHeld;

        List<Zombie> zombies = weapon.shootRange();
        if (zombies.isEmpty())
            return;

        Zombie zombie = chooseRandomZombie(zombies);
        shootZombie(survivor, zombie, weapon);
    }

    private void shootZombie(Survivor survivor, Zombie zombie, Weapon weapon) {
        int highestDieValue = getHighestDieValue(weapon.getNbDiceThrows());

        if (weapon.shotHitsTarget(highestDieValue)) {
            attackZombie(survivor, zombie, weapon);
        }
    }

    private void attackZombie(Survivor survivor, Zombie zombie, Weapon weapon) {
        if (zombie.getIsStrong() && weapon.getDamage() < 2)
            return;

        zombie.removeLifePoints(weapon.getDamage());
        if (zombie.getLifePoints() <= 0) {
            survivor.addSkillPoints(1);
        }
    }

    private int getHighestDieValue(int nbDiceThrows) {
        int dieValue = 0;
        for (int i = 0; i < nbDiceThrows; i++) {
            int actual = throwOneDie();
            if (actual > dieValue)
                dieValue = actual;
        }
        return  dieValue;
    }

    protected int throwOneDie() {
        return RANDOM_DIE_VALUE.nextInt(6) + 1;
    }

    protected Zombie chooseRandomZombie(List<Zombie> zombies) {
        return ZOMBIE_CHOOSER.choose(zombies);
    }
}
