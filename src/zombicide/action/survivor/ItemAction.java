package zombicide.action.survivor;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;

public class ItemAction implements Action<Survivor> {

    @Override
    public void doSomething(Survivor survivor){
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
        Item itemUsed = survivor.getItemHeld();
        itemUsed.use();
        survivor.removeActionPoint();
    }
}
