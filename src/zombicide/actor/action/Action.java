package zombicide.actor.action;

public interface Action {
    default void doSomething() {
        System.out.printf("%nHey ! '%s' called here !%n", getClass().getSimpleName());
    }
}
