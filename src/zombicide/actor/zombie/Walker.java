package zombicide.actor.zombie;

import zombicide.city.City;

public class Walker extends Zombie {
	
	public Walker(City c) {
		super(1,false,c);
		this.actionPoints = 1;
		this.lifePoints = 1;
	}

	@Override
	public void handleAction() {

	}
}

