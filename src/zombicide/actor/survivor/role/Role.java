package zombicide.actor.survivor.role;

import zombicide.actor.survivor.Survivor;

public abstract class Role {
    protected Survivor survivor;

    public abstract void handleAction();

    public void setSurvivor(Survivor survivor) {
        this.survivor = survivor;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
