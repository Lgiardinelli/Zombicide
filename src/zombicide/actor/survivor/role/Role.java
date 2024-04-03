package zombicide.actor.survivor.role;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;

public interface Role extends Action<Survivor> {
    default boolean extendsAction(Action<Survivor> action) {
        return action.getClass().isAssignableFrom(this.getClass());
    }

    @Override
    void doSomething(Survivor actor);
}
