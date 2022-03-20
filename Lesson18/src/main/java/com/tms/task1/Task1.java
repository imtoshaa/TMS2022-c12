package com.tms.task1;

import com.tms.task1.model.Student;
import com.tms.task1.model.University;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    //    * 1) Создать класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
//     * Создать коллекцию, содержащую объекты класса Student. Перебрать всех студентов, вычислить средний балл
//     * каждого студента. Если средний балл >=3, студент переводится на следующий курс, иначе отчисляется.
    public static void main(String[] args) throws Exception {
        List<Integer> gradesOfIvan = Arrays.asList(3, 2, 4, 1, 1);
        Student ivan = Student.builder()
                .course(2)
                .grades(gradesOfIvan)
                .isStudies(true)
                .group(12)
                .name("Иван Иванов")
                .build();

        List<Integer> gradesOfPetr = Arrays.asList(6, 10, 9, 8, 6);
        Student petr = Student.builder()
                .course(3)
                .grades(gradesOfPetr)
                .isStudies(true)
                .group(14)
                .name("Пётр Петров")
                .build();

        List<Student> students = new ArrayList<>();
        students.add(petr);
        students.add(ivan);

        University university = new University(students);
        System.out.println(university.viewingStudentProgress());
    }
}
