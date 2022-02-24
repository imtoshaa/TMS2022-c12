package com.tms.tasks.foutth.service;

import com.tms.tasks.foutth.model.TextHandler;

public class FourthMain {
    //    4) Есть строка в которой содержится текст, предложения разделены точками.
    //            * После запуска программы на экран должны выводиться только те предложения в которых от 3-х до 5-ти слов.
    //            * Если в предложении присутствует слово-палиндром, то не имеет значения какое количество слов в предложении,
    //            оно выводится на экран.
    public static void main(String[] args) {
        TextHandler textHandler = new TextHandler("Какое-то тестовое предложение. Шалаш стоит в лесу. " +
                "Ещё одно какое-то тестовое предложение. Дед нагнал много самогона");
        System.out.println(textHandler.outPutSentences());

    }



}
