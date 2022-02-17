package by.teachmeskills.shuttle;

import by.teachmeskills.shuttle.start.IStart;
import by.teachmeskills.shuttle.start.Nasa;
import by.teachmeskills.shuttle.start.RosCosmos;
import by.teachmeskills.shuttle.start.SpaceX;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SpasePort spasePort = new SpasePort();
        RosCosmos rosCosmos = new RosCosmos();
        IStart nasa = new Nasa();
        SpaceX spaceX = new SpaceX();
        spasePort.Start(rosCosmos);
        spasePort.Start(nasa);
        spasePort.Start(spaceX);
    }
}
