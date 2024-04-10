package zombicide.action.survivor;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.item.Item;
import zombicide.item.weapon.Weapon;
import zombicide.util.listchooser.RandomListChooser;

import java.util.List;
import java.util.Random;

/**
 * An action representing a Survivor attacking a Zombie with a weapon.
 * This action consumes one action point from the Survivor.
 */
public class AttackZombieAction implements Action<Survivor> {
    private static final RandomListChooser<Zombie> ZOMBIE_CHOOSER = new RandomListChooser<>();
    protected static final Random RANDOM_DIE_VALUE = new Random();

    /**
     * Performs the action of attacking a Zombie with a weapon.
     * If the Survivor does not have a weapon that can attack, the action does nothing.
     *
     * @param survivor The Survivor performing the action.
     */
    @Override
    public void doSomething(Survivor survivor) {
        survivor.removeActionPoint();
        Item itemHeld = survivor.getItemHeld();
        if (!(itemHeld instanceof Weapon)) {
            return;
        }

        Weapon weapon = (Weapon) itemHeld;

        List<Zombie> zombies = weapon.shootRange();
        if (zombies.isEmpty()) {
            return;
        }

        Zombie zombie = chooseRandomZombie(zombies);
        shootZombie(survivor, zombie, weapon);
    }

    /**
     * Shoots the specified Zombie with the Survivor's weapon.
     * Determines if the shot hits based on the weapon's dice throws.
     * If the attack is successful, damages the Zombie and grants the Survivor skill points if the Zombie is defeated.
     *
     * @param survivor The Survivor performing the attack.
     * @param zombie   The Zombie being attacked.
     * @param weapon   The weapon used for the attack.
     */
    private void shootZombie(Survivor survivor, Zombie zombie, Weapon weapon) {
        int highestDieValue = getHighestDieValue(weapon.getNbDiceThrows());

        if (weapon.shotHitsTarget(highestDieValue)) {
            attackZombie(survivor, zombie, weapon);
        }
    }

    /**
     * Attacks the specified Zombie with the Survivor's weapon.
     * Checks if the Zombie is strong and the weapon can damage it sufficiently.
     * Reduces the Zombie's life points and grants skill points to the Survivor if the Zombie is defeated.
     *
     * @param survivor The Survivor performing the attack.
     * @param zombie   The Zombie being attacked.
     * @param weapon   The weapon used for the attack.
     */
    private void attackZombie(Survivor survivor, Zombie zombie, Weapon weapon) {
        if (zombie.getIsStrong() && weapon.getDamage() < 2) {
            System.out.printf("the zombie attacked is too strong for the weapon's survivor !");
            return;
        }

        if(survivor.getArea().isContinental()){
            System.out.printf("the survivor is in the continental, he can't attack !");
            return;
        }

        zombie.removeLifePoints(weapon.getDamage());
        if (zombie.isDead()) {
            survivor.addSkillPoints(1);
            System.out.println("the zombie attacked is dead, the survivor won a skill point !");
            if(survivor.isLevelReached()){
                survivor.increaseActionPoints();
                System.out.println("the survivor reached stage "+survivor.getSkillPoints()+", his action points increased !");
            }
        }
    }

    /**
     * Throws one die with 6 sides and returns the result.
     *
     * @return The result of the die throw.
     */
    protected int throwOneDie() {
        return RANDOM_DIE_VALUE.nextInt(6) + 1;
    }

    /**
     * Chooses a random Zombie from the list of available Zombies.
     *
     * @param zombies The list of Zombies to choose from.
     * @return A randomly chosen Zombie.
     */
    protected Zombie chooseRandomZombie(List<Zombie> zombies) {
        return ZOMBIE_CHOOSER.choose(zombies);
    }

    /**
     * Gets the highest value after throwing the specified number of dice.
     *
     * @param nbDiceThrows The number of dice to throw.
     * @return The highest value obtained after throwing the dice.
     */
    private int getHighestDieValue(int nbDiceThrows) {
        int dieValue = 0;
        for (int i = 0; i < nbDiceThrows; i++) {
            int actual = throwOneDie();
            if (actual > dieValue) {
                dieValue = actual;
            }
        }
        return dieValue;
    }

    public String toString() {
        return "Attack zombie action";
    }
}
