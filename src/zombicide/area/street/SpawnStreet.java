package zombicide.area.street;

import zombicide.area.Street;

public class SpawnStreet extends Street {

    public SpawnStreet(int posX, int posY) {
        super(posX, posY);
    }

    @Override
	public void  display(int n) {
    	if (n == 0) {
			System.out.print(OPEN_UP);
		}
		else if (n == 1){
			System.out.print("  _  ");
		}
		else {
			System.out.print("     ");
		}
	}
}
