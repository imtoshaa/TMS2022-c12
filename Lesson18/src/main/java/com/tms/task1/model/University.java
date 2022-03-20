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

    public String viewingStudentProgress() throws Exception {
        return students.stream()
                .map(student -> {
                    try {
                        if (student.getAverageScore() >= 3) {
                            student.upCourse();
                        } else {
                            student.dismiss();
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    return student;
                })
                .filter(Student::isStudies)
                .map(student -> {
                    try {
                        return "Студент " + student.getName() + " перевёлся на " + student.getCourse()
                                + " курс со средним баллом " + student.getAverageScore() + "\n";
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    return "Что-то пошло не так. Проверьте оценки ученика!";
                })
                .collect(Collectors.joining()) + "ОСТАЛЬНЫЕ ОТЧИСЛЕНЫ!";
    }
}
