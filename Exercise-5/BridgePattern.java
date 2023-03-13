package exercise5;

interface Engine {
    void setEngine();
}
abstract class Car {
    protected Engine engine;
    public Car(Engine engine){
        this.engine = engine;
    }
    abstract public void setEngine();
}
class SportsCar extends Car {
    public SportsCar(Engine engine) {
        super(engine);
    }
    public void setEngine() {
        System.out.print("SportsCar engine: ");
        engine.setEngine();
    }
}
class UnknownCar extends Car {
    public UnknownCar(Engine engine) {
        super(engine);
    }
    public void setEngine() {
        System.out.print("UnknownCar engine: ");
        engine.setEngine();
    }
}
class PerformanceEngine implements Engine {
    public void setEngine(){
        System.out.println("sport");
    }
}
class UnknownEngine implements Engine {
    public void setEngine(){
        System.out.println("unknown");
    }
}
public class BridgePattern {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new PerformanceEngine());
        sportsCar.setEngine();
        System.out.println();
        Car unknownCar = new UnknownCar(new UnknownEngine());
        unknownCar.setEngine();
    }
}
