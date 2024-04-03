package zombicide.actor;

import zombicide.action.Action;

import java.util.List;

public interface ActorHandler<T extends Actor> {
    void handleAction(List<Action<T>> actions);
}
