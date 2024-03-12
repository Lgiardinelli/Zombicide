package zombicide.actor.zombie;

import zombicide.city.City;

public class Abomination extends Zombie {
	public Abomination(City c) {
		super(3, true,c);
		this.actionPoints = 1;
		this.lifePoints = 6;
	}

	@Override
	public void handleAction() {

	}
}
