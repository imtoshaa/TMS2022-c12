package by.tms.utils;

import java.util.HashMap;


public class Constants {
    public static final String HERBERA = "гербера";
    public static final String ROSE = "роза";
    public static final String LILY = "лилия";
    public static final String ASTER = "астра";
    public static final String TULIP = "тюльпан";
    public static final String CARNATION = "гвоздика";
    public static final HashMap<String, Integer> constantsFlowerList = new HashMap<>();

    static {
        constantsFlowerList.put(HERBERA, 5);
        constantsFlowerList.put(ROSE, 7);
        constantsFlowerList.put(LILY, 7);
        constantsFlowerList.put(ASTER, 5);
        constantsFlowerList.put(TULIP, 8);
        constantsFlowerList.put(CARNATION, 11);
    }

    private Constants() {
    }
}
