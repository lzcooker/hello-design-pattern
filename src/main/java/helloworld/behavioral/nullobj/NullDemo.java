package helloworld.behavioral.nullobj;

/**
 * @author luzhicheng
 * @date 2025/5/12 18:02
 */
public class NullDemo {
    public static void main(String[] args) {
        AbstractOperation abstractOperation = func(-1);
        abstractOperation.request();
    }
    public static AbstractOperation func(int para) {
        if (para < 0) {
            return new NullOperation();
        }
        return new RealOperation();
    }
}
abstract class AbstractOperation {
    abstract void request();
}
class RealOperation extends AbstractOperation {
    @Override
    void request() {
        System.out.println("do something");
    }
}

class NullOperation extends AbstractOperation{
    @Override
    void request() {
// do nothing
    }
}