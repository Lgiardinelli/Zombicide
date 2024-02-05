package zombicide;


public class Survivor extends Actor {

    private int skillPoints;
    private BackPack backpack;
    private Weapon handleWeapon;

    /**
     * Constructs a new Survivor object with default action points and life points.
     * The survivor starts with 3 action points and 5 life points.
     */
    public Survivor() {
        this.actionPoints = 3;
        this.lifePoints = 5;
    }

    /**
     * Handles the given weapon by the survivor. If the survivor already has a handled weapon,
     * it is added to the backpack before setting the new handled weapon.
     *
     * @param weapon The weapon to be handled by the survivor.
     */
    public void handleWeapon(Weapon weapon) {
        if (this.handleWeapon != null) {
            this.backpack.addEquipment(this.handleWeapon);
        }
        this.handleWeapon = weapon;
    }
    
    
}
