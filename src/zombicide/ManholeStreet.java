package zombicide;

public class ManholeStreet extends Street {

	public ManholeStreet(int posX, int posY) {
		super(posX, posY);
	}
	
	@Override
	public void  display() {
		if (this.isTop == 0) {
			System.out.print("-----");
			this.isTop = 1;
		}
		else if (this.isTop == 1){
			if (this.getDoor(DoorDirection.LEFT).isOpen()) {
				System.out.print("  M  ");
				this.isTop = 2;
			}
			else {
				System.out.print("| M  ");
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
