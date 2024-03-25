package zombicide.item.careItem;

import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;

public abstract class CareItem extends Item {
	public CareItem(){
		super();
		this.isNoisyUse = true;
	}

	public void use() {

	}
}
