package zombicide.actor.zombie;

import zombicide.city.City;

public class Balaise extends Zombie{
	public Balaise(City c) {
		super(2,true,c);
		this.actionPoints = 1;
		this.lifePoints = 4;
	}

	@Override
	public void handleAction() {

	}
}
