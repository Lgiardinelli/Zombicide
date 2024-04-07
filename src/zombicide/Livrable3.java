package zombicide;

import zombicide.action.Action;
import zombicide.action.MoveAction;
import zombicide.action.survivor.*;
import zombicide.action.survivor.special.Fighter;
import zombicide.action.survivor.special.Healer;
import zombicide.action.survivor.special.Lucky;
import zombicide.action.survivor.special.Snooper;
import zombicide.action.zombie.AttackSurvivorAction;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Walker;
import zombicide.actor.zombie.Zombie;
import zombicide.city.City;
import zombicide.city.TrainCity;
import zombicide.item.careItem.HealingFiask;
import zombicide.item.weapon.Axe;
import zombicide.util.listchooser.RandomListChooser;

import java.util.Arrays;
import java.util.List;

public class Livrable3 {

    private final TrainCity trainCity = new TrainCity();

    public static void main(String[] args) {
        Livrable3 livrable3 = new Livrable3();
        livrable3.start(args);
    }

    private void start(String[] args) {
        actionsAndRoles();
        initTrainCity();
    }

    private void actionsAndRoles() {

        // For livrable 3
        List<Action<Survivor>> roles = Arrays.asList(
                new Fighter(),
                new Healer()
        );

        Survivor survivor = new Survivor(roles, new City(10, 10));



        // Affichage des actions du survivant
        // survivor.handleAction(survivorActions);
    }

    private void initTrainCity() {
        System.out.println("Plateau d'entraînement :");

        List<Action<Zombie>> zombieActions = List.of(new AttackSurvivorAction(), new MoveAction<>());

        // Adding abominations in all city's areas
        for (int i = 0; i < trainCity.getHeight(); i++) {
            for (int j = 0; j < trainCity.getWidth(); j++) {
                Zombie abomination = new Walker(zombieActions, this.trainCity);
                abomination.setArea(trainCity.getAreas()[j][i]);
            }
        }

//        Ouverture de portes
//        trainCity.getAreas()[0][0].getDoor(Direction.DOWN).open();
//        trainCity.getAreas()[0][1].getDoor(Direction.DOWN).open();
//        trainCity.getAreas()[0][1].getDoor(Direction.LEFT).open();

        List<Action<Survivor>> fighterAction = Arrays.asList(
                null,
                new AttackZombieAction(),
                new RummageAction(),
                new BackPackAction(),
                new DoorAction(),
                new ItemAction(),
                new NoiseAction(),
                new AreaAction(),
                new LookAction(),
                new Fighter(),
                new MoveAction<>()
        );

        List<Action<Survivor>> healerAction = Arrays.asList(
                null,
                new AttackZombieAction(),
                new RummageAction(),
                new BackPackAction(),
                new DoorAction(),
                new ItemAction(),
                new NoiseAction(),
                new AreaAction(),
                new LookAction(),
                new Healer(),
                new MoveAction<>()
        );

        List<Action<Survivor>> luckyAction = Arrays.asList(
                null,
                new AttackZombieAction(),
                new RummageAction(),
                new BackPackAction(),
                new DoorAction(),
                new ItemAction(),
                new NoiseAction(),
                new AreaAction(),
                new LookAction(),
                new Lucky(),
                new MoveAction<>()
        );

        List<Action<Survivor>> snooperAction = Arrays.asList(
                null,
                new RummageAction(),
                new AttackZombieAction(),
                new BackPackAction(),
                new DoorAction(),
                new ItemAction(),
                new NoiseAction(),
                new AreaAction(),
                new LookAction(),
                new Snooper(),
                new MoveAction<>()
        );

        new Survivor(fighterAction, this.trainCity);
        new Survivor(healerAction, this.trainCity);
        new Survivor(luckyAction, this.trainCity);
        new Survivor(snooperAction, this.trainCity);

        List<Survivor> survivors = trainCity.getSurvivors();

        // Déplacement des survivants au nord du spawn
        for (Survivor survivor : survivors)
            survivor.setArea(this.trainCity.getArea(2, 1));

        trainCity.display();

        // Add axe in the hand survivor 2
        survivors.get(1).setItemHeld(new Axe());

        // Add healing fiask in the hand survivor 3
        survivors.get(2).setItemHeld(new HealingFiask());

        // Displaying survivors with their roles, their items in hand and a map in their backpack.
        System.out.println();
        int i = 1;
        for (Survivor survivor : survivors) {
            System.out.printf("Survivant %d : Actions : %s | Item en main : %s | Contenu sac : %s%n",
                    i++,
                    survivor.getRoles(),
                    survivor.getItemHeld(),
                    survivor.getBackpack().getItems()
            );
        }
        System.out.println();

        // Faire une action pour chaque survivant
        for (Survivor survivor : survivors)
            survivor.handleAction();

        // Action attack and move for all zombies
        List<Zombie> zombies = trainCity.getZombies();
        for (Zombie zombie : zombies)
            zombie.handleAction();


        System.out.println();
        System.out.println("Plateau d'entraînement après les actions effectuées :");
        trainCity.display();

        System.out.println();
        System.out.println("Voici l'état des survivants :");
        for (int ignored = 0; ignored < survivors.size(); ignored++) {
            System.out.printf("Le survivant %d a %d points de vie", ignored+1, survivors.get(ignored).getLifePoints());
            System.out.println();
        }
    }

    Action<Survivor> chooseRandomActionSurvivor(Survivor survivor) {
        RandomListChooser<Action<Survivor>> survivorActionChooser = new RandomListChooser<>();

        List<Action<Survivor>> survivorActions = Arrays.asList(
                null,
                new RummageAction(),
                new BackPackAction(),
                new DoorAction(),
                new ItemAction(),
                new NoiseAction(),
                new AreaAction(),
                new LookAction()
        );
        Action<Survivor> action = survivorActionChooser.choose(survivorActions);
        return action;
    }

    private static int parseInt(String s) {
        String errorMsg = "Les arguments passés en paramètre doivent être des entiers supérieurs à 4 !";
        try {
            int n = Integer.parseInt(s);
            if (n < 5)
                throw new IllegalArgumentException(errorMsg);
            return n;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(errorMsg);
        }
    }
}
