package zombicide.action.survivor;

import zombicide.action.SurvivorAction;
import zombicide.actor.survivor.Survivor;
import zombicide.city.area.Area;
import zombicide.city.area.room.Room;
import zombicide.actor.survivor.backpack.BackPack;
import zombicide.city.City;
import zombicide.item.Item;
import zombicide.util.listchooser.RandomListChooser;

import java.util.List;

public class AreaAction implements SurvivorAction {

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

    public void rummage(){
        Area a = this.survivor.getArea();
        City city = this.survivor.getCity();
        if(city.isARoom(a)){
            Room r = (Room) a;
            List<Item> roomsItems = r.getItems();

            BackPack bp = this.survivor.getBackpack();

            RandomListChooser<Item> chooser = new RandomListChooser<>();
            Item chosenItemRoom = chooser.choose(roomsItems);

            if(bp.canBeAdded()){
                bp.addItem(chosenItemRoom);
            }
            else{
                List<Item> bpItems = bp.getItems();

                Item chosenItemBp = chooser.choose(bpItems);

                if(chosenItemBp != null && chosenItemRoom != null){
                    bp.swapItemsRoomBp(chosenItemRoom , chosenItemBp);
                }
            }

        }
    }




}
