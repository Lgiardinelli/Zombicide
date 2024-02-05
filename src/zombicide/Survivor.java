package zombicide;

public class Survivor extends Actor{
	
	private int skillPoints;
	private BackPack backpack;
	private Weapon handleWeapon;
	
	
	public Survivor() {
		this.actionPoints = 3;
		this.lifePoints = 5;
	}
}
