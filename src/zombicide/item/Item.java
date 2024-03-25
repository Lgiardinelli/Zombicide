package zombicide.item;

import zombicide.actor.survivor.Survivor;

public abstract class Item {

    protected Survivor survivor;

    protected boolean canOpen;

    protected boolean canAttack;

    protected boolean isNoisyDoor;

    protected boolean isNoisyUse;

    public Item(){
        this.survivor = null;
        this.canAttack = false;
        this.canOpen = false;
        this.isNoisyDoor = false;
        this.isNoisyUse = false;
    }

    public void setSurvivor(Survivor s){
        this.survivor = s;
    }

    public Survivor getSurvivor(){
        return this.survivor;
    }

    public abstract void use();

    public boolean canOpen() {
        return this.canOpen;
    }

    public boolean canAttack() {
        return this.canAttack;
    }

    public boolean isNoisyWhenUsedToOpenDoor(){
        return this.isNoisyDoor;
    }
    public boolean isNoisyWhenUsed(){
        return this.isNoisyUse;
    }

}
