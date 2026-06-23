package DPPEx4;

public class StripeAdapter implements PaymentProcessor {

    StripeGateway stripe = new StripeGateway();

    public void processPayment(int amount) {
        stripe.pay(amount);
    }
}
