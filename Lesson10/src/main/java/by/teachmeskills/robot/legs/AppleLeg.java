package by.teachmeskills.robot.legs;

public class AppleLeg implements ILeg {
    private int price;

    public AppleLeg(int price) {
        this.price = price;
    }

    public AppleLeg() {
    }

    @Override
    public void step() {
        System.out.println("Нога Apple пошла");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
