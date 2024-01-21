package designapatterns.behavioural.command;

public class FloorLamp {

    private Lights lights;

    public FloorLamp(Lights lights) {
        this.lights = lights;
    }

    public void switchLights() {
        lights.switchLights();
    }
}
