package com.tms.figure;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Line extends Figure {
    private double length;


    @Override
    public double getSquare() {
        return 0;
    }

    @Override
    public Type getType() {
        return Type.LINE;
    }
}
