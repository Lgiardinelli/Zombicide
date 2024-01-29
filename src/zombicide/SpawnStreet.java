package zombicide;

public class SpawnStreet extends Street {

    public SpawnStreet(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void display() {
        System.out.print("C  ");
    }

	
<<<<<<< HEAD
=======
	public SpawnStreet(int posX, int posY) {
		super(posX, posY);
	}
	
	@Override
	public String toString() {
		return "| O ";
	}
>>>>>>> branch 'main' of git@gitlab-etu.fil.univ-lille.fr:leo.giardinelli.etu/l2s4-projet-2024.git
}
