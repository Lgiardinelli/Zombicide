package zombicide.action.zombie;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.util.listchooser.RandomListChooser;

import java.util.List;

/**
 * A class representing the action of a Zombie attacking a Survivor in the game.
 * When executed, a Zombie will attack a random Survivor in its current area.
 */
public class AttackSurvivorAction implements Action<Zombie> {
    private static final RandomListChooser<Survivor> SURVIVOR_CHOOSER = new RandomListChooser<>();

    /**
     * Executes the attack action of the Zombie.
     * The Zombie will attack a random Survivor in its current area.
     *
     * @param zombie The Zombie performing the attack.
     */
    @Override
    public void doSomething(Zombie zombie) {
        if(zombie.getArea().isContinental())
            return;

        List<Survivor> survivors = zombie.getArea().getSurvivors();
        Survivor s = this.chooseRandomSurvivor(survivors);
        if (s != null)
            s.removeLifePoints(zombie.getAttackPoints());
        else {
            System.out.println("No survivor in this cell");
        }
    }

    /**
     * Chooses a random Survivor from the given list of survivors.
     *
     * @param survivors The list of Survivors to choose from.
     * @return A random Survivor from the list, or null if the list is empty.
     */
    protected Survivor chooseRandomSurvivor(List<Survivor> survivors) {
        return SURVIVOR_CHOOSER.choose(survivors);
    }

    public String toString () {
        return "AttackSurvivor Action";
    }
}
