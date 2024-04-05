package zombicide.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.action.survivor.DoorAction;
import zombicide.actor.survivor.Survivor;
import zombicide.city.City;
import zombicide.city.area.room.Room;
import zombicide.util.Direction;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MasterKeyTest {

    private MasterKey masterkey;

    private Survivor s;



    @BeforeEach
    public void setUp() {
        masterkey = new MasterKey();
        s = new Survivor(new City(5 , 5));
        masterkey.setSurvivor(s);
        s.setArea(new Room(4,4));
    }

    @Test
    public void init() {
        assertTrue(masterkey.canOpen());
        assertFalse(masterkey.canAttack());
        assertFalse(masterkey.isNoisyWhenUsedToOpenDoor());
        assertTrue(masterkey.isNoisyWhenUsed());
    }

    @Test
    public void useTest(){
        DoorAction d = new DoorAction();
        d.doSomething(s);
        assertTrue(s.getArea().getDoor(Direction.UP).isOpen() || s.getArea().getDoor(Direction.LEFT).isOpen());
    }


}
