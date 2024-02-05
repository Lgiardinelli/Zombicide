package zombicide;

import java.util.ArrayList;
import java.util.List;

public class BackPack {

    private List<Item> items;

    public BackPack() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds the specified item to the backpack if the backpack is not full.
     *
     * @param item The item to be added to the backpack.
     */
    public void addItem(Item item) {
        if (this.items.size() < 5) {
            this.items.add(item);
        }
    }

    /**
     * Removes the specified item from the backpack if the backpack is not empty.
     *
     * @param item The item to be removed from the backpack.
     */
    public void removeItem(Item item) {
        if (this.items.size() >= 1) {
            this.items.remove(item);
        }
    }
}
