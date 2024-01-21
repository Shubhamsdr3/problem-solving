package designapatterns.behavioural.chainofresponsibility;

public abstract class Handler {

    private Handler next;

    public Handler setNextHandler(Handler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(String userName, String password);

    protected boolean handleNext(String userName, String password) {
        if (next == null) return true;
        return next.handle(userName, password);
    }
}
