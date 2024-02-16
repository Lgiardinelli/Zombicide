package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zombicide.area.Room;
import zombicide.area.Street;
import zombicide.area.room.TheContinental;
import zombicide.area.room.ThePharmacy;

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
