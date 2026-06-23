package DPPEx4;

public class PayPalAdapter implements PaymentProcessor {

    PayPalGateway paypal = new PayPalGateway();

    public void processPayment(int amount) {
        paypal.makePayment(amount);
    }
}
