package zombicide.actor.action.attack;

import org.junit.jupiter.api.BeforeEach;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Abomination;
import zombicide.actor.zombie.Zombie;
import zombicide.city.City;
import zombicide.item.weapon.Weapon;

public class AttackZombieActionTest {

    private AttackZombieAction attackZombieAction;
    private Survivor survivor;
    private Zombie zombie;
    private Weapon weapon;

    @BeforeEach
    public void setup() {
        City city = new City(10, 10);
        survivor = new Survivor(city);
        zombie = new Abomination(city);
        attackZombieAction = new AttackZombieAction(survivor);
    }
}
