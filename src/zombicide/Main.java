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
import zombicide.actor.zombie.Abomination;
import zombicide.actor.zombie.Zombie;
import zombicide.city.TrainCity;
import zombicide.game.Game;
import zombicide.item.careItem.HealingFiask;
import zombicide.item.attackItem.weapon.Axe;

import java.util.Arrays;
import java.util.List;

public class Main {

    private final TrainCity trainCity = new TrainCity();

    public static void main(String[] args) {
        Main main = new Main();
        main.start(args);
    }

    private void start(String[] args) {
        initTrainCity();
    }

    private void initTrainCity() {

        System.out.println("Plateau d'entraînement :");

        List<Action<Zombie>> zombieActions = Arrays.asList(new AttackSurvivorAction(), new ZombieMoveAction());


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

        Game game = new Game(this.trainCity);
        game.addSurvivor(new Survivor(fighterAction, game.getCity()));
        game.addSurvivor(new Survivor(healerAction, game.getCity()));
        game.addSurvivor(new Survivor(luckyAction, game.getCity()));
        game.addSurvivor(new Survivor(snooperAction, game.getCity()));

        game.addZombie(new Abomination(zombieActions, game.getCity()));
        /*game.addZombie(new Abomination(zombieActions, game.getCity()));
        game.addZombie(new Abomination(zombieActions, game.getCity()));*/


        List<Survivor> survivors = trainCity.getSurvivors();

        trainCity.display();

        // Add axe in the hand survivor 2
        Axe axe = new Axe();
        survivors.get(1).setItemHeld(axe);
        axe.setSurvivor(survivors.get(0));

        // Add healing fiask in the hand survivor 3
        HealingFiask healingFiask = new HealingFiask();
        survivors.get(2).setItemHeld(healingFiask);
        healingFiask.setSurvivor(survivors.get(2));

        game.play();

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
