package designapatterns.behavioural.strategy;

public class PaymentPayPal implements PaymentStrategy {

    private String email;

    private String password;

    @Override
    public void collectPaymentDetails() {

    }

    @Override
    public boolean validatePaymentDetails() {
        return true;
    }

    @Override
    public void pay(int amount) {
        email = "xyz@gmail.com";
        password = "xyz@password";
        // authenticate
        // deduct the amount from account.
    }
}
