package com.tms.soapService.SOAP.repositories;

import com.tms.soapService.SOAP.model.Sex;
import com.tms.soapService.SOAP.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepository {
    private final List<Student> studentList = new ArrayList<>();

    @PostConstruct
    public void initData() {
        Student student1 = new Student();
        student1.setName("Alex");
        student1.setSurname("Alexandrov");
        student1.setUniversity("Cambridge");
        student1.setCourse(3);
        student1.setAge(20);
        student1.setSex(Sex.MALE);

        studentList.add(student1);

        Student student2 = new Student();
        student2.setName("Anton");
        student2.setSurname("Auseichyk");
        student2.setUniversity("BSTU");
        student2.setCourse(3);
        student2.setAge(22);
        student2.setSex(Sex.MALE);

        studentList.add(student2);

        Student student3 = new Student();
        student3.setName("Elisa");
        student3.setSurname("Rajkowa");
        student3.setUniversity("BSTU");
        student3.setCourse(5);
        student3.setAge(23);
        student3.setSex(Sex.FEMALE);

        studentList.add(student3);
    }

    public Student findStudent(String name, String surname) {
        Student result = null;

        for (Student student : studentList) {
            if (name.equals(student.getName()) && surname.equals(student.getSurname())) {
                result = student;
            }
        }

        return result;
    }
}
