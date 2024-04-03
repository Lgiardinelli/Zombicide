package zombicide.actor.zombie;

import zombicide.action.Action;
import zombicide.city.City;

import java.util.List;

public class Abomination extends Zombie {
	private static final int ATTACK_POINTS = 3;
	private static final int LIFE_POINTS = 6;
	private static final int ACTION_POINTS = 1;
	private static final boolean IS_STRONG = true;

	public Abomination(City city) {
		super(ATTACK_POINTS, LIFE_POINTS, ACTION_POINTS, IS_STRONG, city);
	}

	@Override
	public void handleAction(List<Action<Zombie>> actions) {

	}
}
