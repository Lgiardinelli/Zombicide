package zombicide;

public class Runner extends Zombie {
	public Runner() {
		this.actionPoints = 2;
		this.attackPoints = 1;
		this.isStrong = false;
		this.lifePoints = 1;
	}
	
	public boolean getIsStrong() {
		return this.isStrong;
	}
}
