package zombicide.actor.zombie;

import zombicide.actor.Zombie;

public class Walker extends Zombie {
	
	public Walker() {
		super(1,false);
		this.actionPoints = 1;
		this.lifePoints = 1;
	}

	@Override
	protected void handleAction() {

	}
}

