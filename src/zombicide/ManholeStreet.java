package zombicide;

public class ManholeStreet extends Street {

	public ManholeStreet(int posX, int posY) {
		super(posX, posY);
	}
	
	@Override
	public String toString() {
		return "| _ ";
	}
}
