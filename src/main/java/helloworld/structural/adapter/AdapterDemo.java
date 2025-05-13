package helloworld.structural.adapter;

/**
 * @author luzhicheng
 * @date 2025/5/12 13:32
 */
public class AdapterDemo {
    public static void main(String[] args) {
        WildTurkey wildTurkey = new WildTurkey();
        //火鸡适配为鸭子
        TurkeyAdapter duck = new TurkeyAdapter(wildTurkey);
        duck.quack();
    }
}

interface Duck {
    void quack();
}

interface Turkey {
    void gobble();
}

class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble!");
    }
}

class TurkeyAdapter implements Duck {
    Turkey turkey;
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }
    @Override
    public void quack() {
        turkey.gobble();
    }
}