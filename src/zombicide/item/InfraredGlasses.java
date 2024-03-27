package zombicide.item;

import zombicide.actor.action.AreaAction;
import zombicide.actor.survivor.Survivor;
import zombicide.city.area.Area;
import zombicide.city.area.room.Room;
import zombicide.city.City;
import zombicide.util.Direction;

public class InfraredGlasses extends Item {

	private Survivor survivor;

	public String toString(){
		return "infrared glasses";
	}

	public void use() {
		AreaAction a = new AreaAction(this.survivor);
		a.doSomething();
	}

}
