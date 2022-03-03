package com.tms.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
//    * По  регулярным выражениям!
//            * 2) Дана строка "cab, ccab, cccab" Необходимо составить регулярное выражение,
//            сделать класс Pattern, Matcher, вызвать метод find и вывести слова на консоль
//     * Должно вывести:
//            * cab
//     * ccab
//     * cccab

    public static void main(String[] args) {
        String text = "cab, ccab, cccab";
        Pattern pattern = Pattern.compile("c.+?b");//ленивый, до первого совпадения
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }
}
