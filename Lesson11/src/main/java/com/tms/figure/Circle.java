package com.tms.figure;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Circle implements IFigure {
    private final Type type = Type.CIRCLE;
    private double radius;

    @Override
    public double getSquare() {
        return 3.14 * Math.pow(radius, 2);
    }

    @Override
    public Type getType() {
        return type;
    }
}
