package designapatterns.behavioural.observer;

public class Store {

    private final NotificationService notificationService;

    public Store() {
        this.notificationService = new NotificationService();
    }

    public void newItemPromotion() {
        notificationService.notifySubscriber(Event.SALE);
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }
}
