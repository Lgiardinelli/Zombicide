package zombicide.actor.action.attack;

import zombicide.actor.Actor;
import zombicide.actor.action.Action;
import zombicide.util.listchooser.RandomListChooser;

import java.util.List;

public abstract class AttackAction implements Action {
    protected final Actor actor;
    private static final RandomListChooser<Actor> ACTOR_CHOOSER = new RandomListChooser<>();

    public AttackAction(Actor actor) {
        this.actor = actor;
    }

    /**
     * Performs an action on the specified Zombie.
     * If the weapon shot hits the target, reduces the Zombie's life points by the weapon's damage.
     *
     */
    public abstract void doSomething();

    protected Actor chooseRandomActor(List<Actor> l) {
        return ACTOR_CHOOSER.choose(l);
    }
}
