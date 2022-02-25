package by.tms.utils;

import java.util.HashMap;


public class Constants {
    public static final String HERBERA = "гербера";
    public static final String ROSE = "роза";
    public static final String LILY = "лилия";
    public static final String ASTER = "астра";
    public static final String TULIP = "тюльпан";
    public static final String CARNATION = "гвоздика";
    public static final HashMap<String, Integer> NAME_PRICE_FLOWERS = new HashMap<>();

    static {
        NAME_PRICE_FLOWERS.put(HERBERA, 5);
        NAME_PRICE_FLOWERS.put(ROSE, 7);
        NAME_PRICE_FLOWERS.put(LILY, 7);
        NAME_PRICE_FLOWERS.put(ASTER, 5);
        NAME_PRICE_FLOWERS.put(TULIP, 8);
        NAME_PRICE_FLOWERS.put(CARNATION, 11);
    }

    private Constants() {
    }
}
