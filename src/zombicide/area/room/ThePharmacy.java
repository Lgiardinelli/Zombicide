package zombicide.area.room;

import zombicide.area.Room;

public class ThePharmacy extends Room {

	public ThePharmacy(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public boolean canFight() {
		return true;
	}

	@Override
	public void display(int n) {
		System.out.print("  F  ");
	}
}
