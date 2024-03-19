package zombicide.actor.action;

import zombicide.actor.survivor.Survivor;

public class AreaAction implements ActorAction {

    private Survivor survivor;

    public AreaAction(Survivor s) {
        this.survivor = s;
    }

    /**
     * TODO
     * @return boolean
     */
    public boolean searchRoom(){
        return true;
    }

    @Override
    public void doSomething() {
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
        this.survivor.getArea().displayActors();
    }
}
