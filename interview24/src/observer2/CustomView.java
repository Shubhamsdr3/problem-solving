package observer2;

import java.util.ArrayList;
import java.util.List;

public class CustomView implements Subject {

    private List<Observer>  observers;

    private OnClickListener clickListener;

    private boolean isChecked = false;

    public CustomView() {
        observers = new ArrayList<>();
        clickListener = new OnClickListener() {
            @Override
            public void onClick() {
                isChecked = true;
                notifyObservers();
            }
        };
    }

    @Override
    public void register(Observer observer) {
        if(!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unRegister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(isChecked);
        }
    }

    interface OnClickListener {
        public void onClick();
    }
}
