package zombicide;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.actor.Survivor;
import zombicide.actor.Zombie;
import zombicide.actor.zombie.Abomination;
import zombicide.actor.zombie.Balaise;
import zombicide.actor.zombie.Runner;
import zombicide.actor.zombie.Walker;
import zombicide.item.weapon.Axe;
import zombicide.item.weapon.Pistol;
import zombicide.role.Fighter;

public class ActorTest {
    private Survivor survivor;
    private Zombie balaise;
    private Zombie runner;
    private Zombie walker;
    private Zombie abomination;
    private Role fighter;
    private Item pistol;
    private Item axe;
    private BackPack backPack;

    @BeforeEach
    public void before(){
        this.survivor = new Survivor();
        this.balaise = new Balaise();
        this.abomination = new Abomination();
        this.walker = new Walker();
        this.runner = new Runner();
        this.pistol = new Pistol();
        this.backPack = new BackPack();
        this.axe = new Axe();
    }

    @Test
    void testActorInitialization(){
        assertNotNull(balaise);
        assertNotNull(abomination);
        assertNotNull(walker);
        assertNotNull(runner);
        assertNotNull(survivor);
    }

    @Test
    void testGetZombieAttack(){
        assertEquals(balaise.getAttackPoints(), 2);
        assertEquals(abomination.getAttackPoints(), 3);
        assertEquals(walker.getAttackPoints(), 1);
        assertEquals(runner.getAttackPoints(), 1);
    }

    @Test
    void testGetIsStrong(){
        assertTrue(balaise.getIsStrong());
        assertTrue(abomination.getIsStrong());
        assertFalse(walker.getIsStrong());
        assertFalse(runner.getIsStrong());
    }

    @Test
    void testHandleItem(){
        survivor.handleItem(pistol);
        assertEquals(pistol, survivor.getHandleItem());
    }

    @Test
    void testSkillPoints(){
        assertEquals(survivor.getSkillPoints(), 0);
        survivor.increaseSkillPoints();
        assertEquals(survivor.getSkillPoints(), 1);
    }

    /* TODO : REVOIR LE TEST ICI (équiper le survivor du backpack et regarder si il est équiper) */
    @Test
    void testGetBackpack(){
        assertNull(survivor.getBackpack());
    }

    @Test
    void testLevelReached(){
        assertFalse(survivor.levelReached());
        for(int i = 0; i < 3; i++){
            survivor.increaseSkillPoints();
        }
        assertEquals(survivor.getSkillPoints(), 3);
        assertTrue(survivor.levelReached());
        for(int i = 0; i < 4; i++){
            survivor.increaseSkillPoints();
        }
        assertEquals(survivor.getSkillPoints(), 7);
        assertTrue(survivor.levelReached());
        for(int i = 0; i < 4; i++){
            survivor.increaseSkillPoints();
        }
        assertEquals(survivor.getSkillPoints(), 11);
        assertTrue(survivor.levelReached());
    }

    /* TODO : FAIRE UN TEST SUR LES ROLES */
}
