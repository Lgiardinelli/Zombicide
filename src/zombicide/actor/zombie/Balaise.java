package zombicide.actor.zombie;

public class Balaise extends Zombie{
	public Balaise() {
		super(2,true);
		this.actionPoints = 1;
		this.lifePoints = 4;
	}

	@Override
	protected void handleAction() {

	}
}
