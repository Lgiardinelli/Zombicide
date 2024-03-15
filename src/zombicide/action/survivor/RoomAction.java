package zombicide.action.survivor;

import zombicide.action.SurvivorAction;

public class RoomAction implements SurvivorAction {

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
    }
}
