package zombicide.item;

import zombicide.action.survivor.AreaAction;
import zombicide.actor.survivor.Survivor;

public class InfraredGlasses extends Item {

	public String toString(){
		return "infrared glasses";
	}

	public void use() {
		AreaAction a = new AreaAction();
		a.doSomething(survivor);
	}
}
