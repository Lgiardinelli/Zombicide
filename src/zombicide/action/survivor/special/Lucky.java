package zombicide.action.survivor.special;

import zombicide.action.survivor.AttackZombieAction;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.item.weapon.Weapon;

public class Lucky extends AttackZombieAction {

    @Override
    protected void shootZombie(Survivor survivor, Zombie zombie, Weapon weapon) {
        System.out.println("ici");
        int highestDieValue = getHighestDieValue(weapon.getNbDiceThrows() + 1);

        if (weapon.shotHitsTarget(highestDieValue)) {
            attackZombie(survivor, zombie, weapon);
        }
    }
}
