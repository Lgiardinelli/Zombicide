package zombicide.actor.action;

import zombicide.Area;
import zombicide.SurvivorAction;
import zombicide.actor.Survivor;

public class NoiseAction implements SurvivorAction {

    private Survivor survivor;

    /**
        Increases the noise level in the current area where the survivor is located.
        If the survivor is not in any area, no noise level is increased.
     */
    public void makeNoise(){
        Area currentArea = survivor.getCurrentArea();
        if(currentArea != null){
            currentArea.increaseNoiseLevel();
        }
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
