package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AreaTest {
	
	private Area room;
	private Area street;
	private Area pharmacy;
	private Area continental;
	
	@BeforeEach
	public void before() {
		this.room = new Room(6,7);
		this.street = new Street(4,5);
		this.pharmacy = new ThePharmacy(3,4);
		this.continental = new TheContinental(2,7);
	}
	
	@Test
    void testAreaInitialization() {
		//Room
        assertNotNull(room);
        
        //Street
        assertNotNull(street);
        
        //Pharmacy
        assertNotNull(pharmacy);
        
        //Continental
        assertNotNull(continental);
    }

	/**
	 * Corriger les tests avec le beforeEach
	 */
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
	
	
	/**
	 * Corriger les tests avec le beforeEach
	 */
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
        
        //Pharmacy
        Area pharmacy = new ThePharmacy(6,6);
        assertTrue(pharmacy.canFight());
    }
	
	/**
	 * Faire les tests sur la précence de loot dans area
	 */
	@Test
	void testLootInArea() {
		//Room
		Area room = new Room(1,2);
		
		//Continental
		Area continental = new TheContinental(4,4);
		
		//Pharmacy
		Area pharmacy = new ThePharmacy(6,6);
	}
	
	@Test
	void testPositionOfArea() {
		Area area = new Room(1,2);
		assertEquals(area.getX(), 1);
		assertEquals(area.getY(), 2);
	}
	
}
