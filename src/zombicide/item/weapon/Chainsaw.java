package zombicide.item.weapon;

import zombicide.item.Weapon;

public class Chainsaw extends Weapon{
	
	
	public Chainsaw() {
		this.nbDiceThrows = 2;
		this.diceThreshold = 5;
		this.damage = 3;
		this.minHittingRange = 0;
		this.maxHittingRange = 0;
	}
	
}
