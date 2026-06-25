package DPPEx7;

public interface Stock {
    void registerObserver(Observer o);
    void notifyObservers();
}