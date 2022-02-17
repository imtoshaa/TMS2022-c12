package by.teachmeskills.robot.heads;

public class AppleHead implements IHead {
    private int price;

    public AppleHead(int price) {
        this.price = price;
    }

    @Override
    public void speak() {
        System.out.println("Говорит голова Apple");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
