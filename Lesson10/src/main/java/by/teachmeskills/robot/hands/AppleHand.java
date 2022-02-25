package by.teachmeskills.robot.hands;

public class AppleHand implements IHand {
    private int price;

    public AppleHand(int price) {
        this.price = price;
    }

    public AppleHand() {
    }

    @Override
    public void upHand() {
        System.out.println("Рука Apple поднята");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
