package observer2;


public interface Subject {

    public void register(Observer observer);

    public void unRegister(Observer observer);

    public void notifyObservers();
}
