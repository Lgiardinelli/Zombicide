package zombicide;

public class SpawnStreet extends Street {

    public SpawnStreet(int posX, int posY) {
        super(posX, posY);
    }

    @Override
	public void  display() {
    	if (this.isTop == 0) {
			System.out.print(".   .");
			this.isTop = 1;
		}
		else if (this.isTop == 1){
			System.out.print("  _  ");
			this.isTop = 2;
		}
		else {
			System.out.print("     ");
			this.isTop = 0;
		}
	}
}
