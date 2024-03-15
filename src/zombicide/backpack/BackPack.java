package zombicide.backpack;

import zombicide.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a backpack that can hold items.
 */
public class BackPack {

    /**
     * List to store items in the backpack.
     */
    private final List<Item> items;

    /**
     * Constructor for the BackPack class. Initializes an empty list of items.
     */
    public BackPack() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds the specified item to the backpack if the backpack is not full.
     *
     * @param item The item to be added to the backpack.
     */
    public void addItem(Item item) {
        if (canBeAdded()) {
            this.items.add(item);
        }
    }

    /**
     * Removes the specified item from the backpack if the backpack is not empty.
     *
     * @param item The item to be removed from the backpack.
     */
    public void removeItem(Item item) {
        if (!this.items.isEmpty()) {
            this.items.remove(item);
        }
    }

    /**
     * Returns the list of items currently held or stored by the survivor.
     *
     * @return A List of Item objects representing the items held or stored by the survivor.
     */
    public List<Item> getItems() {
        return items;
    }

    public void swapItems(Item fromRoom, Item fromBp) {

    }

    public boolean canBeAdded(){
        return this.items.size() == 5;
    }
}
