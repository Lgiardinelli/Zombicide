package zombicide.actor;

import zombicide.Actor;

public abstract class Zombie extends Actor {
	protected int attackPoints;
	protected boolean isStrong;
	
	public boolean getIsStrong() {
		return this.isStrong;
	}
	
	public int getAttackPoints() {
		return this.attackPoints;
	}
}
