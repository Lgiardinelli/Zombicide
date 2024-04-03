package zombicide.action;

import zombicide.actor.Actor;

public interface Action<T extends Actor> {
    default String display() {
        return getClass().getSimpleName();
    }
    void doSomething(T actor);
}
