package zombicide.item.careItem;

import zombicide.actor.action.HealAction;

public class HealingFiask extends CareItem {

    public String toString(){
        return "healing flask";
    }

    @Override
    public void use() {
        HealAction h = new HealAction(this.survivor);
        h.doSomething();
    }

}
