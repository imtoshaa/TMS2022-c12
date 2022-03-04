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
        String input = "D:\\WorkProgrammer\\TMS2022-c12\\Lesson14\\src\\main\\resources\\hw1\\input.txt";
        String output = "D:\\WorkProgrammer\\TMS2022-c12\\Lesson14\\src\\main\\resources\\hw1\\output.txt";
        try (FileInputStream fileInputStream = new FileInputStream(input);
             FileOutputStream fileOutputStream = new FileOutputStream(output)) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer, 0, buffer.length);
            byte[] palindromes = outputPalindromes(buffer);
            fileOutputStream.write(palindromes, 0, palindromes.length);
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
