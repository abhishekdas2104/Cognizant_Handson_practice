package DPPEx8;

public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext payment;
        payment = new PaymentContext(new CreditCardPayment());
        payment.makePayment(1000);
        payment = new PaymentContext(new PayPalPayment());
        payment.makePayment(2000);
    }
}