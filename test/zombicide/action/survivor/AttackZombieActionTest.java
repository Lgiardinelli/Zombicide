package zombicide.action.survivor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.action.Action;
import zombicide.action.survivor.AttackZombieAction;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Abomination;
import zombicide.actor.zombie.Zombie;
import zombicide.city.City;
import zombicide.item.Map;
import zombicide.item.weapon.Weapon;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AttackZombieActionTest {

    private City city;
    private AttackZombieAction attackZombieAction;
    private Survivor survivor;
    private Zombie zombie;
    private Weapon weapon;

    @BeforeEach
    public void before() {
        List<Action<Survivor>> actionSurvivor = Arrays.asList(
                new AttackZombieAction()
        );
        this.city = new City(10, 10);
        survivor = new Survivor(actionSurvivor, city);
        zombie = new Abomination(city);
        int posX = zombie.getArea().getX();
        int posY = zombie.getArea().getY();
        survivor.setArea(this.city.getArea(posX, posY));
    }

    @Test
    public void canAttackTest() {
        survivor.setItemHeld(new Map());
        survivor.handleAction();
        System.out.println(survivor.getRoles());
        assertTrue(zombie.getLifePoints() == 6);
    }
}
