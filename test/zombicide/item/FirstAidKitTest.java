package zombicide.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.action.survivor.DoorAction;
import zombicide.action.survivor.HealAction;
import zombicide.actor.survivor.Survivor;
import zombicide.city.City;
import zombicide.city.area.room.Room;
import zombicide.item.careItem.FirstAidKit;
import zombicide.item.careItem.HealingFiask;
import zombicide.util.Direction;

import static org.junit.jupiter.api.Assertions.*;

public class FirstAidKitTest {

    private FirstAidKit firstAidKit;

    private Survivor s;

    private HealAction h;



    @BeforeEach
    public void setUp() {
        firstAidKit = new FirstAidKit();
        firstAidKit.setLifePointsToAdd(1);
        s = new Survivor(new City(5 , 5));
        firstAidKit.setSurvivor(s);
        s.setArea(new Room(4,4));
        h = new HealAction();
    }

    @Test
    public void init() {
        assertFalse(firstAidKit.canOpen());
        assertFalse(firstAidKit.canAttack());
        assertFalse(firstAidKit.isNoisyWhenUsedToOpenDoor());
        assertTrue(firstAidKit.isNoisyWhenUsed());
    }

    @Test
    public void useTest(){
        firstAidKit.use();
        assertEquals(s.getLifePoints() , 6);
    }


}
