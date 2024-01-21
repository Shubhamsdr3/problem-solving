package designapatterns.behavioural.observer;

public class PushNotificationService implements EventListener {

    private final String userName;

    public PushNotificationService(String userName) {
        this.userName = userName;
    }

    @Override
    public void update() {
        // send notification.
    }
}
