package zombicide.actor;

import java.util.ArrayList;
import java.util.List;

import zombicide.Actor;
import zombicide.BackPack;
import zombicide.Item;
import zombicide.Role;

/**
 * Represents a survivor actor in the game.
 */
public class Survivor extends Actor {

    /** The skill points of the survivor. */
    private int skillPoints;

    /** The backpack of the survivor to carry items. */
    private BackPack backpack;

    /** The item currently handled by the survivor. */
    private Item handleItem;

    /** The roles associated with the survivor. */
    private List<Role> rolePlayer;

    /**
     * Constructs a new Survivor object with default action points and life points.
     * The survivor starts with 3 action points and 5 life points.
     *
     * @param role The role of the survivor.
     */
    public Survivor(Role role) {
        this.skillPoints = 0;
        this.actionPoints = 3;
        this.lifePoints = 5;
        this.rolePlayer = new ArrayList<>();
    }

    /**
     * Handles the given item by the survivor. If the survivor already has a handled item,
     * it is added to the backpack before setting the new handled item.
     *
     * @param item The item to be handled by the survivor.
     */
    public void handleItem(Item item) {
        if (this.handleItem != null) {
            this.backpack.addItem(this.handleItem);
        }
        this.handleItem = item;
    }

    /**
     * Gets the skill points of the survivor.
     *
     * @return The skill points.
     */
    public int getSkillPoints() {
        return skillPoints;
    }

    /**
     * Gets the backpack of the survivor.
     *
     * @return The backpack.
     */
    public BackPack getBackpack() {
        return backpack;
    }

    /**
     * Gets the item currently handled by the survivor.
     *
     * @return The handled item.
     */
    public Item getHandleItem() {
        return handleItem;
    }

    /**
     * Gets the roles associated with the survivor.
     *
     * @return The list of roles.
     */
    public List<Role> getRolePlayer() {
        return rolePlayer;
    }
}
