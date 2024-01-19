package zombicide;

public abstract class Actor {
	private int lifePoints;
	private int actionPoints;
	
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
}
