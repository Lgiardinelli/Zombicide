package zombicide.action.survivor;

import zombicide.action.SurvivorAction;
import zombicide.actor.survivor.Survivor;
import zombicide.area.Area;
import zombicide.area.room.Room;
import zombicide.backpack.BackPack;
import zombicide.city.City;
import zombicide.door.Door;
import zombicide.item.Item;
import zombicide.listchooser.ListChooser;
import zombicide.listchooser.RandomListChooser;

import java.util.ArrayList;
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
            List<Item> bpItems = bp.getItems();

            RandomListChooser<Item> chooser = new RandomListChooser<>();
            Item chosenItemRoom = chooser.choose(roomsItems);
            Item chosenItemBp = chooser.choose(bpItems);

            if(chosenItemBp != null && chosenItemRoom != null){
                bp.swapItemsRoomBp(chosenItemRoom , chosenItemBp);
            }
        }
    }




}
