package zombicide.action.survivor;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;
import zombicide.city.area.Area;
import zombicide.city.area.room.Room;
import zombicide.actor.survivor.backpack.BackPack;
import zombicide.item.Item;

public class RummageAction extends SurvivorAction {

    /**
     * Displays the items in the rooms around the Survivor's current position.
     * This action retrieves adjacent areas and displays the items they contain.
     */
    public void doSomething(){
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
        rummage();
        this.survivor.removeActionPoint();
    }

    /**
     * Allows the survivor to rummage through the current room, picking up an item randomly.
     * If the survivor has space in their backpack, the chosen item from the room is added to the backpack.
     * If the backpack is full, the method swaps a randomly chosen item from the backpack with the chosen item from the room.
     */
    private void rummage() {
        Area area = this.survivor.getArea();

        if (!area.isARoom())
            return;

        Room room = (Room) area;
        BackPack backpack = this.survivor.getBackpack();

        if (room.hasItems())
            return;

        Item roomItem = room.getRandomItem();

        if (backpack.stillHaveSpace())
            backpack.addItem(roomItem);
        else {
            Item oldBpItem = backpack.addItem(roomItem);
            room.addItem(oldBpItem);
        }
    }
}
