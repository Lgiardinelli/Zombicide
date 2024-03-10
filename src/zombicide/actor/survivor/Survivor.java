package zombicide.actor.survivor;

import java.util.*;

import zombicide.actor.Actor;
import zombicide.item.weapon.Pistol;
import zombicide.util.Expertise;
import zombicide.backpack.BackPack;
import zombicide.role.Role;
import zombicide.item.Item;
import zombicide.area.Area;

/**
 * Represents a survivor actor in the game.
 */
public class Survivor extends Actor {

    /** The skill points of the survivor. */
    private int skillPoints;

    /** The backpack of the survivor to carry items. */
    private final BackPack backpack;

    /** The item currently handled by the survivor. */
    private Item handleItem;

    /** The roles associated with the survivor. */
    private final List<Role> roles;

    /**
     * Creates a new survivor with the given roles.
     * You can pass either an array of roles, or as many roles in a row.
     *
     * @param roles The roles of the survivor.
     */
    public Survivor(Role... roles) {
        this.skillPoints = 0;
        this.actionPoints = 3;
        this.lifePoints = 5;
        this.backpack = new BackPack();
        this.handleItem = new Pistol();
        this.roles = new ArrayList<>(Arrays.asList(roles));
        for (Role role : this.roles)
            role.setSurvivor(this);
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

    public boolean hasRoles() {
        return !this.roles.isEmpty();
    }

    /**
     * Gets the roles associated with the survivor.
     *
     * @return The list of roles.
     */
    public List<Role> getRoles() {
        return roles;
    }
    
    /**
     * Increases the skill points of the survivor.
     */
    public void increaseSkillPoints() {
        if(this.skillPoints < 30) {
            this.skillPoints++;
        }
    }

    /**
     * @return True if the survivor has reached a new level, false otherwise.
     */
    public boolean isLevelReached() {
        return Expertise.getStage(skillPoints) != null;
    }

    @Override
    public void handleAction() {
    }

    @Override
    public void setArea(Area area) {
        if (this.area != null) {
            this.area.removeActor(this);
        }
        this.area = area;
        area.addSurvivor(this);
    }
}
