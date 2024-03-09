package zombicide;

import zombicide.actor.Survivor;
import zombicide.actor.Zombie;
import zombicide.actor.zombie.Abomination;
import zombicide.area.Room;
import zombicide.city.TrainCity;
import zombicide.role.Fighter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

		// Ajout d'un zombie dans toutes les pièces du plateau d'entrainement
		for (int i = 0; i < trainCity.getHeight(); i++) {
			for (int j = 0; j < trainCity.getWidth(); j++) {
				Zombie zz = new Abomination();
				trainCity.getAreas()[j][i].addZombie(zz);
			}
		}

		// Ajout d'un survivant de chaque role dans le spawn
		List<Role> l_role = new ArrayList<>();
		Role r = new Fighter();
		l_role.add(r);
		Survivor ss = new Survivor(l_role);
		trainCity.spawn.addSurvivor(ss);

		// Mettre une carte dans le sac à dos de chaques survivants

		// Mettre dans la main de chaque survivant une fiole


		trainCity.display();
		System.out.println();

		System.out.println("Plateau d'entraînement avec les survivants montés de 1 case :");
		List<Survivor> survivorsSpawn = trainCity.spawn.getSurvivors();
		for (Survivor surv : survivorsSpawn) {
			// Ajout du déplacement vers le haut
		}





		List<Role> l = trainCity.getAreas()[2][2].getSurvivors().get(0).getRoles();
		System.out.println(l);

		trainCity.getRooms().get(0).displayItems();
		trainCity.getRooms().get(1).displayItems();
		trainCity.getRooms().get(2).displayItems();

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
