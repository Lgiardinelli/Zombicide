package zombicide.actor.zombie;

import zombicide.actor.Zombie;

public class Balaise extends Zombie{	
	public Balaise() {
		this.actionPoints = 1;
		this.lifePoints = 4;
		this.attackPoints = 2;
		this.isStrong = true;
	}
	
	public boolean getIsStrong() {
		return this.isStrong;
	}
}
