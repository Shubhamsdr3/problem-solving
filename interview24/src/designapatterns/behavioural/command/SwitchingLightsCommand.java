package designapatterns.behavioural.command;

public class SwitchingLightsCommand implements Command {

    private Lights lights;

    public SwitchingLightsCommand(Lights lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        lights.switchLights();
    }
}
