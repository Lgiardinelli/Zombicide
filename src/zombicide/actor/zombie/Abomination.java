package zombicide.actor.zombie;

public class Abomination extends Zombie {
	public Abomination() {
		super(3, true);
		this.actionPoints = 1;
		this.lifePoints = 6;
	}

	@Override
	public void handleAction() {

	}
}
