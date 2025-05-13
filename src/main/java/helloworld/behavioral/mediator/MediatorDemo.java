package helloworld.behavioral.mediator;

/**
 * @author luzhicheng
 * @date 2025/5/12 16:13
 */
public class MediatorDemo {
    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        CoffeePot coffeePot = new CoffeePot();
        Calender calender = new Calender();
        Sprinkler sprinkler = new Sprinkler();
        Mediator mediator = new ConcreteMediator(alarm, coffeePot, calender, sprinkler);
        // 闹钟事件到达，调用中介者就可以操作相关对象
        alarm.onEvent(mediator);
    }
}

abstract class Colleague {
    public abstract void onEvent(Mediator mediator);
}
class Alarm extends Colleague {
    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("alarm");
    }
    public void doAlarm() {
        System.out.println("doAlarm()");
    }
}

class CoffeePot extends Colleague {
    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("coffeePot");
    }
    public void doCoffeePot() {
        System.out.println("doCoffeePot()");
    }
}

class Calender extends Colleague {
    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("calender");
    }
    public void doCalender() {
        System.out.println("doCalender()");
    }
}

class Sprinkler extends Colleague {
    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("sprinkler");
    }
    public void doSprinkler() {
        System.out.println("doSprinkler()");
    }
}

abstract class Mediator {
    public abstract void doEvent(String eventType);
}

class ConcreteMediator extends Mediator {
    private Alarm alarm;
    private CoffeePot coffeePot;
    private Calender calender;
    private Sprinkler sprinkler;
    public ConcreteMediator(Alarm alarm, CoffeePot coffeePot, Calender calender, Sprinkler
            sprinkler) {
        this.alarm = alarm;
        this.coffeePot = coffeePot;
        this.calender = calender;
        this.sprinkler = sprinkler;
    }
    @Override
    public void doEvent(String eventType) {
        switch (eventType) {
            case "alarm":
                doAlarmEvent();
                break;
            case "coffeePot":
                doCoffeePotEvent();
                break;
            case "calender":
                doCalenderEvent();
                break;
            default:
                doSprinklerEvent();
        }
    }
    public void doAlarmEvent() {
        alarm.doAlarm();
        coffeePot.doCoffeePot();
        calender.doCalender();
        sprinkler.doSprinkler();
    }
    public void doCoffeePotEvent() {
// ...
    }
    public void doCalenderEvent() {
// ...
    }
    public void doSprinklerEvent() {
// ...
    }
}
