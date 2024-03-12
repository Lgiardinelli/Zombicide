package zombicide.item.careItem;

import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;

public abstract class CareItem implements Item {
	public boolean isNoisy = false;


	private Survivor survivor;


	@Override
	public void use() {

	}
}
