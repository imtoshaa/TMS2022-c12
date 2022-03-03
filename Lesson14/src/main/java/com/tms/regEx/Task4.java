package com.tms.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
//    4*)со звездочкой! Предложение состоит из нескольких слов, разделенных пробелами.
//    Например: "One two three раз два три one1 two2 123 ".
//            *  Найти количество слов, содержащих только символы латинского алфавита.
//     *  Необходимо составить регулярное выражение и вызвать его в методе split(Regexp)
//     *  String str = "One two three раз два три one1 two2 123 ";
//     *  System.out.println(str.split("регулярное выражение").length);
//     *  Подсказка: тут надо использовать:
//            *  1) группы ()
//     *  2) | - оператор или
//     *  3) [] - группировки символов
//     *  4) +,* - квантификаторы

    public static void main(String[] args) {
        String text = "One two three раз два три one1 two2 123 last";
        System.out.println(text.split("[a-zA-Z].+?([a-zA-Z]+ | \\s)").length);
    }
}
