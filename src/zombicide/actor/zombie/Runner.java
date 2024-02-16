package zombicide.actor.zombie;

import zombicide.actor.Zombie;

public class Runner extends Zombie {
	public Runner() {
		super(1,false);
		this.actionPoints = 2;
		this.lifePoints = 1;
	}

	@Override
	protected void handleAction() {

	}
}
