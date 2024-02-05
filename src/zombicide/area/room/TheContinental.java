package zombicide.area.room;

import zombicide.area.Room;

public class TheContinental extends Room {

	public TheContinental(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean canFight() {
		return false;
	}
}
