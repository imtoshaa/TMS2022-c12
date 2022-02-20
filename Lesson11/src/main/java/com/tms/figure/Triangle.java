package com.tms.figure;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Triangle extends Figure {
    private double height;
    private double base;

    @Override
    public double getSquare() {
        return height * base / 2;
    }

    @Override
    public Type getType() {
        return Type.TRIANGLE;
    }
}
