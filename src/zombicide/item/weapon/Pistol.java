package zombicide.item.weapon;

import zombicide.item.Weapon;

public class Pistol extends Weapon{
	
	
	public Pistol() {
		super(1,4,1,0,1,true);
	}

	public String toString(){
		return "pistol";
	}
}
