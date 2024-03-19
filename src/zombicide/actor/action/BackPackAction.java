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
        this.survivor.removeActionPoint();
    }

    /**
     * Allows the survivor to take an item from their backpack and equip it in their hand.
     * If the survivor already has an item in their hand, the method swaps it with a randomly chosen item from the backpack.
     * If the survivor's hand is empty, the method equips a randomly chosen item from the backpack.
     */
    public void takeOnHand() {
        BackPack bp = this.survivor.getBackpack();
        List<Item> itemsBp = bp.getItems();
        RandomListChooser<Item> chooser = new RandomListChooser<>();

        Item bpItem = chooser.choose(itemsBp);

        Item handItem = this.survivor.getHandleItem();

        if (handItem != null) {
            bp.swapItemsHandBp(handItem, bpItem);
        } else {
            bp.takeAItem(bpItem);
        }
    }




}
