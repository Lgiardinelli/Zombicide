package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoomTest {

	@Test
	void testRoomInitialization() {
		Room room = new Room(5, 6);
		assertNotNull(room);
	}

}
