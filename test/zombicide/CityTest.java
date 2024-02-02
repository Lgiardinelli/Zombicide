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
}
