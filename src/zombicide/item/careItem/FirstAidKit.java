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

    public Survivor chooseAPlayer(){
        Area a = this.survivor.getArea();
        List<Survivor> survivors = a.getSurvivors();
        ListChooser<Survivor> chooser = new RandomListChooser<>();
        Survivor s = chooser.choose(survivors);
        return  s;
    }


}
