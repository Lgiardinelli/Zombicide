package zombicide.action.survivor;

import zombicide.action.SurvivorAction;
import zombicide.item.Item;

public class ItemAction implements SurvivorAction {

    private Item itemUsed;

    public ItemAction(Item i){
        this.itemUsed = i;
    }
    @Override
    public void doSomething(){
        itemUsed.use();
    }
}
