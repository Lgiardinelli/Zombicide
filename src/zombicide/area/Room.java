package zombicide.area;

import zombicide.Area;
import zombicide.BackPack;
import zombicide.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Room} class represents a room in the Zombicide game.
 * Each room can have multiple doors.
 */
public class Room extends Area {
	private static final char name = 'R';

	public List<Item> items;


	/**
	 * Constructs a room at the specified position.
	 *
	 * @param x The X-coordinate position of the room.
	 * @param y The Y-coordinate position of the room.
	 */
	public Room(int x, int y) {
		super(x, y);
		this.items = new ArrayList<>();
	}

	@Override
	protected String getName() {
		return "" + name;
	}

	public List<Item> getItems()  {
		return this.items;
	}

	public void addItem(Item i){
		this.items.add(i);
	}

	public void letItems(BackPack b){
		List<Item> list = b.getItems();
		for(Item i : list){
			addItem(i);
		}
	}
}

