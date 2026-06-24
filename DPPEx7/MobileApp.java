package DPPEx7;

public class MobileApp implements Observer {
    public void update(int price) {
        System.out.println("Mobile App: Stock Price = " + price);
    }
}
