package com.tms.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s = reader.readLine();
//        System.out.println("Считал строку: ");
//        System.out.println(s);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        //меняем знаки пунктуации на пробелы и сплитим по пробелам
        s.lines()
                .map(s1 -> s1.toLowerCase()
                        .replaceAll("[\\p{Punct}]", " ")
                        .split("\\s+"))
                .flatMap(Arrays::stream)
                //как в лессон 17
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().
                sorted(Map.Entry.comparingByKey())
                .sorted(Comparator.comparing((Function<Map.Entry<String, Long>, Long>) Map.Entry::getValue)
                        .reversed())
                .map(Map.Entry::getKey)
                .limit(10)
                .forEach(System.out::println);
    }

}
