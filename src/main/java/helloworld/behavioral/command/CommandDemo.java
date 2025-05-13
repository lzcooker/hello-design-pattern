package helloworld.behavioral.command;

/**
 * @author luzhicheng
 * @date 2025/5/12 15:42
 */
public class CommandDemo {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Light light = new Light();
        Command1 lightOnCommand = new LightOnCommand(light);
        Command1 lightOffCommand = new LightOffCommand(light);
        invoker.setOnCommand(lightOnCommand, 0);
        invoker.setOffCommand(lightOffCommand, 0);
        invoker.onButtonWasPushed(0);
        invoker.offButtonWasPushed(0);
    }

}


interface Command1 {
    void execute();
}

class LightOnCommand implements Command1 {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command1 {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

class Light {
    public void on() {
        System.out.println("Light is on!");
    }

    public void off() {
        System.out.println("Light is off!");
    }
}

class Invoker {
    private Command1[] onCommands;
    private Command1[] offCommands;
    private final int slotNum = 7;

    public Invoker() {
        this.onCommands = new Command1[slotNum];
        this.offCommands = new Command1[slotNum];
    }

    public void setOnCommand(Command1 command, int slot) {
        onCommands[slot] = command;
    }

    public void setOffCommand(Command1 command, int slot) {
        offCommands[slot] = command;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }
}