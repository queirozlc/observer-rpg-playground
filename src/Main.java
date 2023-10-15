import java.util.List;

public class Main {
    public static void main(String[] args) {
        var sword = new Product("Sword", 100, 10);
        var arrow = new Product("Arrow", 10, 1);
        var shield = new Product("Shield", 50, 5);
        var armor = new Product("Armor", 200, 20);

        var initialSeller = new Seller("Initial Seller", 1, List.of(sword));

        var finalSeller = new Seller("Final Seller", 10, List.of(armor, sword, arrow, shield));

        var boss = new Boss("Voldemort", 100, 10, 10, 10);

        var king = new Warrior("King", 100, 10, 10);

        var knight = new Warrior("Knight", 100, 10, 10);

        var archer = new Warrior("Archer", 200, 20, 20);

        var village = new Npc("Village");

        var kingObserver = new WarriorObserver(king);
        var knightObserver = new WarriorObserver(knight);
        var archerObserver = new WarriorObserver(archer);

        initialSeller.subscribe(kingObserver);
        initialSeller.subscribe(knightObserver);

        boss.subscribe(kingObserver);
        boss.subscribe(knightObserver);

        village.subscribe(kingObserver);
        village.subscribe(archerObserver);

        finalSeller.subscribe(knightObserver);
        finalSeller.discount(sword, 10);
        initialSeller.discount(sword, 10);

        System.out.println("Knight's gold before king kill the boss " + knight.getGold());
        king.kill(boss);
        System.out.println("Knight's gold after king kill the boss " + knight.getGold());

        System.out.println("King's gold before archer kill the npc " + archer.getGold());

        village.dieByWarrior(archer);

        System.out.println("King's gold after archer kill the npc " + archer.getGold());
    }


}