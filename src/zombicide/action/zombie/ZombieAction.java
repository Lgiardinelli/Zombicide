package zombicide.action.zombie;

import zombicide.action.Action;
import zombicide.actor.zombie.Zombie;

public abstract class ZombieAction implements Action {
    protected Zombie zombie;

    @Override
    public abstract void doSomething();

    public void setZombie(Zombie zombie) {
        this.zombie = zombie;
    }
}
