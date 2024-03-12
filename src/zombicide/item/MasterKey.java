package zombicide.item;

import zombicide.action.survivor.DoorAction;
import zombicide.actor.survivor.Survivor;

public class MasterKey implements Item {
	public boolean isNoisy = false;

	public Survivor survivor;

	public MasterKey() {
		this.survivor=null;
	}

	public String toString(){
		return "master key";
	}

	public void setSurvivor(Survivor s){
		this.survivor =s;
	}

	@Override
	public void use() {
		DoorAction d = new DoorAction(survivor);
		d.openTheDoor();
	}


}
