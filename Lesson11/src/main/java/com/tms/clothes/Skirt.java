package com.tms.clothes;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Skirt extends Clothes implements IWomanClothes {
    @Override
    public void dressWoman() {
        System.out.println("Юбка женская: цвет = " + getColor() + ", европейский размер = " + getSize() + ", цена = " + getCost());
    }
}
