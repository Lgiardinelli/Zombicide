package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CityTest {

	private City city;
	
	@BeforeEach
	private void before() {
		city = new City(10,10);
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
	
	
}

