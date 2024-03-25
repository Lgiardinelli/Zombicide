package zombicide.actor.survivor.backpack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zombicide.actor.survivor.Survivor;
import zombicide.actor.survivor.role.Fighter;
import zombicide.actor.survivor.role.Role;
import zombicide.city.City;
import zombicide.item.InfraredGlasses;
import zombicide.item.Item;
import zombicide.item.MasterKey;
import zombicide.item.careItem.FirstAidKit;
import zombicide.item.weapon.Chainsaw;
import zombicide.item.weapon.Pistol;
import zombicide.item.weapon.Riffle;

class BackPackTest {

    private BackPack backpack;
    private Pistol item1;
    private FirstAidKit item2;
    private Riffle item3;
    private MasterKey item4;
    private InfraredGlasses item5;
    private Chainsaw item6;
    private Survivor survivor;

    @BeforeEach
    public void before() {
        backpack = new BackPack(null);
        item1 = new Pistol();
        item2 = new FirstAidKit();
        item3 = new Riffle();
        item4 = new MasterKey();
        item5 = new InfraredGlasses();
        item6 = new Chainsaw();
        survivor = new Survivor(new City(5, 5), new Fighter());
    }

    @Test
    void testAddItemAndCheckIfBackpackWasFull(){
        assertNull(backpack.addItem(item1));
        assertNull(backpack.addItem(item2));
        assertNull(backpack.addItem(item3));
        assertNull(backpack.addItem(item4));
        assertNull(backpack.addItem(item5));

        Item itemDropped = backpack.addItem(item6);
        assertNotNull(itemDropped);
        assertTrue(itemDropped.equals(item1) || itemDropped.equals(item2) || itemDropped.equals(item3) || itemDropped.equals(item4) || itemDropped.equals(item5));
        assertTrue(backpack.getItems().contains(item6));
        assertFalse(backpack.getItems().contains(itemDropped));
        assertNull(itemDropped.getSurvivor());
    }

    @Test
    void testRemoveItem(){
        backpack.addItem(item1);
        backpack.addItem(item2);

        backpack.removeItem(item1);

        assertFalse(backpack.getItems().contains(item1));
    }



}