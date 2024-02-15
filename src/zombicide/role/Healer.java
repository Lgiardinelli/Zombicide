package zombicide.role;

import zombicide.actor.Survivor;

import java.util.List;

public class Healer extends Role {

    private static final int NB_LIFE_POINTS = 1;

    public Healer() {
        super();
    }

    public void addLifePoint(List<Survivor> survivors) {
        for (Survivor survivor : survivors) {
            survivor.addLifePoints(NB_LIFE_POINTS);
        }
    }


}
