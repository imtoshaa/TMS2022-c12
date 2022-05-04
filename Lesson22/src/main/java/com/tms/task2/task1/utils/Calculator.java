package com.tms.task2.task1.utils;

import lombok.experimental.UtilityClass;

/* Взял из домашки с дженериками */

@UtilityClass
public class Calculator {
    public static <T extends Number, K extends Number> double sum(T t, K k) {
        return t.doubleValue() + k.doubleValue();
    }

    public static <T extends Number, K extends Number> double multiply(T t, K k) {
        return t.doubleValue() * k.doubleValue();
    }

    public static <T extends Number, K extends Number> double divide(T t, K k) {
        return t.doubleValue() / k.doubleValue();
    }

    public static <T extends Number, K extends Number> double subtraction(T t, K k) {
        return t.doubleValue() - k.doubleValue();
    }
}
