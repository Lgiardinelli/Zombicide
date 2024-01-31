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
		
		room.addDoor(DoorDirection.UP);
		
		Door addedDoor = room.getDoor(DoorDirection.UP);
		
		assertNotNull(addedDoor);
		assertEquals(room.getDoor(DoorDirection.UP), addedDoor);
	}
	
	@Test
	void testAddAllDoorInRoom() {
		Room room = new Room(5,6);

		room.addAllDoors();
		
		assertNotNull(room.getDoors());
		for(DoorDirection direction : DoorDirection.values()) {
			Door door = room.getDoor(direction);
			assertNotNull(door);
		}
	}
	
	@Test
	void testDoorIsOpen() {
		Room room = new Room(5,6);
		room.addDoor(DoorDirection.UP);
		assertNotNull(room.getDoor(DoorDirection.UP));
		room.getDoor(DoorDirection.UP).open();
		assertTrue(room.getDoor(DoorDirection.UP).isOpen());
	}
	
}
