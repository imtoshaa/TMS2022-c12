package com.tms.figure;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Rectangle extends Figure {
    private double firstSide;
    private double secondSide;

    @Override
    public double getSquare() {
        return firstSide * secondSide;
    }

    @Override
    public Type getType() {
        return Type.RECTANGLE;
    }

}
