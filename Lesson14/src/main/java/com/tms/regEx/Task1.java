package com.tms.regEx;

public class Task1 {
//    * По строкам дополнительная!
//            *  1) Даны строки разной длины c четным числом символов(казаки, просмотреть и так далее),
//     *  необходимо вернуть ее два средних знака.
//            * Например, если дана строка "string"  результат будет "ri", для строки "code" результат "od",  для "Practice" результат "ct".

    public static void main(String[] args) {
        System.out.println(getTwoMiddleChar("Practice"));
        System.out.println(getTwoMiddleChar("code"));
        System.out.println(getTwoMiddleChar("string"));

    }

    private static String getTwoMiddleChar(String string) {
        return string.substring(string.length() / 2 - 1, string.length() / 2 + 1);
    }
}
