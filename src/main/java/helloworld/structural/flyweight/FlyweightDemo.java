package helloworld.structural.flyweight;

import java.util.HashMap;

/**
 * @author luzhicheng
 * @date 2025/5/12 14:47
 */
public class FlyweightDemo {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        //共享 享元对象
        Flyweight flyweight1 = factory.getFlyweight("aa");
        Flyweight flyweight2 = factory.getFlyweight("aa");
        flyweight1.doOperation("x");
        flyweight2.doOperation("y");
    }
}

interface Flyweight {
    void doOperation(String extrinsicState);
}
class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;
    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }
    @Override
    public void doOperation(String extrinsicState) {
        System.out.println("Object address: " + System.identityHashCode(this));
        System.out.println("IntrinsicState: " + intrinsicState);
        System.out.println("ExtrinsicState: " + extrinsicState);
    }
}

class FlyweightFactory {
    private HashMap<String, Flyweight> flyweights = new HashMap<>();
    Flyweight getFlyweight(String intrinsicState) {
        if (!flyweights.containsKey(intrinsicState)) {
            Flyweight flyweight = new ConcreteFlyweight(intrinsicState);
            flyweights.put(intrinsicState, flyweight);
        }
        return flyweights.get(intrinsicState);
    }
}