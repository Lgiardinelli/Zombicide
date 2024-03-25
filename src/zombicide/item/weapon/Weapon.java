package zombicide.item.weapon;

import zombicide.actor.zombie.Zombie;
import zombicide.city.area.Area;
import zombicide.actor.survivor.Survivor;
import zombicide.city.City;
import zombicide.item.Item;
import zombicide.util.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public abstract class Weapon extends Item {
	private static final Random RANDOM = new Random();
    protected int nbDiceThrows;
    protected int diceThreshold;
    protected int damage;
    protected int minHittingRange;
    protected int maxHittingRange;
	private int lastShotValue;
	private Survivor survivor;


    public Weapon(int nbDiceThrows, int diceThreshold, int damage, int minHittingRange, int maxHittingRange) {
		super();
		this.nbDiceThrows = nbDiceThrows;
		this.diceThreshold = diceThreshold;
		this.damage = damage;
		this.minHittingRange = minHittingRange;
		this.maxHittingRange = maxHittingRange;
		this.lastShotValue = 0;
		this.canAttack = true;
		this.isNoisyDoor = true;
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

	public List<Zombie> shootRange() {
		Area areaWeapon = this.survivor.getArea();
		City city = this.survivor.getCity();
		int x = areaWeapon.getX();
		int y = areaWeapon.getY();
		List<Zombie> zombies = new ArrayList<>();
		if (this.getMinHittingRange() == 0) {
			List<Zombie> zom = city.getArea(x, y).getZombies();
			zombies.addAll(zom);
		}
		for (Direction d : Direction.values()) {
			for (int i = 1; i <= this.getMaxHittingRange(); i++) {
				x += i*d.getX();
				y += i*d.getY();
				if (this.getMinHittingRange() < i) {
					if (!(areaWeapon.isContinental())) {
						List<Zombie> zom = city.getArea(x, y).getZombies();
						zombies.addAll(zom);
					}
				}
			}
		}
		return zombies;
	}

	public void use() {
		System.out.println(shootRange());
	}
    
}
