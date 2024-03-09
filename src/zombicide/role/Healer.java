package zombicide.role;

import zombicide.actor.survivor.Survivor;

import java.util.List;
import java.util.Random;

public class Healer extends Role {
    private static final int NB_LIFE_POINTS = 1;
    private static final Random RANDOM = new Random();

    private void addLifePoints(List<Survivor> survivors) {
        int index = RANDOM.nextInt(survivors.size());
        survivors.get(index).addLifePoints(NB_LIFE_POINTS);
    }

    @Override
    public void handleAction() {
        List<Survivor> survivors = survivor.getArea().getSurvivors();
        addLifePoints(survivors);
    }
}
