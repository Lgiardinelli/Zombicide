package zombicide.item.weapon;

import zombicide.item.Weapon;

public class Riffle extends Weapon{
	
	
	public Riffle() {
		this.nbDiceThrows = 2;
		this.diceThreshold = 4;
		this.damage = 1;
		this.minHittingRange = 1;
		this.maxHittingRange = 3;
	}
	
}
