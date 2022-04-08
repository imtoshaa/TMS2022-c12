package com.tms.jdbc.task2;

import com.tms.jdbc.task2.model.Student;
import com.tms.jdbc.task2.utils.CRUDUtils;

public class Application {
    public static void main(String[] args) {
        Student student = new Student("Ivan", "Ivanov", 5, "Минск", "Москва");
        System.out.println("Saved students:");
        System.out.println(CRUDUtils.saveStudent(student));
        System.out.println("---------------------------------------------------");

        System.out.println("All students:");
        System.out.println(CRUDUtils.getAllStudents());
        System.out.println("---------------------------------------------------");

        System.out.println("Updated students:");
        System.out.println(CRUDUtils.updateStudent(1, 3, "Брест"));
        System.out.println("----------------------------------------------------");

        System.out.println("Deleted students: ");
        System.out.println(CRUDUtils.deleteStudent(2));
    }
}
