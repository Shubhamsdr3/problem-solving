package designapatterns.behavioural.observer;

public class EmailMsgListener implements EventListener {

    private final String email;

    public EmailMsgListener(String email) {
        this.email = email;
    }

    @Override
    public void update() {
        // send email.
    }
}
