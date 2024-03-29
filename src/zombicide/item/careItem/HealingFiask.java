package zombicide.item.careItem;

import zombicide.action.survivor.HealAction;

public class HealingFiask extends CareItem {

    public String toString(){
        return "healing flask";
    }

    @Override
    public void use() {
        HealAction h = new HealAction();
        h.doSomething(survivor);
    }
}
