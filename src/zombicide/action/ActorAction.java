package zombicide.action;

import zombicide.actor.Actor;

public abstract class ActorAction implements Action {
    protected Actor actor;

    @Override
    public abstract void doSomething();

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
