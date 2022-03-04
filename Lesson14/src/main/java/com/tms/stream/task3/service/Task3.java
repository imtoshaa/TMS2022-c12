package com.tms.stream.task3.service;

import com.tms.stream.task2.model.TextHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task3 {
    //    * 3) Проверка на цензуру:
//            * Создаете 2 файла.
//     * 1 - й. Содержит исходный текст.
//     * 2 - й. Содержит слова недопустимые в тексте (black list). Структура файла определите сами,
//     хотите каждое слово на новой строке, хотите через запятую разделяйте.
//            * Задача: необходимо проверить проходит ли текст цензуру.
//            Если в тексте не встретилось ни одного недопустимого слова, то выводите сообщение
//            о том что текст прошел проверку на цензуру.
//     * Если нет, то выводите соответствующее сообщение, кол-во предложений не
//     прошедших проверку и сами предложения подлежащие исправлению.
    public static void main(String[] args) {
        String input = "D:\\WorkProgrammer\\TMS2022-c12\\Lesson14\\src\\main\\resources\\hw3\\input.txt";
        String blackList = "D:\\WorkProgrammer\\TMS2022-c12\\Lesson14\\src\\main\\resources\\hw3\\blacklist.txt";
        String output = "D:\\WorkProgrammer\\TMS2022-c12\\Lesson14\\src\\main\\resources\\hw3\\output.txt";
        try (FileInputStream fisText = new FileInputStream(input);
             FileInputStream fisBlackList = new FileInputStream(blackList);
             FileOutputStream fileOutputStream = new FileOutputStream(output)) {
            byte[] buffer = new byte[fisText.available()];
            byte[] blacklist = new byte[fisBlackList.available()];
            fisText.read(buffer, 0, buffer.length);
            fisBlackList.read(blacklist, 0, blacklist.length);
            TextHandler textHandler = new TextHandler(new String(buffer), new String(blacklist));
            byte[] outPutText = textHandler.outPutCensoredSentence();
            fileOutputStream.write(outPutText, 0, outPutText.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
