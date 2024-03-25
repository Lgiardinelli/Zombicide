package zombicide.item;

import zombicide.actor.survivor.Survivor;

public abstract class Item {

    protected Survivor survivor;

    protected boolean canOpen;

    protected boolean canAttack;

    protected boolean isNoisyDoor;

    protected boolean isNoisyAttack;

    public Item(){
        this.survivor = null;
        this.canAttack = false;
        this.canOpen = false;
        this.isNoisyDoor = false;
        this.isNoisyAttack = false;
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


}
