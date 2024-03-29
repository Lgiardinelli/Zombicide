package zombicide.actor.action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.action.MoveAction;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Walker;
import zombicide.actor.zombie.Zombie;
import zombicide.city.City;
import zombicide.city.area.Area;
import zombicide.city.area.street.Street;
import zombicide.util.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveActionTest {

    private MoveAction m1;
    private MoveAction m2;
    private Survivor s1;
    private Zombie z1;
    private City city;

    @BeforeEach
    public void before(){
        city = new City(5,5);
        s1 = new Survivor(city);
        z1 = new Walker(city);
        Area area = new Street(2, 3);
        s1.setArea(area);
        z1.setArea(area);
        this.m1 = new MoveAction();
        this.m1.setActor(s1);
        this.m2 = new MoveAction();
        this.m2.setActor(z1);
    }

    @Test
    public void testPositionAfterMoving(){
        Position p1 = m1.positionAfterMoving();
        Position p2 = m2.positionAfterMoving();

        assertTrue(p1.getY() == 4 || p1.getY() == 2 || p1.getY() == 3);
        assertTrue(p2.getX() == 1 || p2.getX() == 3 || p2.getX() == 2);
    }

    @Test
    public void testDoSomething(){
        m1.doSomething(z1);
        //assertEquals(s1.getArea(), city.getArea(2,4));
    }
}
