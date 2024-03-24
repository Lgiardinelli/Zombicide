package zombicide.actor.action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.city.City;
import zombicide.actor.zombie.Zombie;
import zombicide.util.Position;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Walker;
import zombicide.city.area.Area;
import zombicide.city.area.street.Street;
import zombicide.util.Direction;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        this.m1 = new MoveAction(Direction.DOWN, s1);
        this.m2 = new MoveAction(Direction.LEFT, z1);
    }

    @Test
    public void testPositionAfterMoving(){
        Position p1 = m1.positionAfterMoving();
        Position p2 = m2.positionAfterMoving();

        assertEquals(p1.getY(), 4);
        assertEquals(p2.getX(), 1);
    }

    @Test
    public void testDoSomething(){
        m1.doSomething();
        assertEquals(s1.getArea(), city.getArea(2,4));
    }
}
