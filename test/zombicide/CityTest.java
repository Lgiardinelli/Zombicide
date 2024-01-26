package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CityTest {

	@Test
	void testCityInitialization() {
		City city = new City(10, 11);
		assertNotNull(city);
	}
	
	@Test
	void testCityAreaInitialization() {
		City city = new City(10,11);
		assertNotNull(city.getArea(5, 5));
	}
}
