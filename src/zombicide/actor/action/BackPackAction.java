package zombicide.actor.action;


import zombicide.actor.survivor.Survivor;
import zombicide.actor.survivor.backpack.BackPack;
import zombicide.item.Item;
import zombicide.util.listchooser.RandomListChooser;

import java.util.List;

public class BackPackAction implements ActorAction {

    private Survivor survivor;

    public BackPackAction(Survivor s){
        this.survivor = s;
    }

    public void doSomething() {
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
        takeOnHand();
    }

    public void takeOnHand(){
        BackPack bp = this.survivor.getBackpack();
        List<Item> itemsBp = bp.getItems();
        RandomListChooser<Item> chooser = new RandomListChooser<>();
        Item bpItem = chooser.choose(itemsBp);

        Item handItem = this.survivor.getHandleItem();
        if(handItem != null) {
            bp.swapItemsHandBp(handItem , bpItem);
        }else{
            bp.takeAItem(bpItem);
        }
    }



}
