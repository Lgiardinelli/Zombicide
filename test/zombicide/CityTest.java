package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CityTest {

	@Test
	public void checkIfCityCanBeSplit() {
		City city = new City(5, 5);
		city.createCity();
		assertTrue(city.canBeSplit());
	}
}
