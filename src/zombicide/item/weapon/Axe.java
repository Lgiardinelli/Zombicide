package zombicide.item.weapon;

import zombicide.item.Weapon;

public class Axe extends Weapon{
	
	
	public Axe() {
		this.nbDiceThrows = 1;
		this.diceThreshold = 4;
		this.damage = 2;
		this.minHittingRange = 0;
		this.maxHittingRange = 0;
	}
	
}
