package zombicide.item;

import zombicide.actor.survivor.Survivor;

public abstract class Item {

    private Survivor survivor;

    public Item(){
        this.survivor = null;
    }

    public void setSurvivor(Survivor s){
        this.survivor = s;
    }

    public Survivor getSurvivor(){
        return this.survivor;
    }

}
