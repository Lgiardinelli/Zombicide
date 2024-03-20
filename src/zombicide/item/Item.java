package zombicide.item;

import zombicide.actor.survivor.Survivor;

public abstract class Item {

    protected Survivor survivor;

    protected boolean canOpen;

    public Item(){
        this.survivor = null;
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
}
