package zombicide.action;

import zombicide.actor.Actor;

public abstract class ActorAction implements Action {
    protected Actor actor;

    public abstract void doSomething(Actor actor);

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
