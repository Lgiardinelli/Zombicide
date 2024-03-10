package zombicide.action;

public interface ActorAction {
    default void doSomething() {
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
    }
}
