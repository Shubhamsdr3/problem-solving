package designapatterns.creational.prototype;

public class Bus extends Vehicle {

    private int wheels;

    public Bus(Bus bus) {
        super(bus);
        this.wheels = bus.wheels;
    }

    @Override
    public Vehicle clone() {
        return new Bus(this);
    }
}
