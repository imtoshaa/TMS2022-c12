package com.tms.figure;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Triangle implements IFigure {
    private static final Type type = Type.TRIANGLE;
    private double height;
    private double base;

    @Override
    public double getSquare() {
        return height * base / 2;
    }

    @Override
    public Type getType() {
        return type;
    }
}
