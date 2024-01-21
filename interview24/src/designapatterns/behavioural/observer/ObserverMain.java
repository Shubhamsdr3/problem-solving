package designapatterns.behavioural.observer;

public class ObserverMain {

    public static void main(String[] args) {
        Store store = new Store();
        store.getNotificationService().subscribe(Event.SALE, new PushNotificationService("shubham"));
    }
}
