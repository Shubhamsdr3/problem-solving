package designapatterns.behavioural.command;

public class Lights {

    private boolean switchedOn;

    public void switchLights() {
        this.switchedOn = !switchedOn;
    }
}
