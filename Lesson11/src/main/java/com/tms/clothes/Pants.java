package com.tms.clothes;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Pants extends Clothes implements IManClothes, IWomanClothes {
    @Override
    public void dressMan() {
        System.out.println("Штаны мужские: цвет = " + getColor() + ", европейский размер = " + getSize() + ", цена = " + getCost());
    }

    @Override
    public void dressWoman() {
        System.out.println("Штаны женские: цвет = " + getColor() + ", европейский размер = " + getSize() + ", цена = " + getCost());
    }
}