public class SellerDiscountBehavior implements WarriorBehaviors {

    @Override
    public void execute(Subject subject, Warrior warrior) {
        System.out.println("Warrior Observer: " + warrior.getName() + " has received a discount from the seller " + ((Seller) subject).getName() + "!");
    }

    @Override
    public boolean supports(Class<? extends Subject> clazz) {
        return clazz.isAssignableFrom(Seller.class);
    }
}
