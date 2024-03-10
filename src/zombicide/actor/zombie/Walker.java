package zombicide.actor.zombie;

public class Walker extends Zombie {
	
	public Walker() {
		super(1,false);
		this.actionPoints = 1;
		this.lifePoints = 1;
	}

	@Override
	public void handleAction() {

	}
}

