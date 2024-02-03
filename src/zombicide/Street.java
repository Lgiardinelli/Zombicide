package zombicide;

public class Street extends Area {

	public Street(int posX, int posY) {
		super(posX, posY);
	}

	@Override
	public void  display() {
		if (this.isTop) {
			System.out.print("-----");
			this.isTop = false;
		}
		else {
			System.out.print("  S  ");
			this.isTop = true;
		}
	}
}
