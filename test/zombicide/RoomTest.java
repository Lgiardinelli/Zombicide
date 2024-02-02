package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoomTest {

	private Room room;
	
	@BeforeEach
	private void before() {
		room = new Room(5,6);
	}
	
	@Test
	void testRoomInitialization() {
		assertNotNull(room);
	}
	
	@Test 
	void testAddDoorInRoom() {
		room.addDoor(DoorDirection.UP);
		Door addedDoor = room.getDoor(DoorDirection.UP);
		
		assertNotNull(addedDoor);
		assertEquals(room.getDoor(DoorDirection.UP), addedDoor);
	}
	
	@Test
	void testAddAllDoorInRoom() {
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
	
	@Test
	void testDoorIsClose() {
		Room room = new Room(5,6);
		room.addDoor(DoorDirection.UP);
		assertNotNull(room.getDoor(DoorDirection.UP));
		assertFalse(room.getDoor(DoorDirection.UP).isOpen());
	}
	
	@Test
	void testCloseTheDoor() {
		Room room = new Room(5,6);
		room.addDoor(DoorDirection.UP);
		Door addedDoor = room.getDoor(DoorDirection.UP);
		assertNotNull(addedDoor);
		addedDoor.open();
		assertTrue(addedDoor.isOpen());
		addedDoor.close();
		assertFalse(addedDoor.isOpen());
	}
	
}
