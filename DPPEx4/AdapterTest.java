package DPPEx4;

public class AdapterTest {

    public static void main(String[] args) {

        PaymentProcessor p1 = new PayPalAdapter();
        p1.processPayment(1000);

        PaymentProcessor p2 = new StripeAdapter();
        p2.processPayment(2000);
    }
}