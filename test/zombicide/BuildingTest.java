package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuildingTest {

	@Test
	public void checkIfBuildingHaveRoom() {
		Building building = new Building(4, 4);
		Room room = new Room(2);
		building.addRoom(room, 2, 2);
		assertNotNull(building.getRoom(2, 2));
	}

}
