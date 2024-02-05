package zombicide;

public class Survivor extends Actor{
	
	private int skillPoints;
	private BackPack backpack;
	private Weapon handleWeapon;
	
	
	public Survivor() {
		this.actionPoints = 3;
		this.lifePoints = 5;
	}
	
	public void handleWeapon(Weapon weapon) {
		if(this.handleWeapon != null) {
			this.backpack.addEquipement(this.handleWeapon);
		}
		this.handleWeapon = weapon;
	}
}
