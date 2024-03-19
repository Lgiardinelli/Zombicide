package zombicide.actor.action;


import zombicide.actor.survivor.Survivor;

public class BackPackAction implements ActorAction {

    private Survivor survivor;

    public BackPackAction(Survivor s){
        this.survivor = s;
    }

    public void doSomething() {
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());

    }


}
