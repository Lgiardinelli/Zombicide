package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zombicide.area.Room;

class CityTest {

	private City city;
	private	Room room;
	
	@BeforeEach
	private void before() {
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
		Area[][] area2 = city.getAreas();
		for (int i = 0; i < 10; i++) {
	        for (int j = 0; j < 10; j++) {
	            assertNotNull(area2[i][j]);
	        }
	    }
	}
	
	@Test
	void testGetCellUp() {
	    Area[][] areas = city.getAreas();
	    Area expectedArea = areas[0][8];
	    Area actualArea = city.getCellUp(0, 9);
	    assertEquals(expectedArea, actualArea);
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
}

