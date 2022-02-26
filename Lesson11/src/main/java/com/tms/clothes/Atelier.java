package com.tms.clothes;

import com.tms.clothes.utils.PersonType;

import java.util.List;

public class Atelier {

    private List<Clothes> clothes;

    public Atelier(List<Clothes> clothes) {
        this.clothes = clothes;
    }

    public void dressPerson(PersonType type) {
        for (Clothes clothes : clothes) {
            switch (type) {
                case MAN -> {
                    if (checkClothes(clothes, type)) {
                        IManClothes manClothes = (IManClothes) clothes;
                        manClothes.dressMan();
                    }
                }
                case WOMEN -> {
                    if (checkClothes(clothes, type)) {
                        IWomanClothes womanClothes = (IWomanClothes) clothes;
                        womanClothes.dressWoman();
                    }
                }
            }
        }
    }

    private boolean checkClothes(Clothes clothes, PersonType personType) {
        for (Class myClass : clothes.getClass().getInterfaces()) {
            if (myClass == personType.getPersonClass()) {
                return true;
            }
        }
        return false;
    }


}
