package zombicide.weapon;

import zombicide.Weapon;

public class Crowbar extends Weapon{
	
	
	public Crowbar() {
		this.nbDiceThrows = 1;
		this.diceThreshold = 4;
		this.damage = 1;
		this.minHittingRange = 0;
		this.maxHittingRange = 0;
	}
	
}
