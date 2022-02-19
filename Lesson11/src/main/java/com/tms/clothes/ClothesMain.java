package com.tms.clothes;

import com.tms.clothes.utils.Sizes;

import java.util.ArrayList;

public class ClothesMain {
    public static void main(String[] args) {
        ArrayList<Clothes> clothesArrayList = new ArrayList<>();
        clothesArrayList.add(createClothes(Atelier.Type.PANTS, "красный", Sizes.XXS, 50));
        clothesArrayList.add(createClothes(Atelier.Type.CRAVAT, "синий", Sizes.XS, 6));
        clothesArrayList.add(createClothes(Atelier.Type.SKIRT, "жёлтый", Sizes.S, 50));
        clothesArrayList.add(createClothes(Atelier.Type.TSHIRT, "чёрный", Sizes.M, 7));
        Atelier atelier = new Atelier(clothesArrayList);
        atelier.dressMan();
        atelier.dressWoman();
    }

    private static Clothes createClothes(Atelier.Type type, String color, Sizes size, int cost) {
        Clothes clothes = null;
        switch (type) {
            case PANTS -> clothes = Pants.builder().color(color).cost(cost).size(size.getEuroSize()).build();
            case SKIRT -> clothes = Skirt.builder().color(color).cost(cost).size(size.getEuroSize()).build();
            case CRAVAT -> clothes = Cravat.builder().color(color).cost(cost).size(size.getEuroSize()).build();
            case TSHIRT -> clothes = TShirt.builder().color(color).cost(cost).size(size.getEuroSize()).build();
        }
        return clothes;
    }

    private static boolean checkMansClothes(Clothes clothes) {
        return IManClothes.class.isAssignableFrom(clothes.getClass());
    }
}
