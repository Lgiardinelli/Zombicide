package zombicide.item;

import org.junit.jupiter.api.Test;
import zombicide.actor.survivor.Survivor;
import zombicide.city.City;

public class MapTest {

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
