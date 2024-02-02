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
		City city = new City(10,10);
		assertNotNull(city);
	}
	
	@Test
	void testCheckSizeOfCity() {
		City city = new City(10,10);
		assertEquals(city.getHeight(), 10);
		assertEquals(city.getWidth(), 10);
	}
}
