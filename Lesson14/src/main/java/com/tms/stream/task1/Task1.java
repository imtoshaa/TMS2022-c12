package com.tms.stream.task1;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    //    * 1)В исходном файле hw1/blacklist.txt находятся слова, каждое слово на новой строке.
//     * После запуска программы должен создать файл output.txt, который будет содержать в себе только палиндромы.
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(
                "D:\\WorkProgrammer\\TMS2022-c12\\Lesson14\\src\\main\\resources\\hw1\\blacklist.txt");
             FileOutputStream fileOutputStream = new FileOutputStream(
                     "D:\\WorkProgrammer\\TMS2022-c12\\Lesson14\\src\\resources\\java\\hw1\\output.txt")) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer, 0, buffer.length);
            fileOutputStream.write(outputPalindromes(buffer), 0, outputPalindromes(buffer).length);
//            System.out.println(new String(outputPalindromes(buffer)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private static byte[] outputPalindromes(byte[] buffer) {
        String str = new String(buffer);
        List<String> strings = new ArrayList<>(List.of(str.split("\\r\\n")));
        strings.removeIf(temp -> !temp.equalsIgnoreCase(StringUtils.reverse(temp))); //копирнул и доработал из старой домашки
        String newString = strings.toString();
        return newString.getBytes();
    }
}
