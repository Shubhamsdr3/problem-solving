package designapatterns.creational.prototype;

public class GpsSystem extends Vehicle {

    public GpsSystem(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public Vehicle clone() {
        return new GpsSystem(this);
    }
}
