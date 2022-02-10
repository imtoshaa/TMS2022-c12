package com.tms.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Truck extends Ground{
    private int tonnage;



    @Override
    public String info() {
        return super.info() + '\n'
                + "Грузоподъёмность, тонн = " + tonnage;
    }

    public void loadCargo(double cargo) {
        if (checkTonnage(cargo)) {
            System.out.println("Грузовик загружен!");
        } else {
            System.out.println("Вам нужна машина побольше");
        }
    }

    private boolean checkTonnage(double cargo) {
        if (cargo <= tonnage) {
            return true;
        }
        return false;
    }
}
