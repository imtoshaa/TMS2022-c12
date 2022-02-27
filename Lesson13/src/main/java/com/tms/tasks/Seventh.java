package com.tms.tasks;

public class Seventh {

    //     * 7*(Можно не делать!))Найти количество слов, содержащих только символы латинского алфавита. Пример:
    //            * "Методы доступа называют ещё аксессорами (от англ. access — доступ), или по отдельности —
    //            геттерами (англ. get — чтение) and сеттерами (англ. set — запись)"
    //            */
    public static void main(String[] args) {
        String string = "Методы доступа называют ещё аксессорами (от англ. access — доступ), или по отдельности —\n" +
                "геттерами (англ. get — чтение) and сеттерами (англ. set — запись) hello world аfrica";
        System.out.println("Слов, написанных латиницей: " + getCountEnglishWords(string));
    }

    private static int getCountEnglishWords(String string) {
        int count = 0;
        for (String str : string.split(" ")) {
            if (str.matches("^[a-zA-Z().]+$")) {
                count++;
            }
        }
        return count;
    }

}

