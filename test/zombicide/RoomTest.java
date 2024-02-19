package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zombicide.area.Room;
import zombicide.item.careItem.HealingFiask;
import zombicide.item.weapon.Pistol;

class RoomTest {

	private Room room;
	private Door door;
	private BackPack backpack;

	@BeforeEach
	public void before() {
		room = new Room(5,6);
		door = new Door();
		backpack = new BackPack();
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

	@Test
	void testOpenAndCloseDoorInRoom(){
		room.addDoor(DoorDirection.UP, door);
		assertTrue(door.isOpen());
		door.close();
		assertFalse(door.isOpen());
		door.open();
		assertTrue(door.isOpen());
	}

	@Test
	void testLetItems() {

		Pistol item1 = new Pistol();
		HealingFiask item2 = new HealingFiask();
		backpack.addItem(item1);
		backpack.addItem(item2);


		room.letItems(backpack);


		assertTrue(room.getItems().contains(item1));
		assertTrue(room.getItems().contains(item2));
	}

}
