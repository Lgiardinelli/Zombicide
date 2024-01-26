package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoomTest {

	@Test
	void testRoomInitialization() {
		City city = new City(10,10);
		Room room = new Room(5, 6, 4);
		city.addRoom(room);
		assertNotNull(city.getArea(5, 6));
	}
}
