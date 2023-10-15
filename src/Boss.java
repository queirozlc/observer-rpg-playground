import java.util.LinkedHashSet;
import java.util.Set;

public class Boss implements Subject {

    private final Set<Observer> observers;
    private String name;
    private int level;
    private int health;
    private int attack;
    private int defense;

    public Boss(String name, int level, int health, int attack, int defense) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.observers = new LinkedHashSet<>();
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

    public void attack(Warrior warrior) {
        System.out.println("Boss: " + name + " is attacking " + warrior.getName() + "!");
        warrior.defend(this);
        if (warrior.died()) {
            this.notifyObservers();
            this.kill(warrior);
        }
    }

    private void kill(Warrior warrior) {
        warrior.die(this);
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public void die(Warrior... warriors) {
    }

    public void die(Warrior warrior) {
        System.out.println("Boss: " + this.name + " is dead!");
        notifyObservers();
    }

    public void levelUp(int xp) {
        this.level += xp;
    }

    public boolean compareLevel(int level) {
        return this.level > level;
    }
}
