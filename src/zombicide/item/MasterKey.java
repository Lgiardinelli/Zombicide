package zombicide.item;

import zombicide.actor.action.DoorAction;
import zombicide.actor.survivor.Survivor;

public class MasterKey extends Item {
	public boolean isNoisy = false;

	private Survivor survivor;


	public String toString(){
		return "master key";
	}



	public void use() {
		DoorAction d = new DoorAction(survivor);
		d.doSomething();
	}


}
