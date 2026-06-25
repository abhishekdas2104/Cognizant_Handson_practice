package DPPEx7;

public class WebApp implements Observer {
    public void update(int price) {
        System.out.println("Web App: Stock Price = " + price);
    }
}