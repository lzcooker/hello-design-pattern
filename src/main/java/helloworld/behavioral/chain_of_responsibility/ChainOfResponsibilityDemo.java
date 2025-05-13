package helloworld.behavioral.chain_of_responsibility;

import com.sun.net.httpserver.Request;

/**
 * @author luzhicheng
 * @date 2025/5/12 15:33
 */
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);
        Request1 request1 = new Request1(RequestType.TYPE1, "request1");
        handler2.handleRequest(request1);

        Request1 request2 = new Request1(RequestType.TYPE2, "request2");
        handler2.handleRequest(request2);
    }
}


abstract class Handler {
    protected Handler successor;
    public Handler(Handler successor) {
        this.successor = successor;
    }
    protected abstract void handleRequest(Request1 request1);
}

class Request1 {
    private RequestType type;
    private String name;
    public Request1(RequestType type, String name) {
        this.type = type;
        this.name = name;
    }
    public RequestType getType() {
        return type;
    }
    public String getName() {
        return name;
    }
}

enum RequestType {
    TYPE1, TYPE2
}

class ConcreteHandler1 extends Handler {
    public ConcreteHandler1(Handler successor) {
        super(successor);
    }
    @Override
    protected void handleRequest(Request1 request1) {
        if (request1.getType() == RequestType.TYPE1) {
            System.out.println(request1.getName() + " is handle by ConcreteHandler1");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request1);
        }
    }
}

class ConcreteHandler2 extends Handler {
    public ConcreteHandler2(Handler successor) {
        super(successor);
    }
    @Override
    protected void handleRequest(Request1 request1) {
        if (request1.getType() == RequestType.TYPE2) {
            System.out.println(request1.getName() + " is handle by ConcreteHandler2");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request1);
        }
    }
}