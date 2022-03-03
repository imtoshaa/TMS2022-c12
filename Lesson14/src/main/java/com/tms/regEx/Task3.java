package com.tms.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
//    3) Дана строка "Versions: Java  5, Java 6, Java   7, Java 8, Java 12."
//    Найти все подстроки "Java X", где X - число и распечатать их.

    public static void main(String[] args) {
        String text = "\"Versions: Java  5, Java 66, Java   7, Java 8, Java 12.";
        Pattern pattern = Pattern.compile("J.+?[0-9]+");//число от 0 до 9, а плюс означет, что может быть в любом количестве
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }
}
