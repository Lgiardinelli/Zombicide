package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AreaTest {
	@Test
    void testAreaInitialization() {
		//Room
        Area room = new Room(5, 6);
        assertNotNull(room);
        
        //Street
        Area street = new Street(4,5);
        assertNotNull(street);
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
        Area street = new Street(1, 2);
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
        Area street = new Street(1, 2);
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
		Area room = new Room(1, 2);
		assertTrue(room.canFight());
        
        //Continental
        Area continental = new TheContinental(4,4);
        assertFalse(continental.canFight());
        
        //Pharmacie
        Area pharmacy = new ThePharmacy(6,6);
        assertTrue(pharmacy.canFight());
    }
	
	/**
	 * Faire les tests sur la précence de loot dans area
	 */
	
}
