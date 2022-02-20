package com.tms.figure;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Figure implements IFigure {

    @Override
    public double getSquare() {
        return 0;
    }

    @Override
    public Type getType() {
        return null;
    }
}
