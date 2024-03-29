package zombicide.action.zombie;

import zombicide.action.Action;
import zombicide.actor.zombie.Zombie;

public interface ZombieAction extends Action {
    void doSomething(Zombie zombie);
}
