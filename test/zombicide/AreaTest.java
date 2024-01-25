package zombicide;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AreaTest {
	@Test
    void testAreaInitialization() {
        Area area = new Room(1, 2, 4);
        assertNotNull(area);
        assertEquals(1, area.getX());
        assertEquals(2, area.getY());
    }

}
