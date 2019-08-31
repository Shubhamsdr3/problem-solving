
class Vehicle  {
    void move() {
        System.out.println("Vehicle is Moving...");
    }
}

class Car extends Vehicle {
    Car() {
        System.out.println("Car is moving");
    }
    void playMusic() {
        System.out.println("Playing music...");
    }
}

class Scooter extends Vehicle  {
    Scooter() {
        System.out.println("Scooter is moving...");
    }

    public void start() {
        System.out.println("Scooter is starting...");
    }
}

class Run {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.move();

        Vehicle vehicle1 = new Scooter();
        vehicle1.move();

        Car car = new Car();
        car.playMusic();
        car.move();
    }
}