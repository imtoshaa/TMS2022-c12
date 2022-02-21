package com.tms.clothes.utils;

import com.tms.clothes.IManClothes;
import com.tms.clothes.IWomanClothes;

public enum PersonType {
    MAN(IManClothes.class),
    WOMEN(IWomanClothes.class);

    private Class personClass;

    PersonType(Class personClass) {
        this.personClass = personClass;
    }

    public Class getPersonClass() {
        return personClass;
    }

}
