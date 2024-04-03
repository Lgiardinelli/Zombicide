package zombicide.action.survivor;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;
import zombicide.city.area.Area;

public class NoiseAction implements Action<Survivor> {

    private int noiseLevel;

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
    public void doSomething(Survivor survivor){
        Area currentArea = survivor.getArea();
        if(currentArea != null){
            currentArea.increaseNoiseLevel(this.noiseLevel);
        }
        survivor.removeActionPoint();
    }
}
