package com.tms.tasks;

public class Fifth {
//    5)Даны строки разной длины (длина - четное число), необходимо вернуть ее два средних знака:
//            * Пример: "string" → "ri", "code" → "od", "Practice"→"ct".

    public static void main(String[] args) {
        System.out.println(getTwoMiddleChar("Practice"));
        System.out.println(getTwoMiddleChar("string"));

    }

    private static String getTwoMiddleChar(String string) {
        return string.substring(string.length() / 2 - 1, string.length() / 2 + 1);
    }
}
