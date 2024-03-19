package zombicide.actor.action;

import zombicide.actor.survivor.Survivor;
import zombicide.city.area.Area;

public class NoiseAction implements ActorAction {

    private Survivor survivor;

    private int noiseLevel;

    /**
        Increases the noise level in the current area where the survivor is located.
        If the survivor is not in any area, no noise level is increased.
        @param s - the survivor
     */
    public NoiseAction(Survivor s){
        this.survivor = s;
    }

    public void setLifePointsToAdd(int n){
        this.noiseLevel = n;
    }

    public void setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    /**
     * Increases the noise level in the current area where the survivor is located.
     * If the survivor is not in any area, no noise level is increased.
     */
    public void doSomething(){
        Area currentArea = survivor.getArea();
        if(currentArea != null){
            currentArea.increaseNoiseLevel(this.noiseLevel);
        }
        this.survivor.removeActionPoint();
    }

    /**
     * Sets the survivor associated with this NoiseAction.
     * This method establishes a connection between the NoiseAction and a specific Survivor,
     * allowing the NoiseAction to interact with the Survivor during noise-related actions.
     *
     * @param survivor The Survivor to be associated with this NoiseAction.
     */
    public void setSurvivor(Survivor survivor) {
        this.survivor = survivor;
    }
}
