package DPPEx7;

public class ObserverTest {
    public static void main(String[] args) {
        StockMarket stock = new StockMarket();
        Observer mobile = new MobileApp();
        Observer web = new WebApp();
        stock.registerObserver(mobile);
        stock.registerObserver(web);
        stock.setPrice(100);
        stock.setPrice(150);
    }
}