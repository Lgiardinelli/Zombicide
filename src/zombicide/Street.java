package zombicide;

public class Street extends Area {
	
	protected boolean isVerticaly;

	public Street(int posX, int posY) {
		super(posX, posY);
		this.isVerticaly = true;
	}

	@Override
	public void  display() {
		if (this.isTop == 0) {
			System.out.print("-----");
			this.isTop = 1;
		}
		else if (this.isTop == 1){
			if (this.getDoor(DoorDirection.LEFT).isOpen()) {
				System.out.print("  S  ");
				this.isTop = 2;
			}
			else {
				System.out.print("| S  ");
				this.isTop = 2;
			}
			
		}
		else {
			if (this.getDoor(DoorDirection.LEFT).isOpen()) {
				System.out.print("     ");
				this.isTop = 2;
			}
			else {
				System.out.print("|    ");
				this.isTop = 2;
			}
		}
	}
}
