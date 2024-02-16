package zombicide.actor.zombie;

import zombicide.actor.Zombie;

public class Abomination extends Zombie {
	public Abomination() {
		super(3, true);
		this.actionPoints = 1;
		this.lifePoints = 6;
	}

	@Override
	protected void handleAction() {

	}
}
