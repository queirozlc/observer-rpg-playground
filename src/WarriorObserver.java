import java.util.Map;


/**
 * <h2>
 * Delegate for the Warrior class to observe the Boss and Seller classes.
 * </h2>
 *
 * <p>
 * This class is used to observe the Boss and Seller classes. It works as a delegate for the Warrior class to implement two different behaviors for the same method.
 * </p>
 */
public class WarriorObserver implements Observer {

    private final Map<Class<? extends Subject>, WarriorBehaviors> behaviors;
    private final Warrior warrior;


    public WarriorObserver(Warrior warrior) {
        this.warrior = warrior;
        this.behaviors = Map.of(Seller.class, new SellerDiscountBehavior(), Boss.class, new BossDeathBehavior(), Npc.class, new NpcDeathBehavior());
    }

    @Override
    public void update(Subject subject) {
        behaviors.entrySet().stream()
                .filter(entry -> entry.getValue().supports(subject.getClass()))
                .findFirst()
                .ifPresent(entry -> entry.getValue().execute(subject, warrior));
    }
}