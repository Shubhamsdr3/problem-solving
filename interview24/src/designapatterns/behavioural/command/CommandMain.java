package designapatterns.behavioural.command;

public class CommandMain {

    public static void main(String[] args) {
        Room livingRoom = new LivingRoom();
        livingRoom.setCommand(new SwitchingLightsCommand(new Lights()));
        livingRoom.executeCommand();
    }
}
