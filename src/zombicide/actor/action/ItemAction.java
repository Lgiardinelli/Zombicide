package zombicide.actor.action;

import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;

public class ItemAction implements Action {

    private Survivor survivor;

    public ItemAction(Survivor s){
        this.survivor = s;
    }
    @Override
    public void doSomething(){
        Item itemUsed = survivor.getItemHeld();
        itemUsed.use();
        this.survivor.removeActionPoint();
    }
}
