package helloworld.structural.facade;

/**
 * @author luzhicheng
 * @date 2025/5/12 14:44
 */
public class FacadeDemo {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.watchMovie();
    }
}

class SubSystem {
    public void turnOnTV() {
        System.out.println("turnOnTV()");
    }
    public void setCD(String cd) {
        System.out.println("setCD( " + cd + " )");
    }
    public void startWatching(){
        System.out.println("startWatching()");
    }
}

class Facade {
    private SubSystem subSystem = new SubSystem();
    public void watchMovie() {
        subSystem.turnOnTV();
        subSystem.setCD("a movie");
        subSystem.startWatching();
    }
}