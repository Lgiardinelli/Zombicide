package zombicide;

public class Street extends Area {

	public Street(int posX, int posY) {
		super(posX, posY);
	}

	@Override
	public String toString() {
		return "| S ";
	}
}
