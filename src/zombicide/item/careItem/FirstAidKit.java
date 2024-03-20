package zombicide.item.careItem;

import zombicide.actor.action.HealAction;
import zombicide.actor.survivor.Survivor;
import zombicide.city.area.Area;
import zombicide.util.listchooser.ListChooser;
import zombicide.util.listchooser.RandomListChooser;

import java.util.List;

public class FirstAidKit extends CareItem {

    public String toString(){
        return "first aid kit";
    }

    @Override
    public void use() {
        HealAction h = new HealAction(chooseAPlayer());
        h.doSomething();
    }

    /**
     * Randomly chooses a survivor from the same area as the current survivor.
     *
     * @return The chosen survivor from the current area, or null if no survivors are present.
     */
    public Survivor chooseAPlayer() {
        Area currentArea = this.survivor.getArea();
        List<Survivor> survivorsInArea = currentArea.getSurvivors();

        ListChooser<Survivor> chooser = new RandomListChooser<>();

        return chooser.choose(survivorsInArea);
    }



}
