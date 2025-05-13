package helloworld.behavioral.strategy;

/**
 * @author luzhicheng
 * @date 2025/5/12 17:32
 */
public class StrategyDemo {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.setQuackBehavior(new Squeak());
        duck.performQuack();
        duck.setQuackBehavior(new Quack());
        duck.performQuack();
    }
}
interface QuackBehavior {
    void quack();
}

class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack!");
    }
}

class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("squeak!");
    }
}

class Duck {
    private QuackBehavior quackBehavior;
    public void performQuack() {
        if (quackBehavior != null) {
            quackBehavior.quack();
        }
    }
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}