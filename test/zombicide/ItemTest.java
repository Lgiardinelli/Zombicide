package zombicide;

import org.junit.jupiter.api.BeforeEach;
import zombicide.actor.Survivor;
import zombicide.actor.Zombie;
import zombicide.actor.zombie.Abomination;
import zombicide.actor.zombie.Balaise;
import zombicide.actor.zombie.Runner;
import zombicide.actor.zombie.Walker;
import zombicide.item.weapon.*;

public class ItemTest {
    //Actor
    private Survivor survivor;
    private Zombie abomination;

    //Item
    private Item pistol;
    private Item axe;
    private Item chainsaw;
    private Item crowbar;
    private Item rifle;
    private BackPack backPack;

    @BeforeEach
    public void before(){
        //Actor
        this.survivor = new Survivor();
        this.abomination = new Abomination();

        //Item
        this.backPack = new BackPack();
        this.pistol = new Pistol();
        this.axe = new Axe();
        this.chainsaw = new Chainsaw();
        this.rifle = new Riffle();
        this.crowbar = new Crowbar();
    }
}
