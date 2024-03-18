package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.zombie.Abomination;
import zombicide.actor.zombie.Walker;
import zombicide.city.area.Area;
import zombicide.city.area.room.Room;
import zombicide.city.area.street.Street;
import zombicide.city.area.room.TheContinental;
import zombicide.city.area.room.ThePharmacy;
import zombicide.city.City;

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

	private City city;
	
	@BeforeEach
	public void before() {
		//Area
		this.room = new Room(6,7);
		this.street = new Street(4,5);
		this.pharmacy = new ThePharmacy(3,4);
		this.continental = new TheContinental(2,7);
		//Actor
		this.survivor = new Survivor(this.city);
		this.survivor2 = new Survivor(this.city);
		this.walker = new Walker(this.city);
		this.abomination = new Abomination(this.city);
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
	
	@Test
	void testPositionOfArea() {
		assertEquals(room.getX(), 6);
		assertEquals(room.getY(), 7);
	}

	@Test
	void testOpenLeftArea(){
		assertEquals(" R    ", room.openLeft1());
		assertEquals("      ", room.openLeft2());
	}

	@Test
	void testCloseLeftArea(){
		assertEquals("|R    ", room.closeLeft1());
		assertEquals("|     ", room.closeLeft2());
	}

	@Test
	void testGetSurvivorInArea(){
		room.addSurvivor(survivor);
		room.addSurvivor(survivor2);
		assertTrue(room.getSurvivors().contains(survivor));
		assertTrue(room.getSurvivors().contains(survivor2));
	}


}
