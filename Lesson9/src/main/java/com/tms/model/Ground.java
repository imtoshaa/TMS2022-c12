package com.tms.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Ground extends Transport {
    private int countWheels;
    private int fuelConsumption;

    @Override
    public String info() {
        return super.info() + '\n' +
                "Количество колёс = " + countWheels + '\n' +
                "Расход топлива на 100 км, литров = " + fuelConsumption;
    }
}
