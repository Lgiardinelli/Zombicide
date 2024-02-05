package zombicide;

public class Street extends Area {
	
	protected boolean isVerticaly;

	public Street(int posX, int posY) {
		super(posX, posY);
	}

	@Override
	public void  display(int n) {
		if (n == 0) {
			System.out.print("-----");
		}
		else if (n == 1){
			if (this.getDoor(DoorDirection.LEFT).isOpen()) {
				System.out.print("  S  ");
			}
			else {
				System.out.print("| S  ");
			}
			
		}
		else {
			if (this.getDoor(DoorDirection.LEFT).isOpen()) {
				System.out.print("     ");
			}
			else {
				System.out.print("|    ");
			}
		}
	}
}
