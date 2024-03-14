package zombicide.item;

import zombicide.action.survivor.AreaAction;
import zombicide.actor.survivor.Survivor;

public class InfraredGlasses implements Item {
	public boolean isNoisy = false;

	private Survivor survivor;
	public InfraredGlasses() {
		this.survivor = null;
	}

	public String toString(){
		return "infrared glasses";
	}

	public void setSurvivor(Survivor s){
		this.survivor =s;
	}

	@Override
	public void use() {
		AreaAction a = new AreaAction(this.survivor);
		a.doSomething();
	}
}
