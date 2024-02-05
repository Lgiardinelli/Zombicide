package zombicide;

import java.util.ArrayList;
import java.util.List;

public class Survivor extends Actor {

    private int skillPoints;
    private BackPack backpack;
    private Item handleItem;
    private List<Role> rolePlayer;

    /**
     * Constructs a new Survivor object with default action points and life points.
     * The survivor starts with 3 action points and 5 life points.
     */
    public Survivor(Role role) {
    	this.skillPoints = 0;
        this.actionPoints = 3;
        this.lifePoints = 5;
        this.rolePlayer = new ArrayList<>();
    }

    /**
     * Handles the given weapon by the survivor. If the survivor already has a handled weapon,
     * it is added to the backpack before setting the new handled weapon.
     *
     * @param weapon The weapon to be handled by the survivor.
     */
    public void handleItem(Item item) {
        if (this.handleItem != null) {
            this.backpack.addItem(this.handleItem);
        }
        this.handleItem = item;
    }

	public int getSkillPoints() {
		return skillPoints;
	}

	public BackPack getBackpack() {
		return backpack;
	}

	public Item getHandleItem() {
		return handleItem;
	}

	public List<Role> getRolePlayer() {
		return rolePlayer;
	}
    
    
    
    
}
