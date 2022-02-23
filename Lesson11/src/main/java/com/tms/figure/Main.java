package com.tms.figure;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Figure> figures = new ArrayList<>();
        figures.add(Rectangle.builder().firstSide(12.3).secondSide(5.4).build());
        figures.add(Circle.builder().radius(13).build());
        figures.add(Line.builder().length(2).build());
        figures.add(Triangle.builder().base(8).height(12.3).build());
        for (Figure Figure : figures) {
            System.out.println(outSquare(Figure));
        }

    }

    private static String outSquare(Figure figure) {
        Type type = figure.getType();
        return switch (type) {
            case LINE -> "Ошибка! У линии невозможно вычислить площадь!";
            default -> "Площадь фигуры = " + figure.getSquare();
        };
    }
}
