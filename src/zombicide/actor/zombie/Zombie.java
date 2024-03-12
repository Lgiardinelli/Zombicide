package zombicide.actor.zombie;

import zombicide.actor.Actor;
import zombicide.area.Area;
import zombicide.city.City;

/**
 * Abstract class representing a zombie actor in the game.
 */
public abstract class Zombie extends Actor {

    /** The attack points of the zombie. */
    protected int attackPoints;

    /** Indicates whether the zombie is strong or not. */
    protected boolean isStrong;

    public Zombie(int attackPoints, boolean isStrong, City city) {
		this.attackPoints = attackPoints;
		this.isStrong = isStrong;
        this.city = city;
	}

	/**
     * Gets whether the zombie is strong.
     *
     * @return {@code true} if the zombie is strong, {@code false} otherwise.
     */
    public boolean getIsStrong() {
        return this.isStrong;
    }

    /**
     * Gets the attack points of the zombie.
     *
     * @return The attack points.
     */
    public int getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public void setArea(Area area) {
        if (this.area != null) {
            this.area.removeActor(this);
        }
        this.area = area;
        area.addZombie(this);
    }
}
