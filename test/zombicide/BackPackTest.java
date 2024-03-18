package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zombicide.actor.survivor.backpack.BackPack;
import zombicide.item.InfraredGlasses;
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


    @BeforeEach
    public void before() {
        backpack = new BackPack();
        item1 = new Pistol();
        item2 = new FirstAidKit();
        item3 = new Riffle();
        item4 = new MasterKey();
        item5 = new InfraredGlasses();
        item6 = new Chainsaw();
    }
    @Test
    void testAddItem(){


        backpack.addItem(item1);
        backpack.addItem(item2);
        backpack.addItem(item3);
        backpack.addItem(item4);
        backpack.addItem(item5);

        assertTrue(backpack.getItems().contains(item3));

        assertFalse(backpack.getItems().contains(item6));


    }

    @Test
    void testRemoveItem(){
        backpack.addItem(item1);
        backpack.addItem(item2);

        backpack.removeItem(item1);

        assertFalse(backpack.getItems().contains(item1));
    }



}