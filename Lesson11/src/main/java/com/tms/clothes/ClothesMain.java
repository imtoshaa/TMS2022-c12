package com.tms.clothes;


import java.util.ArrayList;
import java.util.List;

import static com.tms.clothes.utils.Sizes.*;
import static com.tms.clothes.utils.Type.*;

public class ClothesMain {
    public static void main(String[] args) {
        Dressmaker dressmaker = new Dressmaker();
        List<Clothes> clothesArrayList = new ArrayList<>();
        clothesArrayList.add(dressmaker.createClothes(PANTS, "красный", XXS, 50));
        clothesArrayList.add(dressmaker.createClothes(CRAVAT, "синий", XS, 6));
        clothesArrayList.add(dressmaker.createClothes(SKIRT, "жёлтый", S, 50));
        clothesArrayList.add(dressmaker.createClothes(TSHIRT, "чёрный", M, 7));
        Atelier atelier = new Atelier(clothesArrayList);
        atelier.dressPerson();
    }

//    private static boolean checkMansClothes(Clothes clothes) {
//        return IManClothes.class.isAssignableFrom(clothes.getClass());
//    }
}
