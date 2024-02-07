package zombicide.area.room;

import zombicide.DoorDirection;
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
		if (n == 0) {
			if (this.getDoor(DoorDirection.UP).isOpen()) {
				System.out.print(OPEN_UP);
			}
			else {
				System.out.print("-----");
			}
		}
		else if (n == 1){
			if (this.getDoor(DoorDirection.LEFT).isOpen()) {
				System.out.print("- P  ");
			}
			else {
				System.out.print("| P  ");
			}
			
		}
		else {
			if (this.getDoor(DoorDirection.LEFT).isOpen()) {
				System.out.print("-    ");
			}
			else {
				System.out.print("|    ");
			}
		}
	}
}
