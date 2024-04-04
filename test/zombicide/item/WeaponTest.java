package zombicide.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.item.weapon.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeaponTest {
    private Weapon pistol;
    private Weapon axe;
    private Weapon chainsaw;
    private Weapon crowbar;
    private Weapon riffle;

    @BeforeEach
    public void before(){
        this.pistol = new Pistol();
        this.axe = new Axe();
        this.chainsaw = new Chainsaw();
        this.riffle = new Riffle();
        this.crowbar = new Crowbar();
    }

    @Test
    void testShootingTarget(){
        int v = pistol.shoot();
        assertTrue(v > 0);
        if (v >= pistol.getDiceThreshold())
            assertTrue(pistol.shotHitsTarget(v));
    }

    @Test
    void testGetMinAndMaxHittingRange(){
        int minRange = pistol.getMinHittingRange();
        int maxRange = pistol.getMaxHittingRange();
        assertEquals(minRange, 0);
        assertEquals(maxRange, 1);
    }
}
