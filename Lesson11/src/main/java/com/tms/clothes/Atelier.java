package com.tms.clothes;

import com.tms.clothes.utils.PersonType;

import java.util.List;

import static com.tms.clothes.utils.PersonType.MAN;
import static com.tms.clothes.utils.PersonType.WOMEN;

public class Atelier {

    private List<Clothes> clothes;

    public Atelier(List<Clothes> clothes) {
        this.clothes = clothes;
    }

    public void dressPerson() {
        for (Clothes clothes : clothes) {
            if (checkClothes(clothes, MAN)) {
                IManClothes manClothes = (IManClothes) clothes;
                manClothes.dressMan();
                /*
                я бы наверное сделал универсальный метод. одеть человека который пришел в ателье по типу.
                т.е передать в метод тип и в зависимости от этого типа уже если ман то вызываем метод dressMan иначе другой.
                (Это ваш комментарий)
                Вот тут немного не понял, можете в начале занятия минуту уделить и пояснить?
                 */
            }
            if (checkClothes(clothes, WOMEN)) {
                IWomanClothes womanClothes = (IWomanClothes) clothes;
                womanClothes.dressWoman();
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
