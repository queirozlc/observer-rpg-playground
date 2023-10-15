import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <h2>
 * Npc class
 * </h2>
 *
 * <p>
 * A NPC is a non-playable character in the game. They listen to the market and buy products when they are cheap.
 * </p>
 *
 * <p>
 * Npc's are observers of the market, but when the player kills the boss, npc's inherit the boss's gold as well. So they are also observers of the boss.
 * </p>
 *
 * <p>
 * For this, the architecture of the system was changed. The boss and the market are now subjects, and the player and the npc are observers.
 * </p>
 *
 * <p>
 * But, the npc won't directly implement a observer, cause it doesn't need to be notified when the boss is killed. It only needs to be notified when the market changes.
 * </p>
 *
 * <p>
 * For achieve the expected behavior, i'll delegate the responsibility of notify the npc to another class, the NpcObserver.
 * </p>
 */
public class Npc implements Subject {

    private final Set<Observer> observers;
    private String name;
    private int gold;

    public Npc(String name) {
        this.name = name;
        this.gold = 0;
        this.observers = new LinkedHashSet<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.removeIf(o -> o.equals(observer));
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(observer -> observer.update(this));
    }

    @Override
    public void notify(Observer observer) {
        this.observers.stream().filter(o -> o.equals(observer)).forEach(o -> o.update(this));
    }

    @Override
    public void unsubscribeAll() {
        this.observers.clear();
    }

    public void dieByWarrior(Warrior warrior) {
        System.out.println("Npc: " + name + " has been killed by " + warrior.getName() + "!" + " Now he's a disgraced warrior.");
        this.notifyObservers();
    }

}
