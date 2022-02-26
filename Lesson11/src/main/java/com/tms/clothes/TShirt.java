package com.tms.clothes;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class TShirt extends Clothes implements IManClothes, IWomanClothes {
    @Override
    public void dressMan() {
        System.out.println("Футболка мужская: цвет = " + getColor() + ", европейский размер = " + getSize() + ", цена = " + getCost());
    }

    @Override
    public void dressWoman() {
        System.out.println("Футболка женская: цвет = " + getColor() + ", европейский размер = " + getSize() + ", цена = " + getCost());
    }
}
