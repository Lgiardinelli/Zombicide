package zombicide;

import zombicide.actor.Survivor;
import zombicide.actor.Zombie;
import zombicide.actor.zombie.Abomination;

import java.time.ZoneOffset;

public class Main {

	public static void main(String[] args) {

		City trainCity = new City(5, 5);
		
		if (args.length == 0) {
			City aCity = new City(10, 10);
			
			aCity.getAreas()[0][0].getDoor(DoorDirection.DOWN).open();
			aCity.getAreas()[0][1].getDoor(DoorDirection.DOWN).open();
			aCity.getAreas()[0][1].getDoor(DoorDirection.LEFT).open();
			Zombie z = new Abomination();
			aCity.getAreas()[0][0].addZombie(z);
			aCity.display();
		}
		else {
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);
			City aCity = new City(x, y);
			aCity.display();
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Plateau d'entrainement :");
		
		trainCity.getAreas()[0][0].getDoor(DoorDirection.DOWN).open();
		trainCity.getAreas()[0][1].getDoor(DoorDirection.DOWN).open();
		trainCity.getAreas()[0][1].getDoor(DoorDirection.LEFT).open();

		Zombie z = new Abomination();
		trainCity.getAreas()[0][0].addZombie(z);
		trainCity.display();
	}

}
