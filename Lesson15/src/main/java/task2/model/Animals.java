package task2.model;

import java.io.Serializable;

public class Animals implements AnimalsAware, Serializable {

    String name;
    int age;

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void say() {
        System.out.println("Говорю!");
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
