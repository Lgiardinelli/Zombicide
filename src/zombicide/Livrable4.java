package zombicide;

import zombicide.action.Action;
import zombicide.action.survivor.SurvivorMoveAction;
import zombicide.action.survivor.*;
import zombicide.action.survivor.special.Fighter;
import zombicide.action.survivor.special.Healer;
import zombicide.action.survivor.special.Lucky;
import zombicide.action.survivor.special.Snooper;
import zombicide.action.zombie.AttackSurvivorAction;
import zombicide.action.zombie.ZombieMoveAction;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.city.City;
import zombicide.item.careItem.HealingFiask;
import zombicide.item.attackItem.weapon.Axe;

import java.util.Arrays;
import java.util.List;

public class Livrable4 {

    private final City city = new City(10, 10);

    public static void main(String[] args) {
        Livrable4 livrable4 = new Livrable4();
        livrable4.start(args);
    }

    private void start(String[] args) {
        initTrainCity();
    }

    private void initTrainCity() {
        System.out.println("Plateau d'entraînement :");

        List<Action<Zombie>> zombieActions = Arrays.asList(new AttackSurvivorAction(), new ZombieMoveAction());

        // Adding abominations in street city's areas
        /*for (int i = 0; i < city.getWidth(); i++) {
            Zombie abomination = new Abomination(zombieActions, this.city);
            abomination.setArea(city.getAreas()[2][i]);
        }
        for (int i = 0; i < city.getHeight(); i++) {
            if (i != 2) {
                Zombie abomination = new Abomination(zombieActions, this.city);
                abomination.setArea(city.getAreas()[i][2]);
            }
        }*/

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
                new SurvivorMoveAction()
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
                new SurvivorMoveAction()
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
                new SurvivorMoveAction()
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
                new SurvivorMoveAction()
        );

        new Survivor(fighterAction, this.city);
        new Survivor(healerAction, this.city);
        new Survivor(luckyAction, this.city);
        new Survivor(snooperAction, this.city);

        List<Survivor> survivors = city.getSurvivors();

        // Déplacement des survivants au nord du spawn
        for (Survivor survivor : survivors)
            survivor.setArea(this.city.getArea(2, 1));

        city.display();

        // Add axe in the hand survivor 2
        survivors.get(1).setItemHeld(new Axe());

        // Add healing fiask in the hand survivor 3
        survivors.get(2).setItemHeld(new HealingFiask());

        // Displaying survivors with their roles, their items in hand and a map in their backpack.
        System.out.println();
        int i = 1;
        for (Survivor survivor : survivors) {
            System.out.printf("Survivant %d : Item en main : %s | Contenu sac : %s | Actions : %s%n",
                    i++,
                    survivor.getItemHeld(),
                    survivor.getBackpack().getItems(),
                    survivor.getRoles().toString()
            );
        }
        System.out.println();
        System.out.println("Représentation des actions des survivant :");

        // Faire une action pour chaque survivant
        i=1;
        for (Survivor survivor : survivors) {
            System.out.printf("Survivant %d : ", i++);
            survivor.handleAction();
            System.out.println();
        }

        System.out.println();
        System.out.println("Représentation des actions des zombies :");

        // Action attack and move for all zombies
        /*i = 1;
        List<Zombie> zombies = city.getZombies();
        for (Zombie zombie : zombies) {
            System.out.printf("Zombie %d : ", i++);
            zombie.handleAction();
        }*/



        System.out.println();
        System.out.println("Plateau d'entraînement après les actions effectuées :");
        city.display();

        System.out.println();
        System.out.println("Voici l'état des survivants :");
        for (int ignored = 0; ignored < survivors.size(); ignored++) {
            System.out.printf("Le survivant %d a %d points de vie", ignored+1, survivors.get(ignored).getLifePoints());
            System.out.println();
        }
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
