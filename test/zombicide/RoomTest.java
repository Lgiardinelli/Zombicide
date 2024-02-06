package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zombicide.area.Room;

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
	void testAddAllDoorInRoom() {		
		assertNotNull(room.getDoors());
		for(DoorDirection direction : DoorDirection.values()) {
			Door door = room.getDoor(direction);
			assertNotNull(door);
		}
	}
}
