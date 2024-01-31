package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoomTest {

	@Test
	void testRoomInitialization() {
		Room room = new Room(5, 6);
		assertNotNull(room);
	}
	
	@Test 
	void testAddDoorInRoom() {
		Room room = new Room(5,6);
		
		DoorDirection direction = DoorDirection.UP;
		room.addDoor(direction);
		
		Door addedDoor = room.getDoor(direction);
		
		assertNotNull(addedDoor);
		assertEquals(room.getDoor(DoorDirection.UP), addedDoor);
	}
}
