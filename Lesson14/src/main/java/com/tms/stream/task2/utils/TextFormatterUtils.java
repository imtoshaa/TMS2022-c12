package com.tms.stream.task2.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class TextFormatterUtils {

    public static String[] reformatAndSplit(String string) {
        return string.replace("-", "").replaceAll("\\r", "").replaceAll("\\n", "") .split("[.!?]");
    }

    public static boolean checkForFromThreeToFiveWordsInSentence(String string) {
        String[] splitString = string.split(" ");
        return splitString.length <= 5 && splitString.length >= 3;
    }

    public static boolean checkPalindromeInSentence(String string) {
        String[] sentence = string.split(" ");
        boolean isPalindromeInSentence = false;
        for (String str : sentence) {
            isPalindromeInSentence = str.equalsIgnoreCase(StringUtils.reverse(str)) && str.length() > 1;
        }
        return isPalindromeInSentence;
    }

    public static String[] splitText(String string) {
        return string.replace("-", "").split("[\n\r]");
    }

    public static String[] splitBlackList(String string) {
        return string.split(", ");
    }

    private static String[] getWordsFromTheSentence(String sentence) {
        return sentence.split(" ");
    }

    public static boolean isWordInTheSentence(String sentence, String word) {
        for (String str : getWordsFromTheSentence(sentence)) {
            if (str.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}
