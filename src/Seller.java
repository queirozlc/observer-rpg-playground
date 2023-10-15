import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h2>
 * Seller class
 * </h2>
 *
 * <p>
 * This class is used to represent a seller in the system. A seller is some merchant who sells products in the game.
 * </p>
 * <p>
 * Sellers notify all observers when they have a new product to sell.
 * </p>
 */

public class Seller implements Subject {

    private final Set<Observer> observers;
    private String name;
    private int level;

    private List<Product> products;

    /**
     * <p>
     * Constructor method for Seller class.
     * </p>
     *
     * @param name     The name of this seller.
     * @param level    The level of this seller.
     * @param products The products of this seller.
     */
    public Seller(String name, int level, List<Product> products) {
        this.observers = new HashSet<>();
        this.name = name;
        this.level = level;
        this.products = products;
    }


    /**
     * <p>
     * Notify all observers of this seller.
     * </p>
     */
    @Override
    public void notifyObservers() {
        this.observers.forEach(observer -> observer.update(this));
    }

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.removeIf(o -> o.equals(observer));
    }

    @Override
    public void notify(Observer observer) {
        this.observers.stream().filter(o -> o.equals(observer)).forEach(o -> o.update(this));
    }

    /**
     * <p>
     * Unsubscribe all observers of this seller.
     * </p>
     */
    @Override
    public void unsubscribeAll() {
        this.observers.clear();
    }

    public void discount(Product product, int amount) {
        product.discount(amount);
        notifyObservers();
    }

    public String getName() {
        return name;
    }
}
