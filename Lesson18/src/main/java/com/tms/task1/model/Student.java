package com.tms.task1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Getter
@AllArgsConstructor
@Builder
public class Student {
    private final String name;
    private final int group;
    private final List<Integer> grades;
    @Setter
    private int course;
    private boolean isStudies;

    public double getAverageScore() throws Exception {
        OptionalDouble average = grades.stream()
                .mapToInt(value -> value).average();
        if (average.isPresent()) {
            return average.getAsDouble();
        } else {
            throw new Exception("Ошибка!");
        }
    }

    public void upCourse() {
        course++;
    }

    public void dismiss() {
        isStudies = false;
    }
}
