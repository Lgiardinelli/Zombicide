package zombicide.actor.zombie;

import zombicide.action.Action;
import zombicide.actor.Actor;
import zombicide.city.area.Area;
import zombicide.city.City;
import zombicide.city.area.street.Manhole;
import zombicide.util.listchooser.RandomListChooser;

import java.util.List;

/**
 * Abstract class representing a zombie actor in the game.
 */
public abstract class Zombie extends Actor {

    /** The attack points of the zombie. */
    protected int attackPoints;

    /** Indicates whether the zombie is strong or not. */
    protected boolean isStrong;
    private static final RandomListChooser<Manhole> MANHOLE_CHOOSER = new RandomListChooser<>();

    public Zombie(int attackPoints, int lifePoints, int actionPoints, boolean isStrong, City city) {
        super(city, lifePoints, actionPoints);
		this.attackPoints = attackPoints;
		this.isStrong = isStrong;
        this.setArea(chooseRandomManhole());
	}

    private Manhole chooseRandomManhole() {
        return MANHOLE_CHOOSER.choose(this.city.getManholes());
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
    public abstract void handleAction();

    @Override
    public void setArea(Area area) {
        if (this.area != null) {
            this.area.removeActor(this);
        }
        this.area = area;
        area.addZombie(this);
    }
}
