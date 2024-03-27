package zombicide.action.zombie;

import zombicide.action.zombie.ZombieAction;
import zombicide.actor.survivor.Survivor;
import zombicide.util.listchooser.RandomListChooser;

import java.util.List;

public class AttackSurvivorAction extends ZombieAction {
    private static final RandomListChooser<Survivor> SURVIVOR_CHOOSER = new RandomListChooser<>();

    @Override
    public void doSomething() {
        List<Survivor> survivors = this.zombie.getArea().getSurvivors();
        Survivor s = this.chooseRandomSurvivor(survivors);
        if (s != null)
            s.removeLifePoints(this.zombie.getAttackPoints());
    }

    protected Survivor chooseRandomSurvivor(List<Survivor> survivors) {
        return SURVIVOR_CHOOSER.choose(survivors);
    }
}
