package zombicide;

import zombicide.action.Action;
import zombicide.action.survivor.*;
import zombicide.action.survivor.special.Fighter;
import zombicide.action.survivor.special.Healer;
import zombicide.action.survivor.special.Lucky;
import zombicide.action.survivor.special.Snooper;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Abomination;
import zombicide.actor.zombie.Zombie;
import zombicide.city.City;
import zombicide.city.TrainCity;
import zombicide.item.careItem.HealingFiask;
import zombicide.item.weapon.Axe;
import zombicide.item.weapon.Riffle;
import zombicide.util.Direction;
import zombicide.util.listchooser.RandomListChooser;

import java.util.ArrayList;
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

        List<Action<Survivor>> survivorActions = Arrays.asList(
                null,
                new AreaAction(),
                new AttackZombieAction(),
                new BackPackAction(),
                new DoorAction(),
                new HealAction(),
                new ItemAction(),
                new LookAction(),
                new NoiseAction(),
                new RummageAction()
        );

        // Affichage des actions du survivant
        // survivor.handleAction(survivorActions);
    }

    private void initTrainCity() {
        System.out.println("Plateau d'entraînement :");

        // Adding abominations in all city's areas
        for (int i = 0; i < trainCity.getHeight(); i++) {
            for (int j = 0; j < trainCity.getWidth(); j++) {
                Zombie abomination = new Abomination(this.trainCity);
                abomination.setArea(trainCity.getAreas()[j][i]);
            }
        }

//        Ouverture de portes
//        trainCity.getAreas()[0][0].getDoor(Direction.DOWN).open();
//        trainCity.getAreas()[0][1].getDoor(Direction.DOWN).open();
//        trainCity.getAreas()[0][1].getDoor(Direction.LEFT).open();

        new Survivor(List.of(new Fighter()), this.trainCity);
        new Survivor(List.of(new Healer()), this.trainCity);
        new Survivor(List.of(new Lucky()), this.trainCity);
        new Survivor(List.of(new Snooper()), this.trainCity);

        List<Survivor> survivors = trainCity.getSpawn().getSurvivors();
        List<Zombie> zombies = new ArrayList<>();
        for (int i=0; i<trainCity.getRooms().size(); i++) {
            List<Zombie> z = trainCity.getRooms().get(i).getZombies();
            zombies.addAll(z);
        }


        trainCity.display();

        // Add axe in the hand survivor 2
        survivors.get(1).setItemHeld(new Axe());

        // Add healing fiask in the hand survivor 3
        survivors.get(2).setItemHeld(new HealingFiask());

        // Displaying survivors with their roles, their items in hand and a map in their backpack.
        System.out.println();
        int i = 1;
        for (Survivor survivor : survivors) {
            System.out.printf("Survivant %d : Rôles : %s | Item en main : %s | Contenu sac : %s%n",
                    i++,
                    survivor.getRoles(),
                    survivor.getItemHeld(),
                    survivor.getBackpack().getItems()
            );
        }
        System.out.println();

        // Faire une action pour un survivant
        int alea = (int) (Math.random() * survivors.size());
        survivors.get(alea); // ... a continuer
        // Utiliser chooseRandomActionSurvivor ?
        // Ajout d'une méthode doSomething dans Survivor ?

        // Action attack and move for all zombies
        for (i=0 ; i<zombies.size(); i++) {
            zombies.get(i); // Ajouter l'effet d'attaquer, si survivant dans la cell, attaquer sinon rien faire mais cela doit être gérer dans l'action
        }



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
