package zombicide.action;

public interface SurvivorAction extends ActorAction {
    default void doSomething() {
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
    }
}
