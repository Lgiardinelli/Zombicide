package zombicide.item;

import zombicide.actor.action.DoorAction;
import zombicide.actor.survivor.Survivor;

public class MasterKey extends Item {

	private Survivor survivor;

	public MasterKey(){
		super();
		this.canOpen = true;
	}
	public String toString(){
		return "master key";
	}



	public void use() {
		DoorAction d = new DoorAction(survivor);
		d.doSomething();
	}


}
