package designapatterns.creational.prototype;

public class Car extends Vehicle {

    private int topSpeed;

    private GpsSystem gpsSystem;

    public Car(Car car) {
        super(car);
        this.topSpeed = car.topSpeed;
//        this.gpsSystem = car.gpsSystem; // shallow copy, change in this object from outside will reflect here.
        this.gpsSystem = new GpsSystem(car); // deep copy.
    }

    @Override
    public Vehicle clone() {
        return new Car(this);
    }
}
