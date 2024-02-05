package zombicide;

public abstract class Actor {
	protected int lifePoints;
	protected int actionPoints;
	
	public int getLifePoints() {
		return lifePoints;
	}
	
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	
	public int getActionPoints() {
		return actionPoints;
	}
	
	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}
	
	public void movePlayer() {
	}
	
	public void attack() {}
	
	
}
