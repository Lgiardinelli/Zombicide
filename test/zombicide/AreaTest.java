package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AreaTest {
	@Test
    void testAreaInitialization() {
		//Room
        Area room = new Room(1, 2, 4);
        assertNotNull(room);
        assertEquals(1, room.getX());
        assertEquals(2, room.getY());
        
        //Street
        Area street = new Street(4,5);
        assertNotNull(street);
        assertEquals(4, street.getX());
        assertEquals(5, street.getY());
    }

	@Test
    void testAreaSurvivorList() {
		//Room
        Area room = new Room(1, 2, 4);
        assertNotNull(room);
        assertTrue(room.getSurvivors().isEmpty());

        Survivor survivor = new Survivor("John");
        room.addSurvivor(survivor);

        assertFalse(room.getSurvivors().isEmpty());
        assertTrue(room.getSurvivors().contains(survivor));
        
        //Street
        Area street = new Street(1, 2, 4);
        assertNotNull(street);
        assertTrue(street.getSurvivors().isEmpty());

        Survivor survivor = new Survivor("Elies");
        street.addSurvivor(survivor);

        assertFalse(street.getSurvivors().isEmpty());
        assertTrue(street.getSurvivors().contains(survivor));
    }
	
	@Test
    void testAreaZombieList() {
		//Room
        Area room = new Room(1, 2, 4);
        assertNotNull(room);
        assertTrue(room.getZombies().isEmpty());

        Zombie zombie = new Zombie();
        room.addZombie(zombie);

        assertFalse(room.getZombies().isEmpty());
        assertTrue(room.getZombies().contains(zombie));
        
        //Street
        Area street = new Street(1, 2, 4);
        assertNotNull(street);
        assertTrue(street.getZombies().isEmpty());

        Zombie zombie = new Zombie();
        street.addZombie(zombie);

        assertFalse(street.getZombies().isEmpty());
        assertTrue(street.getZombies().contains(zombie));
	}
	
	@Test
    void testAreaCanFight() {
		//Room
        Area room = new Room(1, 2, 4);
        assertTrue(room.canFight());

        room.addZombie(new Zombie());
        assertFalse(room.canFight());
        
        //Street
        Area street = new Street(1, 2);
        assertTrue(street.canFight());

        street.addZombie(new Zombie());
        assertFalse(street.canFight());
    }
	
}
