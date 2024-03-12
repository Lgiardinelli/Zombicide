package zombicide.item;

import zombicide.action.survivor.DoorAction;
import zombicide.actor.survivor.Survivor;

public class MasterKey implements Item {
	public boolean isNoisy = false;

	public Survivor survivor;

	public MasterKey(Survivor s) {
		this.survivor=null;
	}

	public String toString(){
		return "master key";
	}

	@Override
	public void use() {
		DoorAction d = new DoorAction(survivor);
		d.openTheDoor();
	}


}
