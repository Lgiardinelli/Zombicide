package zombicide.item;

import zombicide.actor.survivor.Survivor;

public abstract class Item {

    protected Survivor survivor;

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
}
