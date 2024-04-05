package zombicide.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.actor.survivor.Survivor;
import zombicide.city.City;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapTest {

    private Map map;

    @BeforeEach
    public void setUp() {
        map = new Map();
    }

    @Test
    public void init() {
        assertFalse(map.canOpen());
        assertFalse(map.canAttack());
        assertFalse(map.isNoisyWhenUsedToOpenDoor());
        assertTrue(map.isNoisyWhenUsed());
    }

    /*
    public void use() {
		City city = this.survivor.getCity();
		System.out.println("Affichage de la map 'Action map' :");
		city.display();
	}
     */
    @Test
    public void testUseMap() {
        City city = new City(5, 5);
        Map map = new Map();
        Survivor survivor = new Survivor(city);
        survivor.setItemHeld(map);
        map.setSurvivor(survivor);
    }


}
