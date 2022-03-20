package com.tms.task1;

import java.util.*;
import java.util.stream.Collectors;

//1) Вывести список чисел, умноженных на 2. Список чисел задаем рандомно.
public class Task1 {

    public static void main(String[] args) {
        Set<Integer> numbers = randomIntsGenerator(5);
        System.out.println("Исходный массив");
        numbers.forEach(System.out::println);
        System.out.println("Новый массив");
        numbers.stream()
                .map(operand -> operand * 2)
                .forEach(System.out::println);
    }

    public static Set<Integer> randomIntsGenerator(int count) { //используется и в таск2
        return new Random()
                .ints(count, 0, 101)
                .boxed()
                .collect(Collectors.toSet());
    }
}
