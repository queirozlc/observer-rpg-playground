public interface WarriorBehaviors {

    boolean supports(Class<? extends Subject> clazz);

    void execute(Subject subject, Warrior warrior);
}
