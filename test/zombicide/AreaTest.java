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

	@Test
    void testAreaSurvivorList() {
        Area area = new Room(1, 2, 4);
        assertNotNull(area);
        assertTrue(area.getSurvivors().isEmpty());

        Survivor survivor = new Survivor("John");
        area.addSurvivor(survivor);

        assertFalse(area.getSurvivors().isEmpty());
        assertTrue(area.getSurvivors().contains(survivor));
    }
}
