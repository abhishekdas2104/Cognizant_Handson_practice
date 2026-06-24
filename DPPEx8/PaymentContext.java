package DPPEx8;

public class PaymentContext {
    private PaymentStrategy strategy;
    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void makePayment(int amount) {
        strategy.pay(amount);
    }
}