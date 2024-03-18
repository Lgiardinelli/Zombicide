package zombicide.actor.action;

import zombicide.item.Item;

public class ItemAction implements ActorAction {

    private Item itemUsed;

    public ItemAction(Item i){
        this.itemUsed = i;
    }
    @Override
    public void doSomething(){
        itemUsed.use();
    }
}
