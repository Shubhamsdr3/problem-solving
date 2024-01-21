package designapatterns.behavioural.strategy;

public class PaymentByCreditCard implements PaymentStrategy {

    private CreditCard card;

    @Override
    public void collectPaymentDetails() {

    }

    @Override
    public boolean validatePaymentDetails() {
        return true;
    }

    @Override
    public void pay(int amount) {
        card = new CreditCard("cardnumber", "expiryDate", "cvv");
        // validate the credit card
        card.setAmount(card.getAmount() - amount); // deduct the amount from credit card and pay.
    }
}
