package by.teachmeskills.robot;

import by.teachmeskills.robot.hands.AppleHand;
import by.teachmeskills.robot.hands.SonyHand;
import by.teachmeskills.robot.heads.AppleHead;
import by.teachmeskills.robot.heads.SamsungHead;
import by.teachmeskills.robot.heads.SonyHead;
import by.teachmeskills.robot.legs.AppleLeg;
import by.teachmeskills.robot.legs.SamsungLeg;
import by.teachmeskills.robot.legs.SonyLegs;

import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {
        ArrayList<Robot> robots = new ArrayList<>();
        robots.add(new Robot(new AppleHead(2), new SonyHand(3), new SonyLegs(1)));
        robots.add(new Robot(new SamsungHead(5), new AppleHand(6), new SamsungLeg(1)));
        robots.add(new Robot(new SonyHead(3), new SonyHand(6), new AppleLeg(2)));
        int max = 0;
        int indexMax = 0;
        for (int i = 0; i < robots.size(); i++) {
            max = robots.get(i).getPrice();
            indexMax = i;
            robots.get(i).action();
        }
        System.out.println();
        System.out.println("Самый дорогой робот стоит " + max);
        System.out.println();
        robots.get(indexMax).action();


//        Robot robot1 = new Robot(new AppleHead(2),new SonyHand(3), new SonyLegs(1));
//        robot1.action();
//        System.out.println("Цена робота = " + robot1.getPrice());
//
//        Robot robot2 = new Robot(new SamsungHead(5), new AppleHand(6), new SamsungLeg(3));
//        robot2.action();
//        System.out.println("Цена робота = " + robot2.getPrice());
//
//        Robot robot3 = new Robot(new AppleHead(5), new SonyHand(6), new AppleLeg(2));
//        robot3.action();
//        System.out.println("Цена робота = " + robot3.getPrice());
    }
}
