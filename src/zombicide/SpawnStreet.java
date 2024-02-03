package zombicide;

public class SpawnStreet extends Street {

    public SpawnStreet(int posX, int posY) {
        super(posX, posY);
    }

    @Override
	public void  display() {
		if (this.isTop) {
			System.out.print(".    ");
			this.isTop = false;
		}
		else {
			System.out.print("  _  ");
			this.isTop = true;
		}
	}
}
