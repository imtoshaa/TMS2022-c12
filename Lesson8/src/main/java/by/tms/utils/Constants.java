package by.tms.utils;

import by.tms.model.Flower;

import java.util.ArrayList;


public class Constants {
    public static final String HERBERA = "гербера";
    public static final String ROSE = "роза";
    public static final String LILY = "лилия";
    public static final String ASTER = "астра";
    public static final String TULIP = "тюльпан";
    public static final String CARNATION = "гвоздика";
    public static final ArrayList<Flower> constantsFlowerList = new ArrayList<>();

    static {
        constantsFlowerList.add(new Flower(HERBERA, 5));
        constantsFlowerList.add(new Flower(ROSE, 7));
        constantsFlowerList.add(new Flower(LILY, 7));
        constantsFlowerList.add(new Flower(ASTER, 5));
        constantsFlowerList.add(new Flower(TULIP, 8));
        constantsFlowerList.add(new Flower(CARNATION, 11));
    }

    private Constants() {
    }
}
