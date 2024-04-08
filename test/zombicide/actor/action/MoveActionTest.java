package zombicide.actor.action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.action.Action;
import zombicide.action.MoveAction;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Walker;
import zombicide.actor.zombie.Zombie;
import zombicide.city.City;
import zombicide.city.area.Area;
import zombicide.city.area.street.Street;

import java.util.Arrays;
import java.util.List;

public class MoveActionTest {

    private MoveAction m1;
    private MoveAction m2;
    private Survivor s1;
    private Zombie z1;
    private City city;

    @BeforeEach
    public void before(){
        List<Action<Zombie>> zombieSurvivor = Arrays.asList(
                new MoveAction<>()
        );
        city = new City(5,5);
        s1 = new Survivor(city);
        z1 = new Walker(zombieSurvivor , city);
        Area area = new Street(2, 3);
        s1.setArea(area);
        z1.setArea(area);
        this.m1 = new MoveAction();
        this.m2 = new MoveAction();
    }

    @Test
    public void testDoSomething(){
        m1.doSomething(z1);
        //assertEquals(s1.getArea(), city.getArea(2,4));
    }
}
