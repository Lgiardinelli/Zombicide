package zombicide;

public abstract class Actor {
	private int lifePoints;
	private int actionPoints;
	
	public Actor() {
		this.actionPoints = 3;
		this.lifePoints = 5;
	}
	
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
	
	
}
