package zombicide;

public class SpawnStreet extends Street {
	
	public SpawnStreet(int posX, int posY) {
		super(posX, posY);
	}
	
	@Override
	public String toString() {
		return "| O ";
	}
}
