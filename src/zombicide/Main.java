package zombicide;

import zombicide.actor.Survivor;
import zombicide.actor.Zombie;
import zombicide.actor.zombie.Abomination;
import zombicide.city.TrainCity;

public class Main {

	public static void main(String[] args) {
		TrainCity trainCity = new TrainCity();

		Zombie z = new Abomination();
		Zombie z2 = new Abomination();

		Survivor s = new Survivor();
		Survivor s2 = new Survivor();

		if (args.length < 2) {
			City aCity = new City(10, 10);
			
			aCity.getAreas()[0][0].getDoor(DoorDirection.DOWN).open();
			aCity.getAreas()[0][1].getDoor(DoorDirection.DOWN).open();
			aCity.getAreas()[0][1].getDoor(DoorDirection.LEFT).open();

			aCity.getAreas()[5][5].addZombie(z);
			aCity.getAreas()[5][5].addZombie(z2);

			aCity.getAreas()[5][2].addSurvivor(s);
			aCity.getAreas()[5][3].addSurvivor(s2);

			aCity.display();
		} else {
			int x = parseInt(args[0]);
			int y = parseInt(args[1]);
			City aCity = new City(x, y);
			aCity.display();
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Plateau d'entraînement :");
		
		trainCity.getAreas()[0][0].getDoor(DoorDirection.DOWN).open();
		trainCity.getAreas()[0][1].getDoor(DoorDirection.DOWN).open();
		trainCity.getAreas()[0][1].getDoor(DoorDirection.LEFT).open();

		trainCity.getAreas()[0][0].addZombie(z);
		trainCity.getAreas()[0][0].addSurvivor(s);

		trainCity.display();
	}

	private static int parseInt(String v) {
		String errorMsg = "Les arguments passés en paramètre doivent être des entiers supérieurs à 4 !";
		try {
			int n = Integer.parseInt(v);
			if (n < 5)
				throw new IllegalArgumentException(errorMsg);
			return n;
		} catch (NumberFormatException e) {
			throw new NumberFormatException(errorMsg);
		}
	}
}
