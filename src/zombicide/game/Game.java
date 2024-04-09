package zombicide.game;

import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.city.City;
import zombicide.city.area.Area;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private City board;
    private List<Survivor> survivors;
    private List<Zombie> zombies;
    private Phase currentPhase;

    public Game(City c){
        this.board = c;
        this.survivors = new ArrayList<>();
        this.zombies = new ArrayList<>();
        this.currentPhase = Phase.SURVIVORS;
    }

    public void addSurvivor(Survivor s){
        this.survivors.add(s);
    }

    public void addZombie(Zombie z){
        this.zombies.add(z);
    }

    public boolean endGame(){
        return allSurvivorAreDead() || allZombiesAreDead() || areThePlayersHaveReachedStage();
    }

    public boolean allSurvivorAreDead(){
        for(Survivor s : survivors){
            if(!s.isDead()){
                return false;
            }
        }
        return true;
    }

    public boolean allZombiesAreDead(){
        for(Zombie z : zombies){
            if(!z.isDead()){
                return false;
            }
        }
        return true;
    }

    public boolean areThePlayersHaveReachedStage(){
        return getTotalNumberOfSkillPoints() >= 30;
    }

    public void play(){
        while(!endGame()){
            if(currentPhase == Phase.SURVIVORS){
                playSurvivorsPhase();
            }
            else if(currentPhase == Phase.ZOMBIES){
                playZombiesPhase();
            } else { playEndPhase(); }

            this.board.display();
        }
    }

    private void playEndPhase() {
        survivors.removeIf(Survivor::isDead);
        zombies.removeIf(Zombie::isDead);

        for(int i = 0; i < this.board.getWidth() ; i++){
            for(int j = 0; j < this.board.getHeight() ; j++){
                this.board.getArea(i , j).setNoise(0);
            }
        }

    }

    private void playZombiesPhase() {
        for(Zombie z : zombies){
            z.handleAction();
        }
        this.currentPhase = Phase.END;
    }

    private void playSurvivorsPhase() {
        for(Survivor s : survivors){
            s.handleAction();
        }
        this.currentPhase = Phase.ZOMBIES;
    }

    public int getNumberOfZombiesToSpawn(){
        return Math.round((float) getTotalNumberOfSkillPoints() /3);
    }

    public int getTotalNumberOfSkillPoints(){
        int somme = 0;
        for(Survivor s : survivors){
            somme += s.getSkillPoints();
        }
        return somme;
    }


}
