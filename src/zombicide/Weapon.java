package zombicide;

import java.util.Random;


public abstract class Weapon implements Item {

    private int nbDiceThrows;
    private int diceThreshold;
    private int damage;
    private int minHittingRange;
    private int maxHittingRange;

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
