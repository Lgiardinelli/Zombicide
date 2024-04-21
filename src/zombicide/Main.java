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
import zombicide.actor.zombie.*;
import zombicide.city.City;
import zombicide.city.TrainCity;
import zombicide.game.Game;
import zombicide.item.InfraredGlasses;
import zombicide.item.Item;
import zombicide.item.Map;
import zombicide.item.MasterKey;
import zombicide.item.attackItem.weapon.*;
import zombicide.item.careItem.FirstAidKit;
import zombicide.item.careItem.HealingFiask;

import java.util.Arrays;
import java.util.List;

public class Main {

    private final City city = new City(7,7);

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
                new LookAction(),
                new Snooper(),
                new SurvivorMoveAction()
        );

        List<Item> listOfItems = Arrays.asList(
                new Riffle(),
                new Pistol(),
                new HealingFiask(),
                new Map(),
                new InfraredGlasses(),
                new FirstAidKit(),
                new Chainsaw(),
                new MasterKey(),
                new Crowbar(),
                new Axe()
        );

        Game game = new Game(this.city);

        Survivor s1 = new Survivor(fighterAction, game.getCity());
        s1.setName("Théophane");
        game.addSurvivor(s1);

        Survivor s2 = new Survivor(healerAction, game.getCity());
        s2.setName("Dylan");
        game.addSurvivor(s2);
       Survivor s3 = new Survivor(luckyAction, game.getCity());
        s3.setName("Eliès");
        game.addSurvivor(s3);

        Survivor s4 = new Survivor(snooperAction, game.getCity());
        s4.setName("Léo");
        game.addSurvivor(s4);

        Survivor s5 = new Survivor(fighterAction, game.getCity());
        s5.setName("Bondu");
        game.addSurvivor(s5);

        Survivor s6 = new Survivor(healerAction, game.getCity());
        s6.setName("Evan");
        game.addSurvivor(s6);

        Survivor s7 = new Survivor(luckyAction, game.getCity());
        s7.setName("Monsieur Varré");
        game.addSurvivor(s7);

        Survivor s8 = new Survivor(snooperAction, game.getCity());
        s8.setName("Gabriel");
        game.addSurvivor(s8);

        Survivor s9 = new Survivor(snooperAction, game.getCity());
        s9.setName("Madgid");
        game.addSurvivor(s9);

        Survivor s10 = new Survivor(snooperAction, game.getCity());
        s10.setName("Mohammad");
        game.addSurvivor(s10);


//        game.addZombie(new Abomination(zombieActions, game.getCity()));
//        game.addZombie(new Runner(zombieActions, game.getCity()));
//        game.addZombie(new Balaise(zombieActions, game.getCity()));
//        game.addZombie(new Abomination(zombieActions, game.getCity()));
//        game.addZombie(new Walker(zombieActions, game.getCity()));
//        game.addZombie(new Abomination(zombieActions, game.getCity()));
//        game.addZombie(new Runner(zombieActions, game.getCity()));
//        game.addZombie(new Balaise(zombieActions, game.getCity()));
//        game.addZombie(new Abomination(zombieActions, game.getCity()));
//        game.addZombie(new Walker(zombieActions, game.getCity()));


        List<Survivor> survivors = city.getSurvivors();

        city.display();


//        // Add axe in the hand survivor 2
//        Axe axe = new Axe();
//        survivors.get(0).setItemHeld(axe);
//        axe.setSurvivor(survivors.get(0));

        // Add healing fiask in the hand survivor 3
//        HealingFiask healingFiask = new HealingFiask();
//        survivors.get(2).setItemHeld(healingFiask);
//        healingFiask.setSurvivor(survivors.get(2));

        game.play();

        // Displaying survivors with their roles, their items in hand and a map in their backpack.
//        System.out.println();
//        int i = 1;
//        for (Survivor survivor : survivors) {
//            System.out.printf("Survivant %d : Item en main : %s | Contenu sac : %s | Actions : %s%n",
//                    i++,
//                    survivor.getItemHeld(),
//                    survivor.getBackpack().getItems(),
//                    survivor.getRoles().toString()
//            );
//        }
//        System.out.println();
//
//        System.out.println();
//        System.out.println("Voici l'état des survivants :");
//        for (int ignored = 0; ignored < survivors.size(); ignored++) {
//            System.out.printf("Le survivant %d a %d points de vie", ignored+1, survivors.get(ignored).getLifePoints());
//            System.out.println();
//        }
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
