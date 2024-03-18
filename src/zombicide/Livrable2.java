package zombicide;

import zombicide.actor.action.*;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Abomination;
import zombicide.actor.zombie.Zombie;
import zombicide.city.City;
import zombicide.city.TrainCity;
import zombicide.item.Map;
import zombicide.item.careItem.HealingFiask;
import zombicide.item.weapon.Riffle;
import zombicide.util.listchooser.RandomListChooser;
import zombicide.actor.survivor.role.Fighter;
import zombicide.actor.survivor.role.Healer;
import zombicide.actor.survivor.role.Lucky;
import zombicide.actor.survivor.role.Snooper;
import zombicide.util.Direction;
import zombicide.util.Position;

import java.util.Arrays;
import java.util.List;

public class Livrable2 {

	private final City city = new City(10,10);
	private final TrainCity trainCity = new TrainCity();

	public static void main(String[] args) {
		Livrable2 livrable2 = new Livrable2();
		livrable2.start(args);
	}

	private void start(String[] args) {
		if (args.length < 2) {
			initCity(this.city.getWidth(), this.city.getHeight());
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

		city.getAreas()[0][0].getDoor(Direction.DOWN).open();
		city.getAreas()[0][1].getDoor(Direction.DOWN).open();
		city.getAreas()[0][1].getDoor(Direction.LEFT).open();

		new Survivor(this.city,new Fighter()).setArea(city.getSpawn());
		new Survivor(this.city,new Healer()).setArea(city.getSpawn());
		new Survivor(this.city,new Lucky()).setArea(city.getSpawn());
		new Survivor(this.city,new Snooper()).setArea(city.getSpawn());

		city.display();
	}

	private void initTrainCity() {
		System.out.println("Plateau d'entraînement :");

		trainCity.getAreas()[0][0].getDoor(Direction.DOWN).open();
		trainCity.getAreas()[0][1].getDoor(Direction.DOWN).open();
		trainCity.getAreas()[0][1].getDoor(Direction.LEFT).open();

		Survivor fighter = new Survivor(this.city,new Fighter());
		Survivor healer = new Survivor(this.city,new Healer());
		Survivor lucky = new Survivor(this.city,new Lucky());
		Survivor snooper = new Survivor(this.city,new Snooper());

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
				Zombie abomination = new Abomination(this.city);
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
			survivors.get(0).setArea(trainCity.getCellUp(2, 2));

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
		Survivor s = new Survivor(this.trainCity);
		s.setArea(this.trainCity.getArea(new Position(3,3)));
		Map m = new Map();
		m.setSurvivor(s);
		for(int i =0 ; i < 5 ; i++){
			s.getBackpack().addItem(new Riffle());
		}
		System.out.println(s.getBackpack().getItems());
		RandomListChooser<ActorAction> chooser = new RandomListChooser<>();

		List<ActorAction> actions = Arrays.asList(
				null,
				new AreaAction(s),
				new BackPackAction(s),
				new DoorAction(s),
				new ItemAction(m),
				new NoiseAction(s),
				new RoomAction(s),
				new LookAction(s)
		);
		ActorAction chosenAction = chooser.choose(actions);
		if (chosenAction != null) {
			chosenAction.doSomething();
			this.trainCity.display();
			System.out.println(s.getBackpack().getItems());
		}
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
