package zombicide.game;

import zombicide.item.Item;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.city.City;
import zombicide.city.area.Area;
import zombicide.item.InfraredGlasses;
import zombicide.item.Map;
import zombicide.item.MasterKey;
import zombicide.item.attackItem.weapon.*;
import zombicide.item.careItem.FirstAidKit;
import zombicide.item.careItem.HealingFiask;
import zombicide.util.listchooser.RandomListChooser;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a Zombicide game session.
 */
public class Game {

    private City city;
    private List<Survivor> survivors;
    private List<Zombie> zombies;
    private Phase currentPhase;

    private boolean startOfTheGame;

    Scanner scanner = new Scanner(System.in);

    /**
     * Creates a new game session with the given city.
     *
     * @param city The city for the game.
     */
    public Game(City city){
        this.city = city;
        this.survivors = new ArrayList<>();
        this.zombies = new ArrayList<>();
        this.currentPhase = Phase.SURVIVORS;
        this.startOfTheGame = true;
    }

    public void initGame(){
        /*for (Survivor survivor : this.survivors)
            survivor.setArea(this.city.getSpawn());*/
        this.city.dispatchItems2();
        distributeItems();
    }


    /**
     * Adds a survivor to the game.
     *
     * @param s The survivor to add.
     */
    public void addSurvivor(Survivor s){
        this.survivors.add(s);
    }

    /**
     * Adds a zombie to the game.
     *
     * @param z The zombie to add.
     */
    public void addZombie(Zombie z){
        this.zombies.add(z);
    }

    /**
     * Checks if the game should end.
     *
     * @return true if the game should end, false otherwise.
     */
    public boolean endGame(){
        return allSurvivorAreDead() || allZombiesAreDead() || areThePlayersHaveReachedStage();
    }

    /**
     * Checks if all survivors are dead.
     *
     * @return true if all survivors are dead, false otherwise.
     */
    public boolean allSurvivorAreDead(){
        if(!this.startOfTheGame) {
            return this.survivors.isEmpty();
        }else{ return false; }
    }

    /**
     * Checks if all zombies are dead.
     *
     * @return true if all zombies are dead, false otherwise.
     */
    public boolean allZombiesAreDead(){
        if(!this.startOfTheGame) {
            return this.zombies.isEmpty();
        }else{ return false; }
    }

    /**
     * Checks if the players have reached the winning stage.
     *
     * @return true if the players have reached the winning stage, false otherwise.
     */
    public boolean areThePlayersHaveReachedStage(){
        return getTotalNumberOfSkillPoints() >= 30;
    }

    /**
     * Runs the game loop until the end conditions are met.
     */
    public void play(){
        /*for (int i=0; i<3; i++) {
            if(currentPhase == Phase.SURVIVORS){
                playSurvivorsPhase();
            }
            else if(currentPhase == Phase.ZOMBIES){
                playZombiesPhase();
            } else { playEndPhase(); }

            this.city.display();
        }*/
        initGame();

        while(!endGame()){
            this.startOfTheGame = true;
            if(currentPhase == Phase.SURVIVORS){
                System.out.println("Survivors' tour");
                playSurvivorsPhase();
            }
            else if(currentPhase == Phase.ZOMBIES){
                System.out.println("Zombies' tour");
                playZombiesPhase();
            }
            else {
                playEndPhase();
                System.out.println();
                System.out.println("Voici l'état des survivants :");
                for (int ignored = 0; ignored < survivors.size(); ignored++) {
                    System.out.printf("Le survivant %d a %d points de vie", ignored+1, survivors.get(ignored).getLifePoints());
                    System.out.println();
                }
            }
            this.city.display();
        }
    }

    /**
     * Handles the end phase of the game.
     * Removes dead survivors and zombies, resets noise levels, and spawns new zombies.
     */
    private void playEndPhase() {
        /*survivors.removeIf(Survivor::isDead);
        zombies.removeIf(Zombie::isDead);*/
        survivors.removeIf(Actor::isDead);
        zombies.removeIf(Actor::isDead);


        for(int i = 0; i < this.city.getWidth() ; i++){
            for(int j = 0; j < this.city.getHeight() ; j++){
                this.city.getArea(i , j).setNoise(0);
            }
        }

        if(!allZombiesAreDead()){
            for(int i = 0 ; i < getNumberOfZombiesToSpawn() ; i++){
                this.city.spawnAZombie();
                System.out.println(i);
            }
            System.out.println(getNumberOfZombiesToSpawn()+" zombies spawned");
        }

        for (Survivor survivor : survivors) {
            survivor.setActionPoints(3);
        }
        this.currentPhase = Phase.SURVIVORS;

    }

    /**
     * Handles the zombies' phase of the game.
     * Zombies take their actions.
     */
    private void playZombiesPhase() {
        for(Zombie z : zombies){
            if(!z.isDead()) {
                scanner.next();
                z.handleAction();
            }
        }
        this.currentPhase = Phase.END;
    }

    /**
     * Handles the survivors' phase of the game.
     * Survivors take their actions.
     */
    private void playSurvivorsPhase() {
        for(Survivor s : survivors){
            if(!s.isDead()) {
                System.out.println("It's " + s.getName() + "'s turn ! He has a(n) " + s.getItemHeld().toString() + " and " + s.getLifePoints() + " life point(s)");
                System.out.println("Backpack : " + s.getBackpack().displayItems());
                while (s.getActionPoints() > 0) {
                    scanner.next();
                    s.handleAction();
                    System.out.println(s.getName() + " has " + s.getActionPoints() + " pts d'action");
                }
                System.out.println();
            }
        }
        this.currentPhase = Phase.ZOMBIES;
    }

    /**
     * Calculates the number of zombies to spawn based on total survivor skill points.
     *
     * @return The number of zombies to spawn.
     */
    public int getNumberOfZombiesToSpawn(){
        return (int) Math.ceil((double) getTotalNumberOfSkillPoints() / 3);
    }


    /**
     * Calculates the total number of skill points from all survivors.
     *
     * @return The total number of skill points.
     */
    public int getTotalNumberOfSkillPoints(){
        int sum = 0;
        for(Survivor s : survivors){
            sum += s.getSkillPoints();
        }
        return sum;
    }

    public City getCity() {
        return  this.city;
    }

    public void distributeItems() {
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

        for(Survivor s : this.survivors) {
            RandomListChooser<Item> chooser = new RandomListChooser<>();
            Item item1 = chooser.choose(listOfItems);
            Item item2 = chooser.choose(listOfItems);

            s.getBackpack().addItem(item1);
            s.getBackpack().addItem(item2);
        }
    }



}
