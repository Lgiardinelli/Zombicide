package zombicide.actor.action.attack;

import org.junit.jupiter.api.BeforeEach;
import zombicide.action.survivor.DoorAction;
import zombicide.action.MoveAction;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Abomination;
import zombicide.actor.zombie.Zombie;
import zombicide.city.City;
import zombicide.item.weapon.Weapon;

public class DoorActionTest {
    private MoveAction moveAction;
    private DoorAction doorAction;
    private Survivor survivor;
    private Zombie zombie;

    @BeforeEach
    public void setup() {
        City city = new City(10, 10);
        survivor = new Survivor(city);
        moveAction = new MoveAction();
        moveAction.doSomething(survivor);
        // attackZombieAction = new AttackZombieAction(survivor);
    }

}
