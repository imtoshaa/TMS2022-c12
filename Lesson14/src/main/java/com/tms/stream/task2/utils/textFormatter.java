package com.tms.stream.task2.utils;

import org.apache.commons.lang3.StringUtils;

public abstract class textFormatter {

    public static String[] reformatAndSplit(String string) {
        return string.replace("-", "").split("[.!?]\\s*");
    }

    public static boolean checkForFiveWordsInSentence(String string) {
        return string.split(" ").length >= 5;
    }

    public static boolean checkPalindromeInSentence(String string) {
        for (String str : string.split(" ")) {
            return str.equalsIgnoreCase(StringUtils.reverse(str));
        }
        return false;
    }
}
