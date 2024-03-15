package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zombicide.area.Area;
import zombicide.area.room.Room;
import zombicide.city.City;

class CityTest {

	private City city;
	private	Room room;
	
	@BeforeEach
    public void before() {
		city = new City(10,10);
		room = new Room(5,5);
	}
	
	@Test
	void testInitializationCity() {
		assertNotNull(city);
	}
	
	@Test
	void testCheckSizeOfCity() {
		assertEquals(city.getHeight(), 10);
		assertEquals(city.getWidth(), 10);
	}
	
	@Test
	void testGetArea() {
		zombicide.area.Area[][] area2 = city.getAreas();
		for (int i = 0; i < 10; i++) {
	        for (int j = 0; j < 10; j++) {
	            assertNotNull(area2[i][j]);
	        }
	    }
	}
	
	@Test
	void testGetCellUp() {
	    zombicide.area.Area[][] areas = city.getAreas();
	    zombicide.area.Area expectedArea = areas[1][2];
	    Area actualArea = city.getCellUp(2, 2);
	    assertEquals(expectedArea, actualArea);
	}

	@Test
	void testGetRoom() {
		assertTrue(city.getRooms() != null && !city.getRooms().isEmpty());
	}

	@Test
	void testGetSpawn() {
		assertTrue(city.getSpawn() != null);
	}
}

