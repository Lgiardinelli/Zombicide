package zombicide.action.survivor;

import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;

public class ItemAction implements SurvivorAction {

    @Override
    public void doSomething(Survivor survivor){
        Item itemUsed = survivor.getItemHeld();
        itemUsed.use();
        survivor.removeActionPoint();
    }
}
