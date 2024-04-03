package zombicide.action.survivor;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;

public class ItemAction implements Action<Survivor> {

    @Override
    public void doSomething(Survivor survivor){
        Item itemUsed = survivor.getItemHeld();
        itemUsed.use();
        survivor.removeActionPoint();
    }
}
