package com.tms.task1.model;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

//    * 1) Создать класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
//     * Создать коллекцию, содержащую объекты класса Student. Перебрать всех студентов, вычислить средний балл
//     * каждого студента. Если средний балл >=3, студент переводится на следующий курс, иначе отчисляется.
@AllArgsConstructor
public class University {
    private List<Student> students;

    public String viewingStudentProgress() {
        return students.stream()
                .peek(student -> {
                    if (student.getAverageScore() >= 3) {
                        student.upCourse();
                    } else {
                        student.dismiss();
                    }
                })
                .map(student -> {
                    if (student.isStudies() && student.getCourse() > 5) {
                        return "Студент " + student.getName() + " выпустился из университета со средним баллом " +
                                student.getAverageScore() + "\n";
                    }
                    if (student.isStudies() && student.getCourse() <= 5) {
                        return "Студент " + student.getName() + " перевёлся на " + student.getCourse()
                                + " курс со средним баллом " + student.getAverageScore() + "\n";
                    }
                    return "Студент " + student.getName() + " отчислен!" + '\n';
                })
                .collect(Collectors.joining());
    }
}
