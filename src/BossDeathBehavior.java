public class BossDeathBehavior implements WarriorBehaviors {

    @Override
    public void execute(Subject subject, Warrior warrior) {
        System.out.println("Warrior Observer: " + warrior.getName() + " has defeated the boss!");
        warrior.increaseExperience(100);
        warrior.increaseGold(100);
    }

    @Override
    public boolean supports(Class<? extends Subject> clazz) {
        return clazz.isAssignableFrom(Boss.class);
    }
}