package zombicide.actor.zombie;

import zombicide.city.City;

public class Runner extends Zombie {
	public Runner(City c) {
		super(1,false, c);
		this.actionPoints = 2;
		this.lifePoints = 1;
	}

	@Override
	public void handleAction() {

	}
}
