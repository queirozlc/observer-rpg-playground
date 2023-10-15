import java.util.HashSet;
import java.util.Set;

public class Warrior {

    private String name;

    private int level;

    private int health;

    private int attack;

    private int defense;

    private int experience;

    private int gold;

    private int speed;

    private Set<Observer> observers;

    public Warrior(String name, int attack, int defense, int speed) {
        this.name = name;
        this.level = 0;
        this.health = 100;
        this.experience = 0;
        this.attack = attack;
        this.defense = defense;
        this.gold = 0;
        this.speed = speed;
        this.observers = new HashSet<>();
    }

    public void levelUp() {
        this.level++;
        this.health += 10;
        this.attack += 5;
        this.defense += 5;
        this.speed += 5;
    }

    public void increaseExperience(int experience) {
        this.experience += experience;
        if (this.experience >= 100) {
            this.levelUp();
            this.experience -= 100;
        }
    }

    public void increaseGold(int gold) {
        this.gold += gold;
    }

    public void decreaseGold(int gold) {
        this.gold -= gold;
    }

    public void defend(Boss boss) {
        System.out.println("Warrior: " + this.name + " is defending against " + boss.getName() + "!");
        int damage = boss.getAttack() - this.defense;
        if (damage > 0) {
            this.health -= damage;
            System.out.println("Warrior: " + this.name + " took " + damage + " damage!");
        } else {
            System.out.println("Warrior: " + this.name + " took no damage!");
        }
        if (this.health <= 0) {
            System.out.println("Warrior: " + this.name + " is dead!");
        }
    }

    public String getName() {
        return name;
    }

    public boolean died() {
        return this.health <= 0;
    }

    public void die(Boss boss) {
        System.out.println("Warrior: " + this.name + " is dead!");
        boss.levelUp(100);
    }

    public void kill(Boss boss) {
        System.out.println("Warrior: " + this.name + " has killed " + boss.getName() + "!");
        if (boss.compareLevel(this.level)) {
            System.out.println("Warrior: " + this.name + " has leveled up!");
            this.levelUp();
        }
        this.increaseExperience(100);
        this.increaseGold(100);
        boss.die(this);
    }

    public String getGold() {
        return String.valueOf(gold);
    }

    public void levelDown() {
        this.level--;
        this.health -= 10;
        this.attack -= 5;
        this.defense -= 5;
        this.speed -= 5;
    }

}
