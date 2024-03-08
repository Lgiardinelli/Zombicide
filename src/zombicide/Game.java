package zombicide;

import zombicide.actor.Survivor;
import zombicide.actor.Zombie;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private City board;
    private List<Survivor> survivors;
    private List<Zombie> zombies;

    public Game(City c){
        this.board = c;
        this.survivors = new ArrayList<>();
        this.zombies = new ArrayList<>();
    }

    public void addSurvivor(Survivor s){
        this.survivors.add(s);
    }

    public void addZombie(Zombie z){
        this.zombies.add(z);
    }


}
