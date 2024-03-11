package zombicide;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.action.actor.MoveAction;
import zombicide.actor.zombie.Walker;
import zombicide.area.Area;
import zombicide.area.street.Street;

public class MoveActionTest {

    private Zombie z1;
    private Survivor s1;

    private MoveAction m1;
    private MoveAction m2;

    @BeforeEach
    public void before(){
        this.s1 = new Survivor();
        this.z1 = new Walker();
        this.m1 = new MoveAction(ActorDirection.DOWN);
        this.m2 = new MoveAction(ActorDirection.LEFT);

        Area area = new Street(2, 3);

        s1.setArea(area);
        z1.setArea(area);
    }

    @Test
    public void testMove(){
        Position p1 = m1.PositionAfterMoving(s1);
        Position p2 = m2.PositionAfterMoving(z1);

        assertEquals(p1.getY(),4);
        assertEquals(p2.getX(),1);
    }
}
