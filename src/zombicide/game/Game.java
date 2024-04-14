package zombicide.game;

import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.city.City;
import zombicide.city.area.Area;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Zombicide game session.
 */
public class Game {

    private City city;
    private List<Survivor> survivors;
    private List<Zombie> zombies;
    private Phase currentPhase;

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
    }

    public void initGame(){
        /*for (Survivor survivor : this.survivors)
            survivor.setArea(this.city.getSpawn());*/
        this.city.dispatchItems2();
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
        System.out.println(this.survivors);
        return allSurvivorAreDead() || allZombiesAreDead() || areThePlayersHaveReachedStage();
    }

    /**
     * Checks if all survivors are dead.
     *
     * @return true if all survivors are dead, false otherwise.
     */
    public boolean allSurvivorAreDead(){
        return this.survivors.isEmpty();
    }

    /**
     * Checks if all zombies are dead.
     *
     * @return true if all zombies are dead, false otherwise.
     */
    public boolean allZombiesAreDead(){
        return this.zombies.isEmpty();
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

        while(!endGame()){
            if(currentPhase == Phase.SURVIVORS){
                playSurvivorsPhase();
            }
            else if(currentPhase == Phase.ZOMBIES){
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
        survivors.removeIf(survivor -> survivor.isDead());
        zombies.removeIf(zombie -> zombie.isDead());

        for (Zombie zombie : zombies) {
            if (zombie.isDead())
                this.survivors.remove(zombie);
        }


        for(int i = 0; i < this.city.getWidth() ; i++){
            for(int j = 0; j < this.city.getHeight() ; j++){
                this.city.getArea(i , j).setNoise(0);
            }
        }

        if(!allZombiesAreDead()){
            for(int i = 0 ; i < getNumberOfZombiesToSpawn() ; i++){
                this.city.spawnAZombie();
            }
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
            z.handleAction();
        }
        this.currentPhase = Phase.END;
    }

    /**
     * Handles the survivors' phase of the game.
     * Survivors take their actions.
     */
    private void playSurvivorsPhase() {
        for(Survivor s : survivors){
            while(s.getActionPoints() > 0){
                s.handleAction();
            }
            System.out.println();
        }
        this.currentPhase = Phase.ZOMBIES;
    }

    /**
     * Calculates the number of zombies to spawn based on total survivor skill points.
     *
     * @return The number of zombies to spawn.
     */
    public int getNumberOfZombiesToSpawn(){
        return Math.round((float) getTotalNumberOfSkillPoints() / 3);
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
}
