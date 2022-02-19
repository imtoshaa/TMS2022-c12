package com.tms.clothes;

import java.util.ArrayList;

public class Atelier {

    public enum Type {
        CRAVAT, PANTS, SKIRT, TSHIRT;
    }

    private ArrayList<Clothes> clothes = new ArrayList<>();

    public Atelier(ArrayList<Clothes> clothes) {
        this.clothes = clothes;
    }

    public void dressMan() {
        for (Clothes clothes : clothes) {
            if (checkMansClothes(clothes)) {
                IManClothes manClothes = (IManClothes) clothes;
                manClothes.dressMan();
            }
        }
    }

    public void dressWoman() {
        for (Clothes clothes : clothes) {
            if (checkWomansClothes(clothes)) {
                IWomanClothes womanClothes = (IWomanClothes) clothes;
                womanClothes.dressWoman();
            }
        }
    }

    private boolean checkMansClothes(Clothes clothes) {
        return IManClothes.class.isAssignableFrom(clothes.getClass());
    }

    private boolean checkWomansClothes(Clothes clothes) {
        return IWomanClothes.class.isAssignableFrom(clothes.getClass());
    }


}
