package zombicide.item.weapon;

import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;

import java.util.Random;


public abstract class Weapon implements Item {
	private static final Random RANDOM = new Random();
    protected int nbDiceThrows;
    protected int diceThreshold;
    protected int damage;
    protected int minHittingRange;
    protected int maxHittingRange;
    protected boolean isNoisy;
	private int lastShotValue;

	private Survivor survivor;


    public Weapon(int nbDiceThrows, int diceThreshold, int damage, int minHittingRange, int maxHittingRange,
			boolean isNoisy) {
		this.nbDiceThrows = nbDiceThrows;
		this.diceThreshold = diceThreshold;
		this.damage = damage;
		this.minHittingRange = minHittingRange;
		this.maxHittingRange = maxHittingRange;
		this.isNoisy = isNoisy;
		this.lastShotValue = 0;
		this.survivor=null;
	}

	/**
     * Performs the shooting action with the weapon, rolling dice and calculating the result.
     *
     * @return The total result obtained by rolling the dice.
     */
    public int shoot() {
		lastShotValue = 0;
        for (int i = 0; i < this.nbDiceThrows; i++) {
            lastShotValue += throwOneDie();
        }
		return lastShotValue;
    }
    
    private int throwOneDie() {
		return RANDOM.nextInt(6) + 1;
	}
    
    /**
     * Checks if the weapon can successfully shoot based on the dice throws and threshold.
     *
     * @return if the weapon can shoot successfully, otherwise.
     */
    public boolean shotHitsTarget() {
        return lastShotValue >= this.diceThreshold;
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
