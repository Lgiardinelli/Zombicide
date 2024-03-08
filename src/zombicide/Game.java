package zombicide;

import zombicide.actor.Survivor;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private City board;
    private List<Survivor> survivors;
    private List<Survivor> zombies;

    public Game(City c){
        this.board = c;
        this.survivors = new ArrayList<>();
        this.zombies = new ArrayList<>();
    }



}
