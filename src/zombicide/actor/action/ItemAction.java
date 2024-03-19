package zombicide.actor.action;

import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;

public class ItemAction implements ActorAction {

    private Survivor survivor;

    public ItemAction(Survivor s){
        this.survivor = s;
    }
    @Override
    public void doSomething(){
        Item itemUsed = survivor.getHandleItem();
        itemUsed.use();
    }
}
