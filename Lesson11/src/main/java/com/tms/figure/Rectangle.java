package com.tms.figure;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Rectangle implements IFigure {
    private final Type type = Type.RECTANGLE;
    private double firstSide;
    private double secondSide;

    @Override
    public double getSquare() {
        return firstSide * secondSide;
    }

    @Override
    public Type getType() {
        return type;
    }

}
