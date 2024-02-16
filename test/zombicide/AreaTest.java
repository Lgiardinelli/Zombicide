package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zombicide.actor.Survivor;
import zombicide.actor.Zombie;
import zombicide.actor.zombie.Abomination;
import zombicide.actor.zombie.Walker;
import zombicide.area.Room;
import zombicide.area.Street;
import zombicide.area.room.TheContinental;
import zombicide.area.room.ThePharmacy;

class AreaTest {

	//Area
	private Area room;
	private Area street;
	private Area pharmacy;
	private Area continental;

	//Actor
	private Survivor survivor;
	private Survivor survivor2;
	private Zombie walker;
	private Zombie abomination;
	
	@BeforeEach
	public void before() {
		//Area
		this.room = new Room(6,7);
		this.street = new Street(4,5);
		this.pharmacy = new ThePharmacy(3,4);
		this.continental = new TheContinental(2,7);
		//Actor
		this.survivor = new Survivor();
		this.survivor2 = new Survivor();
		this.walker = new Walker();
		this.abomination = new Abomination();
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

	@Test
	void testAddAndGetNbSurvivor() {
		room.addSurvivor(survivor);
		assertEquals(room.getNbSurvivors(), 1);
		room.addSurvivor(survivor2);
		assertEquals(room.getNbSurvivors(), 2);
	}

	@Test
	void testAddAndGetNbZombie(){
		room.addZombie(abomination);
		assertEquals(room.getNbZombies(), 1);
		room.addZombie(walker);
		assertEquals(room.getNbZombies(), 2);
	}
	
	@Test
    void testAreaCanFight() {
		//Room
		assertTrue(room.canFight());
        
        //Continental
        assertFalse(continental.canFight());
        
        //Pharmacy
        assertTrue(pharmacy.canFight());
    }
	
	/**
	 * Faire les tests sur la précence de loot dans area et corriger avec un beforeEach 
	 */
	/**
	@Test
	void testLootInArea() {
		//Room
		Area room = new Room(1,2);
		
		//Continental
		Area continental = new TheContinental(4,4);
		
		//Pharmacy
		Area pharmacy = new ThePharmacy(6,6);
	}
	*/
	
	@Test
	void testPositionOfArea() {
		assertEquals(room.getX(), 6);
		assertEquals(room.getY(), 7);
	}
	
}
