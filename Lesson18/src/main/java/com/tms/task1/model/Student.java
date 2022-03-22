package com.tms.task1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@AllArgsConstructor
@Builder
public class Student {
    private final String name;
    private final int group;
    private List<Integer> grades;
    @Setter
    private int course;
    private boolean isStudies;

    public double getAverageScore() {
        return getGrades().stream()
                .mapToInt(value -> value)
                // а тут без разницы. операция проходит одна и та же, но поток дабл занимает в два раза больше памяти, чем инт
                //в листе то хранятся инты, а дабл мы получаем уже после average. так что без разницы
                .average()
                .orElse(0.0);
    }

    public void upCourse() {
        course++;
    }

    public void dismiss() {
        isStudies = false;
    }

    private List<Integer> getGrades() {
        if (grades == null) {
            grades = new ArrayList<>(); //просто я почитал, что паттерн "ленивая инициализация" реализовывется именно вот так,
//        как было написано
        }
        return grades;
    }
}
