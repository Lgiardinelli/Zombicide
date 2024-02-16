package zombicide;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.actor.Survivor;
import zombicide.actor.Zombie;
import zombicide.actor.zombie.Abomination;
import zombicide.item.Weapon;
import zombicide.item.weapon.*;

public class ItemTest {
    //Actor
    private Survivor survivor;
    private Zombie abomination;

    //Item
    private Item axe;
    private Item chainsaw;
    private Item crowbar;
    private Item rifle;
    private BackPack backPack;

    private Weapon weapon;

    @BeforeEach
    public void before(){
        //Actor
        this.survivor = new Survivor();
        this.abomination = new Abomination();

        //Item
        this.backPack = new BackPack();
        this.axe = new Axe();
        this.chainsaw = new Chainsaw();
        this.rifle = new Riffle();
        this.crowbar = new Crowbar();
        this.weapon = new Pistol();
    }

    @Test
    void testShoot(){
        int result = weapon.shoot();
        assertTrue(result >= weapon.getNbDiceThrows() && result <= weapon.getNbDiceThrows() * 6);
    }


    @Test
    void testCanShoot(){
        boolean canShoot = weapon.canShoot();
        if(canShoot){
            assertTrue(canShoot);
        } else {
            assertFalse(canShoot);
        }
    }

    @Test
    void testGetDamageOfWeapon(){
        assertEquals(weapon.getDamage(), 1);
    }

    @Test
    void testGetDiceThreshold(){
        assertEquals(weapon.getDiceThreshold(), 4);
    }



}
