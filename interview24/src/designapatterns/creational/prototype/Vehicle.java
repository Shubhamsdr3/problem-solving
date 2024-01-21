package designapatterns.creational.prototype;

public abstract class Vehicle {

    private String brand;

    private String model;

    private String color;

    public Vehicle(Vehicle vehicle) {
        this.brand = vehicle.brand;
        this.model = vehicle.model;
        this.color = vehicle.color;
    }

    public abstract Vehicle clone();
}
