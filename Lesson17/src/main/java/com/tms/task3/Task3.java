package com.tms.task3;

import java.util.Arrays;
import java.util.List;

//3) Вывести список имен, но с первой заглавной буквой. список имен: "john", "arya", "sansa"
public class Task3 {
    public static void main(String[] args) {
        List<String> persons = Arrays.asList("john", "arya", "sansa");
        persons.stream()
                .map(string -> Character.toUpperCase(string.charAt(0)) + string.substring(1).toLowerCase())
                .forEach(System.out::println);
    }
}
