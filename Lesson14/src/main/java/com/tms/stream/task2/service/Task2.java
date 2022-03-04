package com.tms.stream.task2.service;

import com.tms.stream.task2.model.TextHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task2 {
    ///    * 2)Текстовый файл hw2/blacklist.txt содержит текст.
//     * После запуска программы в другой файл должны записаться только те предложения, в которых от 3-х до 5-ти слов.
//            * Если в предложении присутствует слово-палиндром, то не имеет значения какое кол-во слов в предложении,
//            оно попадает в output.txt файл.
//            * Пишем все в ООП стиле. Создаем класс TextFormatter
//     * в котором два метода:
//            * 1. Метод принимает строку и возвращает кол-во слов в строке.
//            * 2. Метод принимает строку и проверяет есть ли в строке слово-палиндром. Если есть возвращает true, если нет false
//            * В main считываем файл.
//            * Разбиваем текст на предложения. Используя методы класса TextFormatter определяем подходит ли нам предложение.
//     * Если подходит добавляем его в output.txt файл
    public static void main(String[] args) {
        String input = "D:\\WorkProgrammer\\TMS2022-c12\\Lesson14\\src\\main\\resources\\hw2\\input.txt";
        String output = "D:\\WorkProgrammer\\TMS2022-c12\\Lesson14\\src\\main\\resources\\hw2\\output.txt";
        try (FileInputStream fileInputStream = new FileInputStream(input);
             FileOutputStream fileOutputStream = new FileOutputStream(output)) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer, 0, buffer.length);
            TextHandler textHandler = new TextHandler(new String(buffer));
            byte[] outputText = textHandler.outPutSentences();
            fileOutputStream.write(outputText, 0, outputText.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
