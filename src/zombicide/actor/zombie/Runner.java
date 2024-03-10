package zombicide.actor.zombie;

public class Runner extends Zombie {
	public Runner() {
		super(1,false);
		this.actionPoints = 2;
		this.lifePoints = 1;
	}

	@Override
	public void handleAction() {

	}
}
