package helloworld.creational.singleton;

import helloworld.HelloWorld;

/**
 * @author yihua.huang@dianping.com
 */
public class HelloWorldSingleton implements HelloWorld {

    @Override
    public String helloWorld() {
        return "Hello Singleton!";
    }

    public static HelloWorldSingleton instance() {
        return HelloWorldSingletonHolder.INSTANCE;
    }

    private HelloWorldSingleton() {

    }

    //静态内部类
    static class HelloWorldSingletonHolder {
        private static final HelloWorldSingleton INSTANCE = new HelloWorldSingleton();
    }

}
