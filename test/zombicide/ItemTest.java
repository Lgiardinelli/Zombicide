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
    private CareItem healingFlask;
    private CareItem firstAidKit;
    private InfraredGlasses infraredGlasses;
    private Map map;
    private MasterKey masterKey;
    private BackPack backPack;

    @BeforeEach
    public void before(){
        //Item
        this.weapon = new Pistol();
        this.healingFlask = new HealingFiask();
        this.firstAidKit = new FirstAidKit();
        this.infraredGlasses = new InfraredGlasses();
        this.map = new Map();
        this.masterKey = new MasterKey();
        this.backPack = new BackPack();
    }

    @Test
    void testShoot(){
        int result = weapon.shoot();
        assertTrue(result >= weapon.getNbDiceThrows() && result <= weapon.getNbDiceThrows() * 6);
    }


    @Test
    void testShotHitsTarget(){
        boolean shotHitsTarget = weapon.shotHitsTarget();
        if(weapon.shoot() >= weapon.getDiceThreshold()) {
            assertTrue(shotHitsTarget);
        } else {
            assertFalse(shotHitsTarget);
        }
    }

    @Test
    void testGetDamageOfWeapon(){
        int WeaponDamage = weapon.getDamage();
        assertEquals(WeaponDamage, 1);
    }

    @Test
    void testGetDiceThreshold(){
        int seuilResult = weapon.getDiceThreshold();
        assertEquals(seuilResult, 4);
    }

    @Test
    void testGetMinAndMaxHittingRange(){
        int minRange = weapon.getMinHittingRange();
        int maxRange = weapon.getMaxHittingRange();
        assertEquals(minRange, 0);
        assertEquals(maxRange, 1);
    }

    @Test
    void testNoisyItem(){
        //CareItem
        assertFalse(firstAidKit.isNoisy);
        assertFalse(healingFlask.isNoisy);

        //Item
        assertFalse(infraredGlasses.isNoisy);
        assertTrue(map.isNoisy);
        assertFalse(masterKey.isNoisy);
    }

    @Test
    void testAddItemInBackpack(){
        backPack.addItem(weapon);
        assertTrue(backPack.getItems().contains(weapon));
    }

    @Test
    void testRemoveItemInBackpack(){
        backPack.addItem(weapon);
        assertTrue(backPack.getItems().contains(weapon));
        backPack.removeItem(weapon);
        assertFalse(backPack.getItems().contains(weapon));
    }
}
