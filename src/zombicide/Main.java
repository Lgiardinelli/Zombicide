package zombicide;

import zombicide.action.SurvivorAction;
import zombicide.action.actor.MoveAction;
import zombicide.action.survivor.*;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Abomination;
import zombicide.actor.zombie.Zombie;
import zombicide.backpack.BackPack;
import zombicide.city.City;
import zombicide.city.TrainCity;
import zombicide.item.Map;
import zombicide.item.careItem.HealingFiask;
import zombicide.listchooser.RandomListChooser;
import zombicide.role.Fighter;
import zombicide.role.Healer;
import zombicide.role.Lucky;
import zombicide.role.Snooper;
import zombicide.util.ActorDirection;
import zombicide.util.DoorDirection;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

		new Survivor(new Fighter()).setArea(city.getSpawn());
		new Survivor(new Healer()).setArea(city.getSpawn());
		new Survivor(new Lucky()).setArea(city.getSpawn());
		new Survivor(new Snooper()).setArea(city.getSpawn());

		city.display();
	}

	private void initTrainCity() {
		System.out.println("Plateau d'entraînement :");

		City trainCity = new TrainCity();

		trainCity.getAreas()[0][0].getDoor(DoorDirection.DOWN).open();
		trainCity.getAreas()[0][1].getDoor(DoorDirection.DOWN).open();
		trainCity.getAreas()[0][1].getDoor(DoorDirection.LEFT).open();

		Survivor fighter = new Survivor(new Fighter());
		Survivor healer = new Survivor(new Healer());
		Survivor lucky = new Survivor(new Lucky());
		Survivor snooper = new Survivor(new Snooper());

		fighter.setArea(trainCity.getSpawn());
		healer.setArea(trainCity.getSpawn());
		lucky.setArea(trainCity.getSpawn());
		snooper.setArea(trainCity.getSpawn());

		List<Survivor> survivors = trainCity.getSpawn().getSurvivors();

		// Give healing fiask to survivors
		giveHealingFiask(survivors);
		// Add map to
		addMapInBackPack(survivors);

		// Adding abominations in all city's areas
		for (int i = 0; i < trainCity.getHeight(); i++) {
			for (int j = 0; j < trainCity.getWidth(); j++) {
				Zombie abomination = new Abomination();
				abomination.setArea(trainCity.getAreas()[j][i]);
			}
		}

		trainCity.display();

		// Displaying survivors with their roles, their items in hand and a map in their backpack.
		System.out.println();
		int i = 1;
		for (Survivor survivor : survivors) {
			System.out.printf("Survivant %d : Rôles : %s | Item en main : %s | Contenu sac : %s%n",
					i++,
					survivor.getRoles(),
					survivor.getHandleItem(),
					survivor.getBackpack().getItems()
			);
		}

		// Displaying items in some rooms
		System.out.println();
		trainCity.getRooms().get(0).displayItems();
		trainCity.getRooms().get(1).displayItems();
		trainCity.getRooms().get(2).displayItems();

		System.out.println("Plateau d'entraînement avec les survivants montés de 1 case :");

		for (int ignored = 0; ignored < 4; ignored++)
			new MoveAction(ActorDirection.UP, survivors.get(0), trainCity)
					.doSomething();

		trainCity.display();
	}

	private void addMapInBackPack(List<Survivor> survivors) {
		for (Survivor survivor : survivors)
			survivor.getBackpack().addItem(new Map());
	}

	private void giveHealingFiask(List<Survivor> survivors) {
		for (Survivor survivor : survivors)
			survivor.handleItem(new HealingFiask());
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
