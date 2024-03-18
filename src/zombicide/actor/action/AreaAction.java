package zombicide.actor.action;

import zombicide.actor.survivor.Survivor;
import zombicide.city.area.Area;
import zombicide.city.area.room.Room;
import zombicide.actor.survivor.backpack.BackPack;
import zombicide.city.City;
import zombicide.item.Item;
import zombicide.util.listchooser.RandomListChooser;

import java.util.List;

public class AreaAction implements ActorAction {

    private Survivor survivor;

    public AreaAction(Survivor s){
        this.survivor = s;
    }

    /**
     * Displays the items in the rooms around the Survivor's current position.
     * This action retrieves adjacent areas and displays the items they contain.
     */
    public void doSomething(){
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
        rummage();
    }

    /**
     * Allows the survivor to rummage through the current room, picking up an item randomly.
     * If the survivor has space in their backpack, the chosen item from the room is added to the backpack.
     * If the backpack is full, the method swaps a randomly chosen item from the backpack with the chosen item from the room.
     */
    private void rummage() {
        Area a = this.survivor.getArea();
        City city = this.survivor.getCity();

        if (city.isARoom(a)) {
            Room r = (Room) a;
            List<Item> roomsItems = r.getItems();

            BackPack bp = this.survivor.getBackpack();

            RandomListChooser<Item> chooser = new RandomListChooser<>();

            Item chosenItemRoom = chooser.choose(roomsItems);

            if (bp.canBeAdded()) {
                bp.addItem(chosenItemRoom);
            } else {
                List<Item> bpItems = bp.getItems();

                Item chosenItemBp = chooser.choose(bpItems);

                if (chosenItemBp != null && chosenItemRoom != null) {
                    bp.swapItemsRoomBp(chosenItemRoom, chosenItemBp);
                }
            }
        }
    }

}





