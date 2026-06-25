package DPPEx7;

import java.util.ArrayList;

public class StockMarket implements Stock {
    private ArrayList<Observer> observers = new ArrayList<>();
    private int price;
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(price);
        }
    }
    public void setPrice(int price) {
        this.price = price;
        notifyObservers();
    }
}