package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CityTest {

	@Test
	void testAddRoom() {
		City city = new City(10, 10);
		Room room = new Room(4, 5, 4);
		city.addRoom(room);
	}
}
