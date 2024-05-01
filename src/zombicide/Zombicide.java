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

public class Zombicide {

    private final City city = new City(7,7);

    public static void main(String[] args) {
        Zombicide zombicide = new Zombicide();
        zombicide.start(args);
    }

    private void start(String[] args) {
        initTrainCity();
    }

    private void initTrainCity() {

        System.out.println("Plateau d'entraînement :");

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

        city.display();
        game.play();
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
