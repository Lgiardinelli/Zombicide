package zombicide.actor.zombie;

import zombicide.actor.Zombie;

public class Abomination extends Zombie {
	public Abomination() {
		this.attackPoints = 3;
		this.actionPoints = 1;
		this.lifePoints = 6;
		this.isStrong = true;
	}
	
	public boolean getIsStrong() {
		return this.isStrong;
	}
}
