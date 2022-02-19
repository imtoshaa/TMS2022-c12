package com.tms.figure;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Line implements IFigure {
    private final Type type = Type.LINE;
    private double length;

    @Override
    public double getSquare() {
        return 0;
    }

    @Override
    public Type getType() {
        return type;
    }
}
