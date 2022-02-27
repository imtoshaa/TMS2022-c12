package com.tms.tasks.sixth.service;

import com.tms.tasks.sixth.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class SixthMain {
    //    * 6)Создать класс Employee, у которого есть переменные класса - String fullname, double salary.
    //            * Создать массив содержащий несколько объектов этого типа. Создать класс Report (по возможности интерфейс),
    //     * который будет содержать метод generateReport, в котором выводится информация о зарплате всех сотрудников.
    //            * Используйте форматировании строк(https://javarush.ru/quests/lectures/questmultithreading.level02.lecture06)
    //            * Пусть salary будет выровнено по правому краю, десятичное значение имеет 2 знака после запятой и по
    //            одной первой букве имени и отчества через точки.
    //                                                       * Пример: | Л.Н. Толстой		|		200.34|
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(Employee.builder()
                .fullName("Лев Николаевич Толстой")
                .salary(200.3456).build());
        employees.add(Employee.builder()
                .fullName("Александр Сергеевич Пушкин")
                .salary(451.123546352).build());
        employees.add(Employee.builder()
                .fullName("Антон Геннадьевич Овсейчик")
                .salary(4500.9342).build());
        ReportAware reportAware = new Report();
        reportAware.generateReport(employees);
    }
}
