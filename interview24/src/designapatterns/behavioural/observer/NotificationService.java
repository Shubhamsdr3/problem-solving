package designapatterns.behavioural.observer;

import java.util.*;

public class NotificationService {

    private final Map<String, List<EventListener>> subscribers;

    public NotificationService() {
        this.subscribers = new HashMap<>();
        Arrays.stream(Event.values()).forEach(event -> subscribers.put(event.name(), new ArrayList<>()));
    }

    public void subscribe(Event event, EventListener listener) {
        subscribers.get(event.name()).add(listener);
    }

    public void unsubscribe(Event event, EventListener listener) {
        subscribers.get(event).remove(listener);
    }

    public void notifySubscriber(Event event) {
        for (EventListener eventListener : subscribers.get(event)) {
            eventListener.update();
        }
    }
}
