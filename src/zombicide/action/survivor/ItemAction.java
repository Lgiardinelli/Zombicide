package zombicide.action.survivor;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;

/**
 * An action representing a Survivor using an item they are currently holding.
 * The Survivor can use this action to use the item currently in their hand.
 */
public class ItemAction implements Action<Survivor> {

    /**
     * Performs the action of using the item currently held by the Survivor.
     * This action triggers the use method of the item and consumes an action point.
     *
     * @param survivor The Survivor performing the item action.
     */
    @Override
    public void doSomething(Survivor survivor) {
        Item itemUsed = survivor.getItemHeld();
        itemUsed.use();
        survivor.removeActionPoint();
    }

    public String toString() {
        return "Item action";
    }
}
