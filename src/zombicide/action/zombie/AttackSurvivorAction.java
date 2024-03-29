package zombicide.action.zombie;

import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.util.listchooser.RandomListChooser;

import java.util.List;

public class AttackSurvivorAction implements ZombieAction {
    private static final RandomListChooser<Survivor> SURVIVOR_CHOOSER = new RandomListChooser<>();

    @Override
    public void doSomething(Zombie zombie) {
        List<Survivor> survivors = zombie.getArea().getSurvivors();
        Survivor s = this.chooseRandomSurvivor(survivors);
        if (s != null)
            s.removeLifePoints(zombie.getAttackPoints());
    }

    protected Survivor chooseRandomSurvivor(List<Survivor> survivors) {
        return SURVIVOR_CHOOSER.choose(survivors);
    }
}
