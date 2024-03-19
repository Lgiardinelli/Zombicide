package zombicide.actor.action;


import zombicide.actor.survivor.Survivor;
import zombicide.actor.survivor.backpack.BackPack;

public class BackPackAction implements ActorAction {

    private Survivor survivor;

    public BackPackAction(Survivor s){
        this.survivor = s;
    }

    public void doSomething() {
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
        takeOnHand();
    }

    public void takeOnHand(){
        BackPack bp = this.survivor.getBackpack();
        if(this.survivor.getHandleItem() != null) {
            bp.swapItemsHandBp();
        }else{
            bp.takeAItem();
        }
    }



}
