package observer2;

public class SubscriberActivity {

    private CustomView customView;

    private Observer observer;

    public SubscriberActivity() {
        observer = new Observer() {
            @Override
            public void update(boolean checked) {

            }
        };
        customView = new CustomView();
        customView.register(observer);
    }

    public void onDestroy() {
        customView.unRegister(observer);
    }
}
