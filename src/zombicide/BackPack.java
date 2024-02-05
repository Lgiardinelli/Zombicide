package zombicide;

import java.util.ArrayList;
import java.util.List;

public class BackPack {
	
	private List<Item> items;
	
	public BackPack() {
		this.items = new ArrayList<>();
	}
	
	
	public void addItem(Item i) {
		this.items.add(i);
	}
	
}
