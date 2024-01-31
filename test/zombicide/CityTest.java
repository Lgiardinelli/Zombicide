package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CityTest {

	@Test
	void testInitializationCity() {
		City city = new City(10,10);
		assertNotNull(city);
	}
	
	
}
