package zombicide;

import zombicide.action.SurvivorAction;
import zombicide.action.survivor.*;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.zombie.Abomination;
import zombicide.city.City;
import zombicide.city.TrainCity;
import zombicide.listchooser.RandomListChooser;
import zombicide.util.DoorDirection;
import zombicide.role.Fighter;
import zombicide.role.Healer;
import zombicide.role.Lucky;
import zombicide.role.Snooper;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.start(args);
	}

	private void start(String[] args) {
		if (args.length < 2) {
			initCity(10, 10);
		} else {
			int width = parseInt(args[0]);
			int height = parseInt(args[1]);
			initCity(width, height);
		}

		initTrainCity();

		chooseRandomSurvivorAction();
	}

	private void initCity(int width, int height) {
		City city = new City(width, height);

		city.getAreas()[0][0].getDoor(DoorDirection.DOWN).open();
		city.getAreas()[0][1].getDoor(DoorDirection.DOWN).open();
		city.getAreas()[0][1].getDoor(DoorDirection.LEFT).open();

		city.getSpawn().addSurvivor(new Survivor(new Fighter()));
		city.getSpawn().addSurvivor(new Survivor(new Healer()));
		city.getSpawn().addSurvivor(new Survivor(new Lucky()));
		city.getSpawn().addSurvivor(new Survivor(new Snooper()));

		city.display();
	}

	private void initTrainCity() {
		System.out.println("Plateau d'entraînement :");

		City trainCity = new TrainCity();

		trainCity.getAreas()[0][0].getDoor(DoorDirection.DOWN).open();
		trainCity.getAreas()[0][1].getDoor(DoorDirection.DOWN).open();
		trainCity.getAreas()[0][1].getDoor(DoorDirection.LEFT).open();

		trainCity.getSpawn().addSurvivor(new Survivor(new Fighter()));
		trainCity.getSpawn().addSurvivor(new Survivor(new Healer()));
		trainCity.getSpawn().addSurvivor(new Survivor(new Lucky()));
		trainCity.getSpawn().addSurvivor(new Survivor(new Snooper()));

		for (int i = 0; i < trainCity.getHeight(); i++) {
			for (int j = 0; j < trainCity.getWidth(); j++) {
				Zombie abomination = new Abomination();
				trainCity.getAreas()[j][i].addZombie(abomination);
			}
		}

		//TODO Mettre une carte dans le sac à dos de chaques survivants.
		//TODO Mettre dans la main de chaque survivant une fiole.

		trainCity.display();

		List<Survivor> survivors = trainCity.getSpawn().getSurvivors();

		System.out.println();
		int i = 1;
		for (Survivor survivor : survivors) {
			System.out.printf("Survivant %d : %s%n", i++, survivor.getRoles());
		}

		System.out.println();
		trainCity.getRooms().get(0).displayItems();
		trainCity.getRooms().get(1).displayItems();
		trainCity.getRooms().get(2).displayItems();

		System.out.println("Plateau d'entraînement avec les survivants montés de 1 case :");

		for (Survivor surv : survivors) {
			//TODO Ajout du déplacement vers le haut.
		}

		trainCity.display();
	}

	private void chooseRandomSurvivorAction() {
		RandomListChooser<SurvivorAction> chooser = new RandomListChooser<>();

		List<SurvivorAction> actions = List.of(
				new AreaAction(),
				new BackPackAction(),
				new DoorAction(),
				new ItemAction(),
				new NoiseAction(),
				new RoomAction()
		);
		SurvivorAction chosenAction = chooser.choose(actions);

		chosenAction.doSomething();
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
