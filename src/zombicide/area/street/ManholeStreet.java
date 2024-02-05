package zombicide;

public class ManholeStreet extends Street {

	public ManholeStreet(int posX, int posY) {
		super(posX, posY);
	}
	
	@Override
	public void  display(int n) {
		if (n == 0) {
			System.out.print("-----");
		}
		else if (n == 1){
			if (this.getDoor(DoorDirection.LEFT).isOpen()) {
				System.out.print("  M  ");
			}
			else {
				System.out.print("| M  ");
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
