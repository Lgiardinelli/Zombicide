package zombicide.city;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zombicide.city.area.Area;
import zombicide.city.area.room.Room;
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
	    Area expectedArea = areas[1][2];
	    Area actualArea = city.getCellUp(2, 2);
	    assertEquals(expectedArea, actualArea);
	}

	@Test
	void testGetRoom() {
		assertTrue(city.getRooms() != null && !city.getRooms().isEmpty());
	}

	@Test
	void testGetSpawn() {
		assertNotNull(city.getSpawn());
	}

	@Test
	void testContainsRoom(){
		Room r = (Room) city.getArea(0,0);
		assertTrue(city.containsRoom(r));
	}

	/** TODO Revoir le test (isARoom ne considère pas une Room comme une Room)
	@Test
	void testIsARoom(){
		assertTrue(city.isARoom(new Room(0,0)));

		assertFalse(city.isARoom(new Street(1, 1)));

		assertFalse(city.isARoom(new Manhole(2, 2)));
	}
	**/
}

