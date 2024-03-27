package zombicide.action.survivor;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;

public class ItemAction extends SurvivorAction {

    @Override
    public void doSomething(){
        Item itemUsed = survivor.getItemHeld();
        itemUsed.use();
        this.survivor.removeActionPoint();
    }
}
