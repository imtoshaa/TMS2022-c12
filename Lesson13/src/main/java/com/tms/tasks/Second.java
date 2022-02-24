package com.tms.tasks;

public class Second {
    //    2) Заменить все вхождения символа стоящего в позиции (3) на символ стоящий в позиции 0
    public static void main(String[] args) {
        System.out.println(replaceSymbolThreeWithZero("у23tt34t1"));
    }

    private static String replaceSymbolThreeWithZero(String string) {
        return string.replace(string.charAt(3), string.charAt(0));
    }
}
