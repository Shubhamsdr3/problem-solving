package designapatterns.behavioural.chainofresponsibility;

public class AuthService {

    private Handler handler;

    public AuthService(Handler handler) {
        this.handler = handler;
    }

    public boolean logIn(String email, String password) {
        if (handler.handle(email, password)) {
            //
            return true;
        }
        return false;
    }
}
