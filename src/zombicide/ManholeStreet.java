package zombicide;

public class ManholeStreet extends Street {

	public ManholeStreet(int posX, int posY) {
		super(posX, posY);
	}
	
	@Override
	public void  display() {
		if (this.isTop) {
			System.out.print("-----");
			this.isTop = false;
		}
		else {
			System.out.print("  M  ");
			this.isTop = true;
		}
	}
}
