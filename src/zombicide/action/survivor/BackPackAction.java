package zombicide.action.survivor;

import zombicide.action.Action;
import zombicide.actor.survivor.backpack.BackPack;
import zombicide.actor.survivor.Survivor;

public class BackPackAction extends SurvivorAction {

    public void doSomething() {
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
        holdRandomItem();
        this.survivor.removeActionPoint();
    }

    /**
     * Allows the survivor to take an item from their backpack and equip it in their hand.
     * If the survivor already has an item in their hand, the method swaps it with a randomly chosen item from the backpack.
     * If the survivor's hand is empty, the method equips a randomly chosen item from the backpack.
     */
    private void holdRandomItem() {
        BackPack backpack = survivor.getBackpack();
        if (backpack.getItems().isEmpty())
            return;

        survivor.setItemHeld(backpack.getRandomItem());
    }
}
