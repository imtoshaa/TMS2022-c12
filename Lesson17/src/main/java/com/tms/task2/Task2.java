package com.tms.task2;

import com.tms.task1.Task1;

import java.util.Set;

public class Task2 {
    //    2) Определение количества четных чисел в потоке данных.
//     * Создаем коллекцию Set<Integer> в которую добавляем рандомно 50 чисел от 0 до 100
    public static void main(String[] args) {
        Set<Integer> set = Task1.randomIntsGenerator(50);
        long count;
        System.out.println(count = set.stream()
                .filter(integer -> integer % 2 == 0)
                .count());
    }
}
