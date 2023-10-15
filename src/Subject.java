public interface Subject {

    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObservers();

    void notify(Observer observer);

    void unsubscribeAll();
}
