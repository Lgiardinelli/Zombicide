package zombicide;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.item.*;
import zombicide.item.careItem.FirstAidKit;
import zombicide.item.careItem.HealingFiask;
import zombicide.item.weapon.*;

public class ItemTest {
    //Actor
    private Weapon weapon;
    private CareItem healingFiask;
    private CareItem firstAidKit;
    private InfraredGlasses infraredGlasses;
    private Map map;
    private MasterKey masterKey;

    @BeforeEach
    public void before(){
        //Item
        this.weapon = new Pistol();
        this.healingFiask = new HealingFiask();
        this.firstAidKit = new FirstAidKit();
        this.infraredGlasses = new InfraredGlasses();
        this.map = new Map();
        this.masterKey = new MasterKey();
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

    @Test
    void testGetMinAndMaxHittingRange(){
        assertEquals(weapon.getMinHittingRange(), 0);
        assertEquals(weapon.getMaxHittingRange(), 1);
    }

    @Test
    void testNoisyItem(){
        //CareItem
        assertFalse(firstAidKit.isNoisy);
        assertFalse(healingFiask.isNoisy);

        //Item
        assertFalse(infraredGlasses.isNoisy);
        assertTrue(map.isNoisy);
        assertFalse(masterKey.isNoisy);
    }



}
