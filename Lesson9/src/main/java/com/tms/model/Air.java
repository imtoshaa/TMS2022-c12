package com.tms.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Air extends Transport {
    private int wingspan;
    private int runwayLength;


    @Override
    public String info() {
        return super.info() + '\n'
                + "Размах крыла, метров = " + wingspan + '\n'
                + "Взлётная полоса, метров = " + runwayLength;
    }
}
