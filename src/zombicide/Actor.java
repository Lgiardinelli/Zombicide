package zombicide;

/**
 * Abstract class representing an actor in the game.
 */
public abstract class Actor {
    /**
     * The current area where the actor is located.
     */
    private Area area;
    /**
     * The life points of the actor.
     */
    protected int lifePoints;

    /**
     * The action points of the actor.
     */
    protected int actionPoints;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    /**
     * Retrieves the life points of the actor.
     *
     * @return the life points of the actor
     */
    public int getLifePoints() {
        return lifePoints;
    }

    /**
     * Sets the life points of the actor.
     *
     * @param lifePoints the life points to set
     */
    public void addLifePoints(int lifePoints) {
        this.lifePoints += lifePoints;
    }

    /**
     * Retrieves the action points of the actor.
     *
     * @return the action points of the actor
     */
    public int getActionPoints() {
        return actionPoints;
    }

    /**
     * Sets the action points of the actor.
     *
     * @param actionPoints the action points to set
     */
    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    /**
     * Reduces the life points of the character by the specified amount of damage.
     *
     * @param damage The amount of damage to be subtracted from the character's life points.
     * @throws IllegalArgumentException If the damage value is negative.
     */
    public void removeLifePoints(int damage) {
        this.lifePoints -= damage;
    }

    protected abstract void handleAction();
}

