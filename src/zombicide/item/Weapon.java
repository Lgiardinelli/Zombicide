package zombicide.item;

import java.util.Random;

import zombicide.Item;


public abstract class Weapon implements Item {

    protected int nbDiceThrows;
    protected int diceThreshold;
    protected int damage;
    protected int minHittingRange;
    protected int maxHittingRange;
    protected boolean isNoisy;

    public Weapon(int nbDiceThrows, int diceThreshold, int damage, int minHittingRange, int maxHittingRange,
			boolean isNoisy) {
		this.nbDiceThrows = nbDiceThrows;
		this.diceThreshold = diceThreshold;
		this.damage = damage;
		this.minHittingRange = minHittingRange;
		this.maxHittingRange = maxHittingRange;
		this.isNoisy = isNoisy;
	}

	/**
     * Performs the shooting action with the weapon, rolling dice and calculating the result.
     *
     * @return The total result obtained by rolling the dice.
     */
    public int shoot() {
        Random random = new Random();
        int result = 0;
        for (int i = 0; i < this.nbDiceThrows; i++) {
            result += random.nextInt(6) + 1;
        }
        return result;
    }
    
    
    
    /**
     * Checks if the weapon can successfully shoot based on the dice throws and threshold.
     *
     * @return if the weapon can shoot successfully, otherwise.
     */
    public boolean canShoot() {
        int result = shoot();
        return result >= this.diceThreshold;
    }

    
    

	public int getNbDiceThrows() {
		return nbDiceThrows;
	}

	public int getDiceThreshold() {
		return diceThreshold;
	}

	public int getDamage() {
		return damage;
	}

	public int getMinHittingRange() {
		return minHittingRange;
	}

	public int getMaxHittingRange() {
		return maxHittingRange;
	}
    
    
}
