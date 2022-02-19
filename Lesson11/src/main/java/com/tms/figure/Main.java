package com.tms.figure;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<IFigure> figures = new ArrayList<>();
        IFigure figure;
        figures.add(figure = Rectangle.builder().firstSide(12.3).secondSide(5.4).build());
        figures.add(figure = Circle.builder().radius(13).build());
        figures.add(figure = Line.builder().length(2).build());
        figures.add(figure = Triangle.builder().base(8).height(12.3).build());
        for (IFigure iFigure : figures) {
            System.out.println(outSquare(iFigure));
        }

    }

    private static String outSquare(IFigure figure) {
        Type type = figure.getType();
        String square = null;
        switch (type) {
            case LINE -> square = "Ошибка! У линии невозможно вычислить площадь!";
            default -> square = "Площадь фигуры = " + figure.getSquare();
        }
        return square;
    }
}
