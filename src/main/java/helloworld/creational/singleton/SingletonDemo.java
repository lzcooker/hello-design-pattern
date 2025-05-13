package helloworld.creational.singleton;

/**
 * @author luzhicheng
 * @date 2025/5/12 18:11
 */
public class SingletonDemo {
}
class Singleton {
    private static Singleton uniqueInstance;
    private Singleton() {
    }
    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}

class Singleton2 {
    private volatile static Singleton2 uniqueInstance;
    private Singleton2() {
    }
    public static Singleton2 getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton2.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton2();
                }
            }
        }
        return uniqueInstance;
    }
}