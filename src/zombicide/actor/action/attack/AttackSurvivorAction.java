package zombicide.actor.action.attack;

import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;

import java.util.ArrayList;
import java.util.List;

public class AttackSurvivorAction extends AttackAction {

    public AttackSurvivorAction(Zombie zombie) {
        super(zombie);
    }

    @Override
    public void doSomething() {
        Zombie zombie = (Zombie) this.actor;
        List<Actor> l = new ArrayList<>(zombie.getArea().getSurvivors());
        Survivor s = (Survivor) this.chooseRandomActor(l);
        if (s != null)
            s.removeLifePoints(zombie.getAttackPoints());
    }
}
