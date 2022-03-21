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
        OptionalDouble average = getGrades().stream()
                .mapToInt(value -> value).average();
        return average.getAsDouble(); //теперь по идее поток будет в любом случае, можно и не проверять optional,
//        но всё равно подсвечивается
    }

    public void upCourse() {
        course++;
    }

    public void dismiss() {
        isStudies = false;
    }

    private List<Integer> getGrades() {
        if (grades == null) {
            grades = List.of(0);
        }
        return grades;
    }
}
