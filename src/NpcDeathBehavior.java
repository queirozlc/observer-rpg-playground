public class NpcDeathBehavior implements WarriorBehaviors {

    @Override
    public void execute(Subject subject, Warrior warrior) {
        System.out.println("Warrior Observer: " + warrior.getName() + " has defeated the npc! Now he's a disgraced warrior.");
        warrior.levelDown();
    }

    @Override
    public boolean supports(Class<? extends Subject> clazz) {
        return clazz.isAssignableFrom(Npc.class);
    }
}
